/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMap
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

import java.util.HashMap;
import java.util.Map;

/**
 * @program: com.example.lishuiduijie_test.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-13
 **/
public class TestMap {
    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("1","one");
        testMap.put("2","two");
        System.out.println(testMap.size());
        for(String key: testMap.keySet()){
            System.out.println(key+ testMap.get(key));
        }
    }

}