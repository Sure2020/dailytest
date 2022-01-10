/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestSubString
 * Date Created : 2022-01-04
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-01-04       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2022-01-04
 **/
public class TestSubString {
    public static void main(String[] args) {
        System.out.println("TestSubString");
        String str = "/h3coasis/local_volumes/h3c_logs/pgpool/pgpool.log";
        String subStr = str.split("/")[1];
        System.out.println(subStr);
    }
}