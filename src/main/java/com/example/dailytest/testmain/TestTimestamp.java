/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestTimestamp
 * Date Created : 2022-03-02
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-03-02       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2022-03-02
 **/
public class TestTimestamp {
    public static void main(String[] args) {
        Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
        System.out.println("原始：" + timeStamp);
        System.out.println(timeStamp.toString().length());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));      // 时间戳转换成时间
        System.out.println("格式化结果：" + sd);
    }
}