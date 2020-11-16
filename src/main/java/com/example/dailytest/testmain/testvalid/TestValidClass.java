/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestValidClass
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

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @program: com.example.dailytest.testmain.testvalid
 * @description: xxx
 * @author: w15021
 * @create: 2020-11-16
 **/
@Data
public class TestValidClass {
    @NotEmpty(message = "param1不能为空值")
    String param1;
    @NotNull(message = "param2不能为null")
    String param2;
}