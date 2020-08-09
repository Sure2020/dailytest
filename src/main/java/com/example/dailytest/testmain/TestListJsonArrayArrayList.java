/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestListJsonArrayArrayList
 * Date Created : 2020-08-09
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-08-09       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-08-09
 **/
public class TestListJsonArrayArrayList {


    public static void main(String[] args) {
        List tempJSONArray = new JSONArray();
        tempJSONArray.add("jsonarray_a");
        tempJSONArray.add("jsonarray_b");
        System.out.println(tempJSONArray.toString());

        List tempArrayList = new ArrayList();
        tempArrayList.add("arraylist_a");
        tempArrayList.add("arraylist_b");
        System.out.println(tempArrayList.toString());
        //ArrayList中的元素是Object类型，不能直接赋值给String对象
        //String tempString = tempArrayList.get(1);
        System.out.println(tempArrayList.get(1));

        if(tempJSONArray instanceof List) {
            System.out.println("tempJSONArray instanceof List");
        }
        if(tempArrayList instanceof List) {
            System.out.println("tempArrayList instanceof List");
        }
    }
}