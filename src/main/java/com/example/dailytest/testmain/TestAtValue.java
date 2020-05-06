/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestAtValue
 * Date Created : 2020-03-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.example.dailytest.utils.ConstantProperties;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.example.lishuiduijie_test.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-13
 **/
@RestController
public class TestAtValue {
//    @Value("${testValue}")
//    static String testValue;
//    @Value("{lishuiduijie.testValue}")
//    static String testValue2;
//
//    @Value("${lishuiduijie.testValue}")
//    static String lishuiduijieTestValue;
    /*@Autowired
    static ConstantProperties constantProperties;
    public static void main(String args[]){
        System.out.println(constantProperties.getTestValue());
    }*/

    //@Test
    public String testAtValue(){
        System.out.println(ConstantProperties.getTestValue());
        System.out.println(ConstantProperties.getCallbackBaseUrl());
        return ConstantProperties.getCallbackBaseUrl();
    }
}