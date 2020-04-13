/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ConstantProperties
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

package com.example.dailytest.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: com.example.lishuiduijie_test.utils
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-13
 **/
@Component
public class ConstantProperties {


    private static String testValue;
    private static String callbackBaseUrl;

    public static String getTestValue() {
        return testValue;
    }

    @Value("${lishuiduijie.testValue}")
    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    public static String getCallbackBaseUrl() {
        return callbackBaseUrl;
    }

    @Value("${lishuiduijie.callbackBaseUrl}")
    public void setCallbackBaseUrl(String callbackBaseUrl) {
        this.callbackBaseUrl = callbackBaseUrl;
    }
}