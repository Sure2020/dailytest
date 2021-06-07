/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Calendar
 * Date Created : 2021-06-07
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-06-07       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import java.util.Calendar;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2021-06-07
 **/
public class TestCalendar {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);

        System.out.println("当期时间: " + cal.getTime());
        System.out.println("日期: " + day);
        System.out.println("月份: " + month);
        System.out.println("年份: " + year);
        System.out.println("一周的第几天: " + dow);  // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
        System.out.println("一月中的第几天: " + dom);
        System.out.println("一年的第几天: " + doy);
    }
}