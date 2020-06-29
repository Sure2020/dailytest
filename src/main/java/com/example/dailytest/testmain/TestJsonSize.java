/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestJsonSize
 * Date Created : 2020-06-29
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-06-29       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSONObject;

/**
 * @program: com.example.dailytest.testmain
 * @description: JSONObject的size()方法获取json对象中的键值对个数
 * @author: w15021
 * @create: 2020-06-29
 **/
public class TestJsonSize {
    public static void main(String[] args) {
        JSONObject obj = new JSONObject();
        obj.put("a", "a");
        System.out.println(obj.size());
        obj.put("b", "b");
        System.out.println(obj.size());

        JSONObject obj2 = new JSONObject();
        obj2.put("a", "a");
        obj.put("c", obj2);
        System.out.println(obj.size());
        System.out.println(obj.toString());

        String sourceStr = "{\"_id\":\"a\",\"dbEntityTestIndexList\":{\"param1\":\"a\",\"param2\":\"a\"}}";
        obj = JSONObject.parseObject(sourceStr);
        System.out.println(obj.toString());
        System.out.println(obj.size());
    }
}