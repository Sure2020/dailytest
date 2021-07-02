/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ServerServiceDemo
 * Date Created : 2021-07-01
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-07-01       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @program: com.example.dailytest.webservice
 * @description: xxx
 * @author: w15021
 * @create: 2021-07-01
 **/
@WebService(name = "ServerServiceDemo", targetNamespace = "http://webservice.dailytest.example.com")
public interface ServerServiceDemo {
    @WebMethod
    String emrService(@WebParam String data);

}