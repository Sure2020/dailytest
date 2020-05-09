/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Test
 * Date Created : 2020-05-09
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-05-09       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testsynchronized;

/**
 * @program: com.example.dailytest.testsynchronized
 * @description: xxx
 * @author: w15021
 * @create: 2020-05-09
 **/
public class Test{

    public static void main(String[] args) {
        Test test1 = new Test();
        Test test2 = new Test();
        ThreadTest thread1 = new ThreadTest("线程1", test1);
        //ThreadTest thread2 = new ThreadTest("线程2", test1);  //(1)
        ThreadTest thread2 = new ThreadTest("线程2", test2);  //(2)
        thread1.start();
        thread2.start();
    }

    /*
    sychronized修饰普通方法的时候，锁是当前实例对象，每个实例对象一把锁，同一时刻只能一个线程获得锁。
    不同实例对象获取的锁不一样，不需等待其他实例对象锁的释放
     */
    /*public synchronized void method(){
        System.out.println(Thread.currentThread().getName()+" 获得锁");
        try {
            System.out.println("开始方法......");
            Thread.sleep(2000); //模拟做其他事情
            System.out.println("结束方法......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    /*
    sychronized修饰静态方法的时候，锁是当前类的Class对象，每个类对应一把锁，
    多线程不同实例对象同一时刻也只能是一个获得锁，其他必须等待锁的释放。
     */
    /*public synchronized static void method(){
        System.out.println(Thread.currentThread().getName()+" 获得锁");
        try {
            System.out.println("开始方法......");
            Thread.sleep(2000); //模拟做其他事情
            System.out.println("结束方法......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/

    /*
    sychronized（object）{} object为普通变量的时候，每个实例对象一把锁，同一时刻只能一个线程获得锁。
    不同实例对象获取的锁不一样，不需等待其他实例对象锁的释放
     */
    /*private Object object = new Object();

    public  void method(){
        synchronized (object) {
            System.out.println(Thread.currentThread().getName()+" 获得锁");
            try {
                System.out.println("开始方法......");
                Thread.sleep(2000); //模拟做其他事情
                System.out.println("结束方法......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

    /*
    sychronized（object）{} object为静态变量的时候，锁是当前类的Class对象，每个类对应一把锁，
    多线程不同实例对象同一时刻也只能是一个获得锁，其他必须等待锁的释放
     */
    /*private static  Object object = new Object();

    public  void method(){
        synchronized (object) {
            System.out.println(Thread.currentThread().getName()+" 获得锁");
            try {
                System.out.println("开始方法......");
                Thread.sleep(2000); //模拟做其他事情
                System.out.println("结束方法......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }*/

    /*
    sychronized（object）{} object为类Class的时候，锁是当前类的Class对象，每个类对应一把锁，
    多线程不同实例对象同一时刻也只能是一个获得锁，其他必须等待锁的释放
     */
    public void method(){
        synchronized (Test.class) {
            System.out.println(Thread.currentThread().getName()+" 获得锁");
            try {
                System.out.println("开始方法......");
                Thread.sleep(2000); //模拟做其他事情
                System.out.println("结束方法......");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

// 本例链接：https://www.jianshu.com/p/1e9b4950af16