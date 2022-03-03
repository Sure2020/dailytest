/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestURL
 * Date Created : 2022-03-03
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-03-03       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2022-03-03
 **/
public class TestURL {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        String address = "http://192.168.56.74/iot/devops/log/directory?logType=system&hostname=192.168.110.107";//requestUrl;//"https://www.baidu.com/";
        URL url = new URL(address);
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getPath());
        System.out.println(url.getFile());
        System.out.println(url.getProtocol());
        System.out.println(url.getQuery());
        URI uri = url.toURI();
        System.out.println(uri.getScheme());
        System.out.println(uri.getPort());
    }
}