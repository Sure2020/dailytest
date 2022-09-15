/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestObjectMapper
 * Date Created : 2022-09-14
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-09-14       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain.testObjectMapper;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2022-09-14
 **/
public class TestObjectMapper {
    public static void main(String[] args) {
        String str ="{\"apiList\":[{\"id\":\"a\"},{\"id\":\"b\"}]}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        JSONArray jsonArray = null;
        jsonArray = jsonObject.getJSONArray("apiList");
        for (int i = 0; i < jsonArray.size(); i++) {
            ObjectMapper objectMapper = new ObjectMapper();
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            TestObjectMapperClass o = objectMapper.convertValue(jsonObject1,TestObjectMapperClass.class);//通过convertValue方法将object对象转换为相应实体对象
            System.out.println(o.toString());
        }
        /*-----------------------------------
                java将Object对象转换成实体类对象
        https://blog.51cto.com/u_15049782/4307941*/
    }
}