/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestCreateJSONDataRunnable
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
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.UUID;

/**
 * @program: com.example.dailytest.testmain.testcreatejsondatamultithread
 * @description: xxx
 * @author: w15021
 * @create: 2020-11-17
 **/
public class TestCreateJSONDataRunnable implements Runnable {
    private int number;
    private List list;

    public TestCreateJSONDataRunnable(List list, int number){
        this.list = list;
        this.number = number;
    }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "   started   " + number);
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", uuid);
        for (int j = 1; j <=19 ; j++) {
            String keyName = "value"+Integer.toString(j);
            jsonObject.put(keyName, uuid);
        }
        list.add(jsonObject);
        System.out.println(Thread.currentThread().getName() + "   ended   " + number);
        //System.out.println(jsonArray.toString());
        /*for (Object obj: jsonArray) {
            System.out.println(obj.toString());
        }*/
    }
}