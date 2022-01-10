/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMD5
 * Date Created : 2022-01-10
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-01-10       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import cn.hutool.crypto.digest.MD5;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2022-01-10
 **/
public class TestMD5 {
    public static void main(String[] args) {
        String test = "abc";
        MD5 md5 = new MD5();
        String result = md5.digestHex16(test);
        System.out.println(result);
    }
}