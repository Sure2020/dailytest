/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestFileExist
 * Date Created : 2021-01-28
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-01-28       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2021-01-28
 **/
public class TestFileExist {
    public static void main(String[] args) {
        System.out.println("TestFileExist");
        File file = null;
        try {
            file = ResourceUtils.getFile("E:\\temp\\1.txt");
            if(file.exists()){
                System.out.println("exist!");
            }else{
                System.out.println("not exist!");
            }

        } catch (FileNotFoundException e) {
            System.out.println("文件不存在！");
        }
    }
}