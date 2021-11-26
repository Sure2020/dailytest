/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestUploadFileApplication
 * Date Created : 2021-11-26
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-11-26       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testUploadFile;

import com.example.dailytest.testKongOauth2.TestKongOauth2Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * @program: com.example.dailytest.testUploadFile
 * @description: xxx
 * @author: w15021
 * @create: 2021-11-26
 **/

@SpringBootApplication(scanBasePackages = {"com.example.dailytest.testUploadFile"})
public class TestUploadFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestUploadFileApplication.class, args);
    }
}