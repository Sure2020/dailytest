/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestObjectMapperClass
 * Date Created : 2022-09-14
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-09-14       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain.testObjectMapper;

/**
 * @program: com.example.dailytest.testmain.testObjectMapper
 * @description: xxx
 * @author: w15021
 * @create: 2022-09-14
 **/
public class TestObjectMapperClass {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TestObjectMapperClass() {
    }

    public TestObjectMapperClass(String a) {
        this.id = a;
    }

    @Override
    public String toString() {
        return "TestObjectMapperInternalClass{" +
                "a='" + id + '\'' +
                '}';
    }
}