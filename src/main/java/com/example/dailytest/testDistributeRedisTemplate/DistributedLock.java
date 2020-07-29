/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DistributedLock
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
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-28
 **/
// DistributedLock.java 顶级接口

public interface DistributedLock {

    public static final long TIMEOUT_MILLIS = 30000;

    public static final int RETRY_TIMES = Integer.MAX_VALUE;

    public static final long SLEEP_MILLIS = 500;

    public boolean lock(String key);

    public boolean lock(String key, int retryTimes);

    public boolean lock(String key, int retryTimes, long sleepMillis);

    public boolean lock(String key, long expire);

    public boolean lock(String key, long expire, int retryTimes);

    public boolean lock(String key, long expire, int retryTimes, long sleepMillis);

    public boolean releaseLock(String key);
}