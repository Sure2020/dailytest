/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestValidOrdinaryClass
 * Date Created : 2020-11-16
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-11-16       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain.testvalid;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @program: com.example.dailytest.testmain.testvalid
 * @description: xxx
 * @author: w15021
 * @create: 2020-11-16
 **/
@Component
@Validated
public class TestValidOrdinaryClass {
    public String test(@NotNull(message = "不能为null") String param1, @NotEmpty(message = "不能为empty") String param2){
        System.out.println(param1);
        System.out.println(param2);
        return "test";
    }
}