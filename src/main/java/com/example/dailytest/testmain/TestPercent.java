/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestFloat
 * Date Created : 2020-12-21
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-12-21       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-12-21
 **/
public class TestPercent {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        double f = (double) a / (double) b;
        System.out.println(f);

        float price = (float) 1.2;
        DecimalFormat decimalFormat = new DecimalFormat(".00"); //构造方法的字符格式这里如果小数不足2位,会以0补足.
        String p = decimalFormat.format(f); //format 返回的是字符串
        System.out.println(p);

        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        float f1 = 0.21813f;
        float f2 = -0.21734f;
        try {
            numberFormat.setMaximumFractionDigits(2); //精确到3位。

            String s3 = numberFormat.format(f1);
            String s4 = numberFormat.format(f2);

            System.out.println("小数点数字转百分数字符串" + s3 + " , " + s4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}