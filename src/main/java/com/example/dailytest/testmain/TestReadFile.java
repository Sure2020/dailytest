/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestReadFile
 * Date Created : 2021-12-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-12-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2021-12-13
 **/
public class TestReadFile {
    public static void main(String[] args) throws IOException {
        String path = "E:\\workspace\\daliytest\\pom.xml";
        //For small files:
        String theSpecifiedLine = Files.readAllLines(Paths.get(path)).get(1);
        System.out.println(theSpecifiedLine);

        System.out.println("---------------");

        //For large files:
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            theSpecifiedLine = lines.skip(1).findFirst().get();
        }
        System.out.println(theSpecifiedLine);
    }
}