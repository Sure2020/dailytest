/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestGetCharset
 * Date Created : 2022-02-14
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-02-14       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import info.monitorenter.cpdetector.io.*;

import java.io.*;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2022-02-14
 **/
public class TestGetCharset {
    public static void main(String[] args) throws IOException {
        System.out.println("test");
    }
    /**
     * @description: https://blog.csdn.net/wuseyukui/article/details/45799207
     * @param:
     * @return:
     * @author: w15021
     * @date: 2022/2/14
     */
    public static String getFileEncode(String filePath) {
        String charsetName = null;
        try {
            File file = new File(filePath);
            CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
            detector.add(new ParsingDetector(false));
            detector.add(JChardetFacade.getInstance());
            detector.add(ASCIIDetector.getInstance());
            detector.add(UnicodeDetector.getInstance());
            java.nio.charset.Charset charset = null;
            charset = detector.detectCodepage(file.toURI().toURL());
            if (charset != null) {
                charsetName = charset.name();
            } else {
                charsetName = "Unknown";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ex.getLocalizedMessage();
        }
        return charsetName;
    }
}