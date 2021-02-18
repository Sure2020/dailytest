/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestReturnFinally
 * Date Created : 2021-02-18
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-02-18       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2021-02-18
 **/
public class TestReturnFinally {
    public static void main(String[] args) {
        System.out.println("TestReturnFinally");
        Object result = testReturnFinally();
        System.out.println(result.toString());
    }

    public static Object testReturnFinally() {

        try {
            String str = "a";
            if("ab".equals(str)){
                return "try";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally!");
        }
        return "end";
    }
    //实验证明，即使return语句在finally语句块之前执行，finally语句块也会执行！
}