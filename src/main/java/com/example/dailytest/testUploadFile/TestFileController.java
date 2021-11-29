/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestFileController
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

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @program: com.example.dailytest.testUploadFile
 * @description: xxx
 * @author: w15021
 * @create: 2021-11-26
 **/
@RestController
@RequestMapping("file")
@Slf4j
public class TestFileController {
    @Value("${file.upload.url}")
    private String uploadFilePath;

    @RequestMapping("/upload")
    public String httpUpload(@RequestParam("files") MultipartFile files[]){
        JSONObject object=new JSONObject();
        for(int i=0;i<files.length;i++){
            String fileName = files[i].getOriginalFilename();  // 文件名
            File dest = new File(uploadFilePath +'/'+ fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                files[i].transferTo(dest);
            } catch (Exception e) {
                log.error("{}",e);
                object.put("success",2);
                object.put("result","程序错误，请重新上传");
                return object.toString();
            }
        }
        object.put("success",1);
        object.put("result","文件上传成功");
        return object.toString();
    }

}