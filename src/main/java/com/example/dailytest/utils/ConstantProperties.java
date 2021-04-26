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

    // 智慧青城显鸿平台常量
    private static String grantType;
    private static String clientId;
    private static String clientSecret;
    private static String baseUrl;
    private static String getTokenPath;
    private static String getTokenMethod;
    private static String getDeviceListPath;
    private static String getDeviceListMethod;

    private static String headersAuthorization;

    private static String chengyunApiParkings;
    private static String chengyunKeyPrivate;

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

    // 智慧青城显鸿平台常量

    public static String getGrantType() {
        return grantType;
    }

    @Value("${zhihuiqingcheng.xianhong.grant_type}")
    public void setGrantType(String grantType) {
        ConstantProperties.grantType = grantType;
    }

    public static String getClientId() {
        return clientId;
    }

    @Value("${zhihuiqingcheng.xianhong.client_id}")
    public void setClientId(String clientId) {
        ConstantProperties.clientId = clientId;
    }

    public static String getClientSecret() {
        return clientSecret;
    }

    @Value("${zhihuiqingcheng.xianhong.client_secret}")
    public void setClientSecret(String clientSecret) {
        ConstantProperties.clientSecret = clientSecret;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    @Value("${zhihuiqingcheng.xianhong.baseUrl}")
    public void setBaseUrl(String baseUrl) {
        ConstantProperties.baseUrl = baseUrl;
    }

    public static String getGetTokenPath() {
        return getTokenPath;
    }

    @Value("${zhihuiqingcheng.xianhong.api.getToken.path}")
    public void setGetTokenPath(String getTokenPath) {
        ConstantProperties.getTokenPath = getTokenPath;
    }

    public static String getGetTokenMethod() {
        return getTokenMethod;
    }

    @Value("${zhihuiqingcheng.xianhong.api.getToken.method}")
    public void setGetTokenMethod(String getTokenMethod) {
        ConstantProperties.getTokenMethod = getTokenMethod;
    }

    public static String getGetDeviceListPath() {
        return getDeviceListPath;
    }

    @Value("${zhihuiqingcheng.xianhong.api.getDeviceList.path}")
    public void setGetDeviceListPath(String getDeviceListPath) {
        ConstantProperties.getDeviceListPath = getDeviceListPath;
    }

    public static String getGetDeviceListMethod() {
        return getDeviceListMethod;
    }

    @Value("${zhihuiqingcheng.xianhong.api.getDeviceList.method}")
    public void setGetDeviceListMethod(String getDeviceListMethod) {
        ConstantProperties.getDeviceListMethod = getDeviceListMethod;
    }

    public static String getHeadersAuthorization() {
        return headersAuthorization;
    }

    @Value("${zhihuiqingcheng.xianhong.headers.Authorization}")
    public void setHeadersAuthorization(String headersAuthorization) {
        ConstantProperties.headersAuthorization = headersAuthorization;
    }

    public static String getChengyunApiParkings() {
        return chengyunApiParkings;
    }

    @Value("${zhihuiqingcheng.chengyun.api.parkings}")
    public void setChengyunApiParkings(String chengyunApiParkings) {
        ConstantProperties.chengyunApiParkings = chengyunApiParkings;
    }

    public static String getChengyunKeyPrivate() {
        return chengyunKeyPrivate;
    }

    @Value("${zhihuiqingcheng.chengyun.key.private}")
    public void setChengyunKeyPrivate(String chengyunKeyPrivate) {
        ConstantProperties.chengyunKeyPrivate = chengyunKeyPrivate;
    }
}