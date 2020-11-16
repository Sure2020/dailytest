/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestValidController
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @program: com.example.dailytest.testmain.testvalid
 * @description: xxx
 * @author: w15021
 * @create: 2020-11-16
 **/
@RestController
public class TestValidController {
    @Autowired TestValidOrdinaryClass testValidOrdinaryClass;
    @RequestMapping("/test/valid/post")
    public String testValid(@Valid @RequestBody TestValidClass testValidClass){
        System.out.println(testValidClass);
        return "test valid post";
    }

    @RequestMapping("/test/valid/get")
    public String testValidGet(@RequestParam("param1") String param1, @RequestParam("param2") String param2 ){
        //TestValidOrdinaryClass testValidOrdinaryClass = new TestValidOrdinaryClass();
        testValidOrdinaryClass.test(param1,param2);
        //TestValidOrdinaryClass.test(param1,param2);
        return "test valid get";
    }
}