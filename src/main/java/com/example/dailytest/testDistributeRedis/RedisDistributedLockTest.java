/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : RedisDistributedLockTest
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

package com.example.dailytest.testDistributeRedis;

import redis.clients.jedis.Jedis;

/**
 * @program: com.example.dailytest.testDistributeRedis
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-28
 **/
public class RedisDistributedLockTest {
    static int n = 500;
    public static void secskill() {
        System.out.println(--n);
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            RedisDistributedLock lock = null;
            String unLockIdentify = null;
            try {
                Jedis conn = new Jedis("192.168.110.109",16379);
                lock = new RedisDistributedLock(conn, "test1");
                unLockIdentify = lock.acquire();
                System.out.println(Thread.currentThread().getName() + "正在运行");
                secskill();

                if (unLockIdentify != null){
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
                    lock.release(unLockIdentify);
                }
            }
        };

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
        Thread.sleep(30 * 1000);
    }
}
