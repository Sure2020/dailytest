/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestStopWatch
 * Date Created : 2020-09-04
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-09-04       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import org.springframework.util.StopWatch;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-09-04
 **/
public class TestStopWatch {
    public static void main(String[] args) throws InterruptedException {
        StopWatch sw1 = new StopWatch();
        StopWatch sw2 = new StopWatch();
        StopWatch sw_all = new StopWatch();

        sw_all.start("总耗时");

        sw1.start("校验耗时");
        Thread.sleep(1000);
        sw1.stop();
        System.out.println(sw1.prettyPrint());

        sw2.start("组装报文耗时");
        Thread.sleep(2000);
        sw2.stop();
        System.out.println(sw2.prettyPrint());

        sw1.start("请求耗时");
        Thread.sleep(1000);
        sw1.stop();

        sw2.start("my watch!");
        Thread.sleep(1000);
        sw2.stop();

        sw_all.stop();

        System.out.println(sw1.prettyPrint());
        System.out.println(sw2.prettyPrint());
        System.out.println("total "+sw1.getTotalTimeMillis());
        System.out.println("total "+sw1.getTotalTimeSeconds());
        System.out.println("total "+sw2.getTotalTimeMillis());
        System.out.println("total "+sw_all.getTotalTimeMillis());

        /*
        prettyPrint：用自带格式输出所有任务信息。
        getTaskInfo：获取所有任务的信息，即各个任务的名称和耗时。（如果想自定义输出一些内容，或者格式，可以从这里获取所有任务的信息）
        getTotalTimeMillis：获取任务总耗时（毫秒）。
        getTotalTimeSeconds：获取任务总耗时（秒）。
        getTaskCount：获取任务总数。
        getLastTaskName：获取最后一个任务的名称。
        getLastTaskTimeMillis：获取最后一个任务的耗时（毫秒）。
        getLastTaskInfo：获取最后一个任务的信息，即任务的名称和耗时。
         */
    }
}