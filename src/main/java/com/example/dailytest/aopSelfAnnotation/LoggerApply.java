/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : LoggerApply
 * Date Created : 2020-04-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-04-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.aopSelfAnnotation;

import org.springframework.stereotype.Component;

/**
 * @program: com.example.dailytest.aopSelfAnnotation
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-13
 **/
@Component
public class LoggerApply {

    @SelfAnnotation(module = "http://www.baidu.com/")
    public void myLogger(String event) throws Exception {
        System.out.println("myLogger(String event) : exampleUser will auth by blog address");
        throw new Exception();
    }
}