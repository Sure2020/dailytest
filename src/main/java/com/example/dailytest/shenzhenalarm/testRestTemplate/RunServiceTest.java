/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : RunServiceTest
 * Date Created : 2020-04-24
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-04-24       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.shenzhenalarm.testRestTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;

/**
 * @program: com.example.shenzhenalarm.testRestTemplate
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-24
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RunServiceTest {

    @Autowired
    DemoService demoService;

    @Test
    public void getTest() throws URISyntaxException {
        System.out.println("####");;
        //System.out.println(demoService.get());
        //System.out.println(demoService.getTimestamp());
        System.out.println(demoService.getTimeOffset());
        System.out.println(demoService.getTimeOffset2());
        System.out.println("####");
    }
}