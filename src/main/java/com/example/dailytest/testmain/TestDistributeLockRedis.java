/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestDistributeLockRedis
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

package com.example.dailytest.testmain;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-28
 **/

import redis.clients.jedis.Jedis;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Redis分布式锁    https://www.jianshu.com/p/c2b4aa7a12f1
 */
public class TestDistributeLockRedis {

    private Jedis jedisCli = new Jedis("192.168.110.109",16379);

    private int expireTime = 1;

    /**
     * 获取锁
     * @param lockID
     * @return
     */
    public boolean lock(String lockID){
        while(true){
            long returnFlag = jedisCli.setnx(lockID,"1");
            if (returnFlag == 1){
                System.out.println(Thread.currentThread().getName() + " get lock....");
                return true;
            }
            System.out.println(Thread.currentThread().getName() + " is trying lock....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /**
     * 超时获取锁
     * @param lockID
     * @param timeOuts
     * @return
     */
    public boolean lock(String lockID,long timeOuts){
        long current = System.currentTimeMillis();
        long future = current + timeOuts;
        long timeStep = 500;
        CountDownLatch latch = new CountDownLatch(1);
        while(future > current){
            long returnFlag = jedisCli.setnx(lockID,"1");
            if (returnFlag == 1){
                System.out.println(Thread.currentThread().getName() + " get lock....");
                jedisCli.expire(lockID,expireTime);
                return true;
            }
            System.out.println(Thread.currentThread().getName() + " is trying lock....");
            try {
                latch.await(timeStep, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            current = current + timeStep;
        }
        return false;
    }

    public void unlock(String lockId){
        long flag = jedisCli.del(lockId);
        if (flag>0){
            System.out.println(Thread.currentThread().getName() + " release lock....");
        }else {
            System.out.println(Thread.currentThread().getName() + " release lock fail....");
        }
    }

    /**
     * 线程工厂,命名线程
     */
    public static class MyThreadFactory implements ThreadFactory{
        public static AtomicInteger count = new AtomicInteger();
        @Override
        public Thread newThread(Runnable r) {
            count.getAndIncrement();
            Thread thread = new Thread(r);
            thread.setName("Thread-lock-test "+count);
            return thread;
        }
    }

    public static void main(String args[]){
        final String lockID = "test1";
        Runnable task = () ->{
            TestDistributeLockRedis testCli = new TestDistributeLockRedis();
            testCli.lock(lockID);
            System.out.println(Thread.currentThread().getName() + "   I'm working");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "   task finished");
            testCli.unlock(lockID);
        };

        MyThreadFactory factory = new MyThreadFactory();
        ExecutorService services = Executors.newFixedThreadPool(10);
        for (int i = 0;i<3;i++)
            services.execute(factory.newThread(task));
    }

}
