/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestStaticMethodAndAutowired
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: com.example.dailytest.testStaticMethodAndAutowired
 * @description:  http://jessehzx.top/2018/03/18/spring-autowired-static-field/
 * @author: w15021
 * @create: 2020-09-23
 **/
@Component
public class TestStaticMethodAndAutowired {
    private static TestStaticMethodAndAutowiredUtil testStaticMethodAndAutowiredUtil;
    @Autowired
    public TestStaticMethodAndAutowired(TestStaticMethodAndAutowiredUtil testStaticMethodAndAutowiredUtil){
        this.testStaticMethodAndAutowiredUtil = testStaticMethodAndAutowiredUtil;
    }
    public static void testStaticMethodAndAutowired(){
        System.out.println("TestStaticMethodAndAutowired");
        testStaticMethodAndAutowiredUtil.doSomething();
    }
}