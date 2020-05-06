/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestGetJSONObjKey
 * Date Created : 2020-04-29
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-04-29       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

/**
 * @program: com.example.dailytest.test
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-29
 **/
public class TestGetJSONObjKey {
    @Test
    public void getJSONObjKey() {
        JSONObject obj = new JSONObject();
        obj.put("key", "value");


        System.out.println(obj.keySet());
        for(Map.Entry<String,Object> entry : obj.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue().toString();
            System.out.println("key:::"+key);
            System.out.println("value:::"+value);
        }
    }
}