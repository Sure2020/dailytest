/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestCreateJSONData
 * Date Created : 2020-11-17
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-11-17       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StopWatch;

import java.util.UUID;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-11-17
 **/
public class TestCreateJSONData {
    public static void main(String[] args) {
        System.out.println("json!!!");
        JSONArray jsonArray = new JSONArray();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("Create JSON");
        for (int i = 1; i <=2000 ; i++) {
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", uuid);
            for (int j = 1; j <=19 ; j++) {
                String keyName = "value"+Integer.toString(j);
                jsonObject.put(keyName, uuid);
            }
            jsonArray.add(jsonObject);
        }
        stopWatch.stop();
        System.out.println("总耗时(ms): "+stopWatch.getTotalTimeMillis());
        //System.out.println(jsonArray.toString());
        /*for (Object obj: jsonArray) {
            System.out.println(obj.toString());
        }*/
    }
}