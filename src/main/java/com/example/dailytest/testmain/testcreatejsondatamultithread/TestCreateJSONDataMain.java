/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestCreateJSONDataMain
 * Date Created : 2020-11-17
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-11-17       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain.testcreatejsondatamultithread;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.assertj.core.util.Lists;
import org.springframework.util.StopWatch;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: com.example.dailytest.testmain.testcreatejsondatamultithread
 * @description: xxx
 * @author: w15021
 * @create: 2020-11-17
 **/
public class TestCreateJSONDataMain {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;

    //static JSONArray jsonArray = new JSONArray();
    static List<JSONObject> list = Collections.synchronizedList(Lists.newArrayList());
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("TestCreateJSONDataMain");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        for (int i = 0; i <2000 ; i++) {
            Runnable worker = new TestCreateJSONDataRunnable(list, i);
            threadPoolExecutor.execute(worker);
        }

        threadPoolExecutor.shutdown();
        while(!threadPoolExecutor.isTerminated()){
            //
        }
        System.out.println("Done");
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
        System.out.println(list.size());
        //System.out.println(list.toString());
    }
}