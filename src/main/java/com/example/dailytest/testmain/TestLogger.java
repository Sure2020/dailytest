/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestLogger
 * Date Created : 2020-03-08
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-08       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: com.example.lishuiduijie_test.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-08
 **/
public class TestLogger {

    private static Logger logger = LoggerFactory.getLogger(TestLogger.class);

    public static void testLogger(){
        logger.info("{} + {} = {}",1,2,3);
    }
}