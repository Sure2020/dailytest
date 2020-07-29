/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DistributedLockController
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

//import com.example.dailytest.testDistributeRedis.RedisDistributedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import redis.clients.jedis.Jedis;

/**
 * @program: com.example.dailytest.testDistributeRedisTemplate
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-28
 **/
@RestController
public class DistributedLockController {
    @Autowired
    RedisTemplate redisTemplate;
    @RequestMapping("/test/distributedLock/redisTemplate")
    public String testDistributedLockRedisTemplate() throws InterruptedException {

        Runnable runnable = () -> {
            RedisDistributedLock lock = null;
            //String unLockIdentify = null;
            Boolean unLockIdentify = false;
            try {
                //Jedis conn = new Jedis("192.168.110.109",16379);
                lock = new RedisDistributedLock(redisTemplate);
                unLockIdentify = lock.lock("testKey",1000,3,1000);
                System.out.println(Thread.currentThread().getName() + "正在运行");

                if (unLockIdentify){
                    System.out.println(Thread.currentThread().getName() + "   I'm doing something, it will cost 1 seconds");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "   task finished");
                } else {
                    System.out.println(Thread.currentThread().getName() + "   have not acquired lock");
                }


            } finally {
                if (lock != null) {
                    lock.releaseLock("testKey");
                }
            }
        };

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
        Thread.sleep(30 * 1000);


        return "testing DistributedLock via RedisTemplate";
    }
}