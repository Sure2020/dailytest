/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestTwoList
 * Date Created : 2020-09-21
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-09-21       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx   https://my.oschina.net/u/4281713/blog/3786508
 * @author: w15021
 * @create: 2020-09-21
 **/
public class TestTwoList {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");

        List<String> list2 = new ArrayList<String>();
        list2.add("B");
        list2.add("C");
        list1.forEach(s -> System.out.println(s));
        System.out.println("#########################");
        list2.forEach(s -> System.out.println(s));

        test3(list1, list2);
        list1.forEach(s -> System.out.println(s));
        System.out.println("#########################");
        list2.forEach(s -> System.out.println(s));

        test3(list2, list1);

        list1.forEach(s -> System.out.println(s));
        System.out.println("#########################");
        list2.forEach(s -> System.out.println(s));

        System.out.println("******************");
        System.out.println(list1);
        System.out.println(list2);
        List list3 = listRemove(list1, list2);
        System.out.println(list3);

    }

    public static void test3(List list1, List list2) {
        List<String> l1 = new ArrayList<String>(list1);
        List<String> l2 = new ArrayList<String>(list2);
        /*l1 = list1;
        l2 = list2;*/
        l1.removeAll(l2);
        System.out.println(l1);
    }

    public static List<String> listRemove(List list1, List list2) {
        List<String> l1 = new ArrayList<String>(list1);
        List<String> l2 = new ArrayList<String>(list2);
        l1.removeAll(l2);
        System.out.println(l1);

        return l1;
    }
}