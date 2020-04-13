/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Controller
 * Date Created : 2020-04-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-04-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.selfAnnotation;

/**
 * @program: com.example.dailytest.selfAnnotation
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-13
 **/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class Controller {

    private final static Logger logger = LoggerFactory.getLogger(Controller.class);

    /**
     * POST 方式接口测试
     * @param user
     * @return
     */
    @PostMapping("/user/login")
    @WebLog(description = "请求了用户登录接口")
    public User userLogin(@RequestBody User user) {
        logger.info("user login ...");
        return user;
    }

    /**
     * GET 方式接口测试
     * @return
     */
    @GetMapping("/user/{id}")
    @WebLog(description = "请求了用户登录接口")
    public String findUserInfo(@PathVariable("id") String userId) {
        logger.info("find user info ...");
        return "success";
    }

    /**
     * GET 方式接口测试
     * @return
     */
    @GetMapping("/test")
    public String test() {
        logger.info("testGet ...");
        return "success";
    }

    /**
     * 单文件上传接口测试
     * @return
     */
    @PostMapping("/file/upload")
    public String testFileUpload(@RequestParam("file") MultipartFile file) {
        logger.info("testFileUpload ...");
        return "success";
    }

    /**
     * 多文件上传接口测试
     * @return
     */
    @PostMapping("/multiFile/upload")
    public String testMultiFileUpload(@RequestParam("file") MultipartFile[] file) {
        logger.info("testMultiFileUpload ...");
        return "success";
    }
}