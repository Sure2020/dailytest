/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MicroGenerator
 * Date Created : 2020-10-20
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-10-20       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testoom;

/**
 * @program: com.example.dailytest.testoom
 * @description: xxx
 * @author: w15021
 * @create: 2020-10-20
 **/

import javassist.ClassPool;
public class MicroGenerator {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 100_000_000; i++) {
            generate("cn.moondev.User" + i);
        }
    }

    public static Class generate(String name) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        return pool.makeClass(name).toClass();
    }
}