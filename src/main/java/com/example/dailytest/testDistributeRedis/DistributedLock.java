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

package com.example.dailytest.testDistributeRedis;

/**
 * @program: com.example.dailytest.testDistributeRedis
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-28
 **/
public interface DistributedLock {
    /**
     * 获取锁
     * @author zhi.li
     * @return 锁标识
     */
    String acquire();

    /**
     * 释放锁
     * @author zhi.li
     * @param indentifier
     * @return
     */
    boolean release(String indentifier);
}
