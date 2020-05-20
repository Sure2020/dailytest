/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : RunServiceTest
 * Date Created : 2020-05-20
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-05-20       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testRestTemplate;

/**
 * @program: com.example.dailytest.testRestTemplate
 * @description: xxx
 * @author: w15021
 * @create: 2020-05-20
 **/
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URISyntaxException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RunServiceTest {

    @Autowired RunService runService;

    @Test
    public void getTest() throws URISyntaxException {
        runService.getTestGet();
        runService.getTestPost();
        runService.getTestPostParam();
        runService.getTestPut();
        runService.getTestDel();
    }
}