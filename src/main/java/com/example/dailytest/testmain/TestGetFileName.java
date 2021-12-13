/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestGetFileName
 * Date Created : 2021-12-08
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-12-08       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import io.swagger.annotations.ApiModelProperty;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2021-12-08
 **/
/*
 如果想要获得当前文件夹中的文件名只需要 String [] fileName = file.list();  就可以了。如果要包括文件中的文件名就可以用递归的方式。下面是两个具体的实现。

其中public static String [] getFileName(String path)是只得到当前文件中的文件名。public static void getAllFileName(String path,ArrayList<String> fileName)是包括当前文件及其子文件的文件名。

 https://www.cnblogs.com/wzihan/p/13395104.html
 */
public class TestGetFileName {
    public static void main(String[] args) {
        String path = "E:\\temp";
        //String path = "E:\\workspace\\api-doc\\api\\iot-base-ops";
        //String [] fileName = getFileName("E:\\workspace\\api-doc\\api\\iot-base-ops");
        String[] fileName = getFileName(path);
        for (String name : fileName) {
            //System.out.println(name);
        }
        //System.out.println("--------------------------------");
        ArrayList<String> listFileName = new ArrayList<String>();
        getAllFileName(path, listFileName);
        for (String name : listFileName) {
            //System.out.println(name);
        }
        //System.out.println("--------------------------------");

        List<DirectoryInfo> directoryInfoList =  new ArrayList<>();
        getAllFileNameWithParentChildrenStructure(path, directoryInfoList);
        System.out.println("directoryInfoList: " + directoryInfoList.size());
        printDirectoryInfo(directoryInfoList);
    }

    public static String[] getFileName(String path) {
        File file = new File(path);
        String[] fileName = file.list();
        return fileName;
    }

    public static void getAllFileName(String path, ArrayList<String> fileName) {
        File file = new File(path);
        File[] files = file.listFiles();
        String[] names = file.list();
        if (names != null)
            fileName.addAll(Arrays.asList(names));
        for (File a : files) {
            if (a.isDirectory()) {
                getAllFileName(a.getAbsolutePath(), fileName);
            }
        }
    }

    public static void getAllFileNameWithParentChildrenStructure(String path, List<DirectoryInfo> fileName) {
        File file = new File(path);
        File[] files = file.listFiles();
        //String[] names = file.list();
        if (files != null && files.length != 0) {

            for (File currentFile : files) {
                DirectoryInfo directoryInfo = new DirectoryInfo();
                String name = currentFile.getName();
                String type = currentFile.isDirectory() ? "folder" : "file";
                String absolutePath = currentFile.getAbsolutePath();

                directoryInfo.setName(name);
                directoryInfo.setType(type);
                directoryInfo.setAbsolutePath(absolutePath);
                if ("folder".equals(type)) {
                    List<DirectoryInfo> tempDirectoryInfoList = new ArrayList<>();
                    getAllFileNameWithParentChildrenStructure(absolutePath, tempDirectoryInfoList);
                    directoryInfo.setChildren(tempDirectoryInfoList);
                }

                fileName.add(directoryInfo);
            }
        }
    }

    public static class DirectoryInfo {
        @ApiModelProperty(value = "文件(夹)名称", example = "pgpool.log")
        private String name;

        @ApiModelProperty(value = "文件类型", example = "file或者folder")
        private String type;

        @ApiModelProperty(value = "文件绝对路径", example = "/h3coasis/local_volumes/h3c_logs/pgpool/pgpool.log")
        private String absolutePath;

        @ApiModelProperty(value = "子目录，数据结构和父目录结构一致")
        private List<DirectoryInfo> children;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAbsolutePath() {
            return absolutePath;
        }

        public void setAbsolutePath(String absolutePath) {
            this.absolutePath = absolutePath;
        }

        public List<DirectoryInfo> getChildren() {
            return children;
        }

        public void setChildren(List<DirectoryInfo> children) {
            this.children = children;
        }
    }
    public static void printDirectoryInfo(List<DirectoryInfo> directoryInfoList) {
        for (DirectoryInfo directoryInfo : directoryInfoList) {
            System.out.println(directoryInfo.getName() + " --- " + directoryInfo.getType() + " --- " + directoryInfo.getAbsolutePath());
            List<DirectoryInfo> children = directoryInfo.getChildren();
            if (children != null && children.size() != 0) {
                printDirectoryInfo(children);
            }
            System.out.println("-------------------------------");
        }
    }
}