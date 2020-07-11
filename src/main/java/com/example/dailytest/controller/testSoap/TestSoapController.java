/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestSoapController
 * Date Created : 2020-07-11
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-11       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.controller.testSoap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBException;
import javax.xml.soap.SOAPException;

/**
 * @program: com.example.dailytest.controller
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-11
 **/

@RestController
public class TestSoapController {
    @RequestMapping("/test/soap")
    public void testSoap () throws JAXBException, SOAPException {
        SOAPClient.main(null);
    }
}