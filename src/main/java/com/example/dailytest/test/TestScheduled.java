/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestScheduled
 * Date Created : 2020-06-19
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-06-19       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: com.example.dailytest.test
 * @description: xxx
 * @author: w15021
 * @create: 2020-06-19
 **/
@Slf4j
@Component
public class TestScheduled {
    @Scheduled(cron = "* * * * * ?")
    public void testSchedule () {
        log.error("testing schedule");
    }
}