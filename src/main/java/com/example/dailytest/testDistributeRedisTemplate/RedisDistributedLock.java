/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : RedisDistributedLock
 * Date Created : 2020-07-28
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-28       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testDistributeRedisTemplate;

/**
 * @program: com.example.dailytest.testDistributeRedisTemplate
 * @description: RedisDistributedLock.java Redis分布式锁的实现
 * @author: w15021
 * @create: 2020-07-28
 **/
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.lettuce.core.ScriptOutputType;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;


public class RedisDistributedLock extends AbstractDistributedLock {

    private final Logger logger = LoggerFactory.getLogger(RedisDistributedLock.class);

    private RedisTemplate<Object, Object> redisTemplate;

    private ThreadLocal<String> lockFlag = new ThreadLocal<String>();

    public static final String UNLOCK_LUA;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call('get',KEYS[1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call('del',KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        UNLOCK_LUA = sb.toString();
    }

    //private static final String UNLOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    public RedisDistributedLock(RedisTemplate<Object, Object> redisTemplate) {
        super();
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean lock(String key, long expire, int retryTimes, long sleepMillis) {
        boolean result = setRedis(key, expire);
        // 如果获取锁失败，按照传入的重试次数进行重试
        while((!result) && retryTimes-- > 0){
            try {
                logger.info("lock failed, retrying..." + retryTimes);
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                return false;
            }
            result = setRedis(key, expire);
        }
        return result;
    }

    private boolean setRedis(String key, long expire) {
        //当redisTemplate操作redis的框架默认为lettuce时(sprintboot 2.x版本)
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                Object nativeConnection = connection.getNativeConnection();
                String status = null;
                RedisSerializer<String> stringRedisSerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();

                String uuid = UUID.randomUUID().toString();
                lockFlag.set(uuid);

                byte[] keyByte = stringRedisSerializer.serialize(key);
                byte[] uuidByte = stringRedisSerializer.serialize(uuid);

                //springboot 2.0以上的spring-data-redis 包默认使用 lettuce连接包

                //lettuce连接包，集群模式，ex为秒，px为毫秒
                if (nativeConnection instanceof RedisAdvancedClusterAsyncCommands) {
                    logger.info("lettuce Cluster:---key:"+key+"---value"+uuid+"---maxTimes:"+expire);
                    status = ((RedisAdvancedClusterAsyncCommands) nativeConnection)
                            .getStatefulConnection().sync()
                            .set(keyByte,uuidByte, SetArgs.Builder.nx().px(expire));
                    logger.info("lettuce Cluster:---status:"+status);
                }
                //lettuce连接包，单机模式，ex为秒，px为毫秒
                if (nativeConnection instanceof RedisAsyncCommands) {
                    logger.info("lettuce single:---key:"+key+"---value"+uuid+"---maxTimes:"+expire);
                    status = ((RedisAsyncCommands ) nativeConnection)
                            .getStatefulConnection().sync()
                            .set(keyByte,uuidByte, SetArgs.Builder.nx().px(expire));
                    logger.info("lettuce single:---status:"+status);
                }
                return status;
            }
        });
        logger.info("getLock:---result:"+result);//执行正确status="OK"
        return !StringUtils.isEmpty(result);


        //当redisTemplate操作redis的框架默认为Jedis时(sprintboot 1.x版本)
        //如果springboot是2.x版本，要想该段代码生效，需要在pom.xml中spring-boot-starter-data-redis依赖中排除掉lettuce
        /*try {
            String result = redisTemplate.execute(new RedisCallback<String>() {
                @Override
                public String doInRedis(RedisConnection connection) throws DataAccessException {
                    JedisCommands commands = (JedisCommands) connection.getNativeConnection();
                    String uuid = UUID.randomUUID().toString();
                    lockFlag.set(uuid);
                    SetParams setParams = new SetParams();
                    setParams.px(expire);
                    setParams.nx();
                    //return commands.set(key, uuid, "NX", "PX", expire);
                    return commands.set(key, uuid,setParams);
                }
            });
            return !StringUtils.isEmpty(result);
        } catch (Exception e) {
            logger.error("set redis occured an exception", e);
        }
        return false;*/
    }

    @Override
    public boolean releaseLock(String key) {
        // 释放锁的时候，有可能因为持锁之后方法执行时间大于锁的有效期，此时有可能已经被另外一个线程持有锁，所以不能直接删除
        try {
            List<String> keys = new ArrayList<String>();
            keys.add(key);
            List<String> args = new ArrayList<String>();
            String value = lockFlag.get();
            args.add(value);

            // 使用lua脚本删除redis中匹配value的key，可以避免由于方法执行时间过长而redis锁自动过期失效的时候误删其他线程的锁
            // spring自带的执行脚本方法中，集群模式直接抛出不支持执行脚本的异常，所以只能拿到原redis的connection来执行脚本

            Long result = redisTemplate.execute(new RedisCallback<Long>() {
                public Long doInRedis(RedisConnection connection) throws DataAccessException {
                    Object nativeConnection = connection.getNativeConnection();
                    RedisSerializer<String> stringRedisSerializer = (RedisSerializer<String>) redisTemplate.getKeySerializer();

                    // springboot 2.0以上的spring-data-redis 包默认使用 lettuce连接包
                    // lettuce连接包下序列化键值，否知无法用默认的ByteArrayCodec解析
                    byte[] keyByte = stringRedisSerializer.serialize(key);
                    byte[] valueByte = stringRedisSerializer.serialize(value);
                    Long evalResult = 0L;
                    // 集群模式和单机模式虽然执行脚本的方法一样，但是没有共同的接口，所以只能分开执行
                    //lettuce连接包，单机模式
                    if (nativeConnection instanceof RedisAsyncCommands) {
                        RedisAsyncCommands commands = (RedisAsyncCommands)nativeConnection;
                        // 同步方法执行、setnx禁止异步
                        byte[][] keysbytearray = {keyByte};
                        byte[][] valuesbytearray = {valueByte};
                        evalResult = (Long)commands.getStatefulConnection().sync().eval(
                                UNLOCK_LUA, ScriptOutputType.INTEGER, keysbytearray, valuesbytearray);
                        logger.info("unlock result: " + evalResult);
                        return evalResult;
                    }
                    // lettuce连接包，集群模式
                    else if (nativeConnection instanceof RedisAdvancedClusterAsyncCommands) {
                        RedisAdvancedClusterAsyncCommands clusterAsyncCommands = (RedisAdvancedClusterAsyncCommands) nativeConnection;
                        byte[][] keysbytearray = {keyByte};
                        byte[][] valuesbytearray = {valueByte};
                        evalResult = (Long)clusterAsyncCommands.getStatefulConnection().sync().eval(
                                UNLOCK_LUA, ScriptOutputType.INTEGER, keysbytearray, valuesbytearray);
                        //System.out.println("unlock: " + evalResult);
                        logger.info("unlock result: " + evalResult);
                        return evalResult;
                    }
                    // Jedis连接包集群模式
                    else if (nativeConnection instanceof JedisCluster) {
                        return (Long) ((JedisCluster) nativeConnection).eval(UNLOCK_LUA, keys, args);
                    }

                    // Jedis连接包单机模式
                    else if (nativeConnection instanceof Jedis) {
                        return (Long) ((Jedis) nativeConnection).eval(UNLOCK_LUA, keys, args);
                    }

                    else {
                        logger.error("未知的redis连接类型");
                    }
                    return 0L;
                }
            });

            return result != null && result > 0;
        } catch (Exception e) {
            logger.error("release lock occured an exception", e);
        }
        return false;
    }

}