/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestCollectionsSingletonList
 * Date Created : 2020-05-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-05-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-05-13
 **/
public class TestCollectionsSingletonList {
    public static void main(String args[]) {
        // create an array of string objs
        String init[] = { "One", "Two", "Three", "One", "Two", "Three" };

        // create one list
        List list = new ArrayList(Arrays.asList(init));

        System.out.println("List value before: "+list);

        // create singleton list
        list = Collections.singletonList("TP");

        System.out.println("List value after: "+list);

        System.out.println(Collections.singletonList("test"));
    }
}