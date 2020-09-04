/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestStringSplit
 * Date Created : 2020-09-01
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-09-01       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-09-01
 **/
public class TestStringSplit {
    public static void main(String[] args) {
        String sourceStr = "mysql://localhost:1521:orcl/view/yjs/user/password";
        String[] stringArray = sourceStr.split("\\/");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
        System.out.println("###");
        StringBuilder sb = new StringBuilder();
        sb.append(stringArray[2]);
        sb.append("/");
        sb.append(stringArray[3]);
        String dbUrl = sb.toString();
        System.out.println(dbUrl);
    }
}