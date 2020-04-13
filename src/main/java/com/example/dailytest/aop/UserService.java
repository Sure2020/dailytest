/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : UserService
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

import org.springframework.stereotype.Service;

/**
 * @program: com.example.lishuiduijie_test.aop
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-13
 **/
@Service
public class UserService {
    public String getUserById(Integer id) {
        System.out.println("getUserById(" + id + ")...");
        // 等待2秒
        try {
            Thread.sleep(2000);
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }

        return "testing aop !!!";
    }
}