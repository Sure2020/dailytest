/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DefaultUserAuthorization
 * Date Created : 2021-02-02
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-02-02       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.rocketapi;

import com.github.alenfive.rocketapi.extend.IUserAuthorization;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @program: com.example.dailytest.rocketapi
 * @description: xxx
 * @author: w15021
 * @create: 2021-02-02
 **/
@Component
public class DefaultUserAuthorization implements IUserAuthorization {
    public static String IOTINFOMGR = "iotinfomgr";
    @Override
    public String validate(String username, String password) {

        //return StringUtils.isEmpty(username)?"admin":username;
        if(IOTINFOMGR.equals(username) && IOTINFOMGR.equals(password)){
            return IOTINFOMGR;
        } else {
            return null;
        }
    }
}