/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Author
 * Date Created : 2020-07-01
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-01       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain.shallowAndDeepCopy;

import lombok.Data;

/**
 * @program: com.example.dailytest.testmain.shallowAndDeepCopy
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-01
 **/
@Data
public class Author {
    private String name;
    private String age;

    public Author(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Author () {}
}