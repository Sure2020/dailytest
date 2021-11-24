/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : JWTController
 * Date Created : 2021-11-19
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-11-19       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testJWT;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.example.dailytest.testJWT
 * @description: xxx
 * @author: w15021
 * @create: 2021-11-19
 **/

@RestController
@CrossOrigin
public class JWTController {
    @RequestMapping({ "/testjwt/hello" })
    public String hello() {
        return "Hello World";
    }
}