/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestThreadPoolController
 * Date Created : 2020-06-18
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-06-18       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testThreadPool.controller;

import com.example.dailytest.testThreadPool.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.example.dailytest.testThreadPool.controller
 * @description: xxx
 * @author: w15021
 * @create: 2020-06-18
 **/
@Slf4j
@RestController
public class TestThreadPoolController {

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/test/threadpool")
    public String submit(){
        log.info("start submit");

        //调用service层的任务
        asyncService.executeAsync();

        log.info("end submit");

        return "success";
    }
}