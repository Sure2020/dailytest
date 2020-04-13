/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestValueTrans
 * Date Created : 2020-04-01
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-04-01       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: com.example.lishuiduijie_test.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-01
 **/
public class TestValueTrans {
    public static JSONObject changeObj (JSONObject oldObj){
        Integer code = oldObj.getIntValue("code");
        System.out.println(oldObj.remove("code"));
        System.out.println(oldObj.remove("no"));
        //oldObj.remove("no");


        JSONObject trueResult = oldObj;

        JSONObject changedResultObj = new JSONObject();
        changedResultObj.put("code",code);
        changedResultObj.put("data",trueResult);
        return changedResultObj;



    }

    public static void main(String[] args) {
        JSONObject oldObj = new JSONObject();
        oldObj.put("code",0);
        oldObj.put("list",new ArrayList<>(Arrays.asList("a","b")));
        System.out.println(oldObj.toJSONString());
        oldObj = changeObj(oldObj);
        System.out.println(oldObj.toString());

    }



}