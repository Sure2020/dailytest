/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestThread
 * Date Created : 2020-08-19
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-08-19       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain.testthread;

/**
 * @program: com.example.dailytest.testmain.testthread
 * @description: xxx
 * @author: w15021
 * @create: 2020-08-19
 **/
public class TestThread extends Thread {
    @Override
    public void run() {
        //super.run();
        System.out.println("TestThread called");
        //System.out.println(this.getName());
        System.out.println(Thread.currentThread().getName());
    }
}