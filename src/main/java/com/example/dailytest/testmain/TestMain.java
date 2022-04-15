/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMain
 * Date Created : 2020-06-09
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-06-09       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-06-09
 **/
public class TestMain {
    /*static {
        System.out.println("Before Main!");
    }*/
    public static void main(String[] args) {
        System.out.println("Hello there!");
        /*List<String> resultDirectoryInfoList = new ArrayList<>();
        System.out.println(resultDirectoryInfoList.size());

        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(0); //最大小数位数
        Float f = 0.5323f;
        System.out.println(percentFormat.format(f));*/
        /*List list1 = Arrays.asList("1","2");
        List list2 = Arrays.asList("2","3");
        ArrayList tempList = (ArrayList) list1;
        ArrayList finalList = (ArrayList) list2;
        tempList.removeAll(list2);
        finalList.addAll(list1);
        System.out.println(finalList);*/
        List<String> stringList2_2 =  new ArrayList<>(Arrays.asList("a,b,c,h,x".split(",")));
        List<String> stringList_1 =  new ArrayList<>(Arrays.asList("a,b,c,i,j,d".split(",")));
        /*stringList2_2.removeAll(stringList_1);
        stringList_1.addAll(stringList2_2);
        System.out.println(stringList_1);*/
        System.out.println(getUnionOfTwoLists(stringList2_2, stringList_1));
    }
    static {
        System.out.println("Before Main!");
    }
    public static Object getUnionOfTwoLists (List list1, List list2) {
        List tempList = list1;
        List finalList = list2;
        tempList.removeAll(list2);
        finalList.addAll(list1);
        return finalList;
    }
}