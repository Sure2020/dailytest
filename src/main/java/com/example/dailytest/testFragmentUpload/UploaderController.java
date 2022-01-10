/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : UploaderController
 * Date Created : 2021-12-27
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-12-27       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testFragmentUpload;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @program: com.example.dailytest.testFragmentUpload
 * @description: xxx
 * @author: w15021
 * @create: 2021-12-27
 **/
public class UploaderController {

    @GetMapping( "/")
    public String page(){
        return "upload";
    }

    @PostMapping("upload")
    @ResponseBody
    public Boolean upload(MultipartFile file) {
        File savefile = new File("E:",file.getOriginalFilename());
        try {
            file.transferTo(savefile);//将文件保存E盘下
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}