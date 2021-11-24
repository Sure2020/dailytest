/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : JwtWithoutJpaApplication
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

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: com.example.dailytest.testJWT
 * @description: xxx
 * @author: w15021
 * @create: 2021-11-19
 **/

//加上该注释后，就可以将该包下面的代码单独运行
@SpringBootApplication(scanBasePackages = {"com.example.dailytest.testJWT"})
public class JwtWithoutJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtWithoutJpaApplication.class, args);
    }
}