/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestStringToNumber
 * Date Created : 2021-06-11
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-06-11       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2021-06-11
 **/
public class TestStringToNumber {
    public static void main(String[] args) {
        String string = "99.31%";
        String subStr = string.split("%")[0];
        float f = Float.valueOf(subStr);
        float f2 = 100.0f - f;
        System.out.println(subStr);
        System.out.println(f);
        System.out.println(f2);

        double  price= 1.2;
        DecimalFormat decimalFormat= new DecimalFormat( ".00" ); //构造方法的字符格式这里如果小数不足2位,会以0补足.
        String p=decimalFormat.format(price); //format 返回的是字符串
        System.out.println(Float.valueOf(p));
        System.out.println(Float.valueOf(decimalFormat.format(f2)));
        System.out.println("###");
        System.out.println(231d/2500d);
        String rate = decimalFormat.format(2331d/2500d);
        System.out.println("rate: " + Float.valueOf(rate));
        System.out.println(Float.valueOf(rate) > 1);
    }
}