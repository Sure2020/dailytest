/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : HelloController
 * Date Created : 2020-04-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-04-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.example.dailytest.aop
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-13
 **/
@RestController
public class HelloController {

    @Autowired
    UserService userService;

    @GetMapping("/test/aop")
    public String test(Integer id) {
        return userService.getUserById(id);
    }
}