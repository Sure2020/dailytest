/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestRecursion
 * Date Created : 2020-07-14
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-14       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-14
 **/
public class TestRecursion {
    /*
    递归三要素

    1、明确递归终止条件；
    2、给出递归终止时的处理办法；
    3、提取重复的逻辑，缩小问题规模。
     */

    public static void main(String[] args) {

        System.out.println("The factorial of 10 is " + factorial(10));


        //print 20 fibonacci sequence
        for (int i = 0; i < 20; i++) {
            System.out.print(fibonacci(i)+" ");
        }
    }

    //计算阶乘的方法，典型的递归方法
    public static long factorial(long n) {
        if (n >= 1) {
            //递归方法特点一：在方法中调用自己
            return n * factorial(n - 1);
        } else {
            //递归方法特点二：有至少一个出口条件
            return 1;
        }
    }

    //计算斐波那契数列的方法:斐波纳契数列以如下被以递归的方法定义：F（0）=0，F（1）=1，F（n）=F(n-1)+F(n-2)（n≥2，n∈N*）
    public static int fibonacci(int n){
        switch(n){
            //出口条件一
            case 0:
                return 0;
            //出口条件二
            case 1:
                return 1;
            //在方法中调用自己
            default:
                return fibonacci(n-1)+fibonacci(n-2);
        }
    }
}