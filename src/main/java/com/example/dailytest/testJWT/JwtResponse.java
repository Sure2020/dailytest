/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : JwtResponse
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

/**
 * @program: com.example.dailytest.testJWT
 * @description: xxx
 * @author: w15021
 * @create: 2021-11-19
 **/
import java.io.Serializable;

/**
 * @author james mu
 * @date 2020/9/7 19:11
 */
public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}