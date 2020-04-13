/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestSetEntry
 * Date Created : 2020-03-29
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-29       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.Set;

/**
 * @program: com.example.lishuiduijie_test.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-29
 **/
public class TestSetEntry {
    public static void main(String[] args) {
        JSONObject testObj = new JSONObject();
        testObj.put("one",1);
        testObj.put("two",2);
        testObj.put("two",2);

        System.out.println("testObj: "+ testObj);
        Set<Map.Entry<String, Object>> entries = testObj.entrySet();
        System.out.println("entries: "+ entries);

        for (Map.Entry<String, Object> entry : entries){
            System.out.println("entry: " + entry);
            System.out.println("entry key: " +entry.getKey());
            System.out.println("entry value: " + entry.getValue());
        }
    }
}