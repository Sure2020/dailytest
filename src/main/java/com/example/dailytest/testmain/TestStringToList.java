/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestStringToList
 * Date Created : 2021-04-16
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-04-16       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2021-04-16
 **/
public class TestStringToList {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        System.out.println(list);
        jsonObject.put("list",list);

        //String listFromJSONObject = jsonObject.getString("list");
        Object listFromJSONObject_object = jsonObject.get("list");
        System.out.println(listFromJSONObject_object);
        List<String> listFromObject = new ArrayList<String>();
        if(listFromJSONObject_object instanceof ArrayList<?>){
            for(Object o: (List<?>)listFromJSONObject_object){
                System.out.println(o);
                listFromObject.add(String.class.cast(o));
            }
        }
        System.out.println(listFromObject);
        for(String str : listFromObject) {
            System.out.println(str);
        }


    }
}