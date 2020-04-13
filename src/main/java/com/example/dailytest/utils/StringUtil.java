/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : StringUtil
 * Date Created : 2020-03-05
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-05       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.utils;

/**
 * @program: com.example.lishuiduijie_test.utils
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-05
 **/
public class StringUtil {

    public static boolean strIsNullOrEmpty(String s) {
        return (null == s || s.trim().length() < 1);
    }
}