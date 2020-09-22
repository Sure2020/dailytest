/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestDocument
 * Date Created : 2020-09-22
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-09-22       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSONObject;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-09-22
 **/
public class TestDocument {
    public static void main(String[] args) {
        Document document = new Document();
        document.append("a","a");
        document.append("b","b");
        System.out.println(document.get("b"));
        System.out.println(document.toString());
        document.forEach((k,v) -> {
            System.out.println(k);
            System.out.println(v);
        });

        List<Document> list1 = new ArrayList<>();
        list1.add(document);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a","a");
        jsonObject.put("b","b");
        List<JSONObject> list2 = new ArrayList<>();
        list2.add(jsonObject);

        System.out.println(list1);
        System.out.println(list2);
        list1.remove(list2);
        list2.remove(list1);
        System.out.println(list1);
        System.out.println(list2);

        List<Document> list3 = new ArrayList<>(list1);
        list1.remove(list3);
        System.out.println(list1);
    }
}