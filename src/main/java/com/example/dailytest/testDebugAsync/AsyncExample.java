/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : AsyncExample
 * Date Created : 2020-12-16
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-12-16       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testDebugAsync;

/**
 * @program: com.example.dailytest.testDebugAsync
 * @description: xxx
 * @author: w15021
 * @create: 2020-12-16
 **/
import java.util.*;
import java.util.concurrent.*;

public class AsyncExample {

    static List<Task> tasks = new ArrayList<>();
    static ExecutorService executor = Executors.newScheduledThreadPool(4);

    public static void main(String[] args) {
        createTasks();
        executeTasks();
    }

    private static void createTasks() {
        for (int i = 0; i < 20; i++) {
            tasks.add(new Task(i));
        }
    }

    private static void executeTasks() {
        for (Task task : tasks) {
            executor.submit(task);
        }
    }

    static class Task extends Thread {

        int num;

        public void run() {
            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printNum();
        }

        private void printNum() {
            // Set a breakpoint at the following line
            System.out.print(num + " ");
        }

        public Task(int num) {
            this.num = num;
        }
    }
}
