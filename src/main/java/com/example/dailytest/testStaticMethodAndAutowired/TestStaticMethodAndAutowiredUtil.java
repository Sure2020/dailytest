/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestStaticMethodAndAutowiredUtil
 * Date Created : 2020-09-23
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-09-23       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testStaticMethodAndAutowired;

import org.springframework.stereotype.Component;

/**
 * @program: com.example.dailytest.testStaticMethodAndAutowired
 * @description: xxx
 * @author: w15021
 * @create: 2020-09-23
 **/
@Component
public class TestStaticMethodAndAutowiredUtil {
    public void doSomething(){
        System.out.println("say something!");
    }
}