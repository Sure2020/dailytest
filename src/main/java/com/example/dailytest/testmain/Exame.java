/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Exame
 * Date Created : 2021-09-17
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-09-17       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import lombok.Data;

import java.util.Date;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2021-09-17
 **/
public class Exame {
    /*float f1(){
        int i=1;
        return;
    }
    float f2(){
        short i =2;
        return i;
    }
    float f3(){
        long i = 3;
        return i;
    }
    float f4(){
        double i = 4;
        return i;
    }*/
    public static void main(String[] args) {
        /*try{
            throw new Exception();
            //System.out.println(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(2);
        }
        finally {
            System.out.println(3);
        }
        System.out.println(4);*/
        /*String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1.equals(s2));
        System.out.println(s2==s3);
        System.out.println(s3.equals(s2));
        System.out.println(s1==s2);*/

        System.out.println("9dog".matches("\\ddog"));
        System.out.println(new Date(1000));
        System.out.println("\\hello\n");
        System.out.println("12hello567".replaceAll("[123456789]+","@"));

        /*Integer a = 100;
        Integer b = 100;
        Integer c = 200;
        Integer d = 200;
        long e = 100l;
        long f = 100l;
        long g = 200l;
        long h = 200l;

        System.out.println(a==b);
        System.out.println(g==h);
        System.out.println(c==d);
        System.out.println(e==f);*/
        /*String s = null;
        if(s!=null&(s.length()>0)){}
        if()*/

        System.out.println();
    }
}