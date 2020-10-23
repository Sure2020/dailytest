/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Wrapper
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

import java.util.Map;
import java.util.Random;

/**
 * @program: com.example.dailytest.testoom
 * @description: xxx
 * @author: w15021
 * @create: 2020-10-20
 **/

/*
126081
126082
126083
126084
Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded

Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"
 */
public class Wrapper {
    public static void main(String args[]) throws Exception {
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "value");
            System.out.println(map.size());
        }
    }
}