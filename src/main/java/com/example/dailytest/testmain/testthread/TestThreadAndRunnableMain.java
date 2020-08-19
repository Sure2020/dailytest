/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestThreadAndRunnableMain
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
public class TestThreadAndRunnableMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new TestThread());
        //thread.setName("my test thread");
        //thread.run();
        thread.start();

        Thread thread2 = new Thread(new TestRunnable());
        thread2.start();

        Thread testThread = new TestThread();
        testThread.start();

        /*Runnable testRunnable = new TestRunnable();
        testRunnable.run();*/
    }
}