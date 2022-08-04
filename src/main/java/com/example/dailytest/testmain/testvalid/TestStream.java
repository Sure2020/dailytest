/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestStream
 * Date Created : 2022-08-04
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-08-04       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain.testvalid;

import java.util.stream.Stream;

/**
 * @program: com.example.dailytest.testmain.testvalid
 * @description: xxx
 * @author: w15021
 * @create: 2022-08-04
 **/
public class TestStream {
    public static void main(String[] args) {
        boolean result = Stream.of("dox", "rex", "mi", "fa", "so", "la", "ti")
                .filter(str -> str.length() < 5)
                .peek(System.out::println)
                .allMatch(str -> str.length() > 2);
        System.out.println(result);
    }
}