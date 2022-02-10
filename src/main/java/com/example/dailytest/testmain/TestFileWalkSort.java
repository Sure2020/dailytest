/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestFileWalkSort
 * Date Created : 2022-02-09
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-02-09       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2022-02-09
 **/
public class TestFileWalkSort {
    public static void main(String[] args) throws IOException {
        System.out.println("test");
        /*Files.walk(indir, 1, FileVisitOption.FOLLOW_LINKS)
                .sorted(Comparator.comparingLong(p -> p.toFile().lastModified()))
                .forEachOrdered(System.out::println);*/
        String fileDir = "/h3coasis/local_volumes/iotdevops/upload/images/temp/num";
        //String fileDir = "E:\\temp\\testsorted";
        File targetFilePath = new File(fileDir);
        List<Path> chunkFiles = Files.walk(targetFilePath.toPath())
                .filter(Files::isRegularFile)
                //.sorted(Comparator.comparingLong(p -> p.toFile().lastModified()))
                .sorted(new Comparator<Path>(){
                            @Override
                            public int compare(Path path1, Path path2) {
                                int chunkNumber1 = Integer.valueOf(path1.getFileName().toString());
                                int chunkNumber2 = Integer.valueOf(path2.getFileName().toString());
                                //System.out.println(chunkNumber1 + "   " + chunkNumber2);
                                if(chunkNumber1 > chunkNumber2 ){
                                    return 1;
                                } else if(chunkNumber1 == chunkNumber2){
                                    return 0;
                                } else {
                                    return -1;
                                }
                            }
                        })
                .collect(Collectors.toList());
        for (Path chunkFile : chunkFiles) {
            System.out.println(chunkFile.getFileName());
        }
    }

}