/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMath
 * Date Created : 2020-06-03
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-06-03       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-06-03
 **/
public class TestMath {
    public static void main(String[] args) {
        /*
        round() 方法返回一个最接近的 int、long 型值，四舍五入。
        round 表示"四舍五入"，算法为Math.floor(x+0.5) ，即将原来的数字加上 0.5 后再向下取整，
        所以 Math.round(11.5) 的结果为 12，Math.round(-11.5) 的结果为 -11。
         */
        /*
        Math.ceil()执行向上舍入，即它总是将数值向上舍入为最接近的整数；
        Math.floor()执行向下舍入，即它总是将数值向下舍入为最接近的整数；
        Math.round()执行标准舍入，即它总是将数值四舍五入为最接近的整数
         */
        System.out.println(Math.round(-1.5));
        System.out.println(Math.floor(-1.5));
        System.out.println(Math.ceil(-1.5));
    }
}