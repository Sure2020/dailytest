/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestExcel
 * Date Created : 2020-09-07
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-09-07       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-09-07
 **/
public class TestExcel {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "E:/doc/山东大学/入住20200919.xlsx";
        InputStream inputStream = new FileInputStream(filePath);
        readExcelFile(inputStream, filePath);
    }
    public static void  readExcelFile(InputStream inputStream, String fileName){

        /**
         * 这个inputStream文件可以来源于本地文件的流，
         *  也可以来源与上传上来的文件的流，也就是MultipartFile的流，
         *  使用getInputStream()方法进行获取。
         */


        /**
         * 然后再读取文件的时候，应该excel文件的后缀名在不同的版本中对应的解析类不一样
         * 要对fileName进行后缀的解析
         */
        Workbook workbook = null;
        try {
            //判断什么类型文件
            if (fileName.endsWith(".xls")) {
                workbook = new HSSFWorkbook(inputStream);
            } else if (fileName.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (workbook == null) {
            return ;
        } else {
            //获取所有的工作表的的数量
            int numOfSheet = workbook.getNumberOfSheets();
            System.out.println(numOfSheet+"--->numOfSheet");
            //遍历表
            for (int i = 0; i < numOfSheet; i++) {
                //获取一个sheet也就是一个工作本。
                Sheet sheet = workbook.getSheetAt(i);
                if(sheet == null) continue;
                //获取一个sheet有多少Row
                int lastRowNum = sheet.getLastRowNum();
                System.out.println("lastRowNum: " + lastRowNum);
                if(lastRowNum == 0) continue;
                Row row ;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("select * from VIEW_ZJK.V_QDZHXG_MJ where xgh in (");
                for (int j  = 1; j <= lastRowNum; j++) {
                    row = sheet.getRow(j);
                    if(row == null) {
                        continue;
                    }
                    //获取一个Row有多少Cell
                    short lastCellNum = row.getLastCellNum();


                    //获取第一列的数据
                    String res = row.getCell(0).getStringCellValue().trim();
                    System.out.println(res);
                    stringBuilder.append("'" + res + "',");
                    /*for (int k = 0; k <= lastCellNum; k++) {
                        if(row.getCell(k)==null) {
                            continue;
                        }
                        row.getCell(k).setCellType(Cell.CELL_TYPE_STRING);
                        String res = row.getCell(k).getStringCellValue().trim();
                        //打印出cell(单元格的内容)
                        System.out.println(res);
                    }*/

                }
                //stringBuilder.re
                System.out.println(stringBuilder.toString());
            }
        }

    }
}