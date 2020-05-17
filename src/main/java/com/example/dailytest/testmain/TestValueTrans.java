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
/*
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
}*/

public class TestValueTrans {

    public static void main(String[] args) {
        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        TestValueTrans.swap(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());

        //一个方法不能让对象参数引用一个新的对象。
        changeName(s1);
        System.out.println(s1.getName());
    }

    public static void swap(Student x, Student y) {
        Student temp = x;
        x = y;
        y = temp;
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }

    public static void changeName (Student student) {
        student.setName("小王");
    }

    public static class Student {
        private String name;

        Student (String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

/*
一个方法不能修改一个基本数据类型的参数（即数值型或布尔型）。
一个方法可以改变一个对象参数的状态。
一个方法不能让对象参数引用一个新的对象。
 */