/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestShell
 * Date Created : 2021-12-02
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-12-02       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @program: com.example.dailytest.testmain
 * @description: 测试java执行shell命令。需要先javac TestShell.java 再java TestShell(注释掉最上面package的那一行)
 * @author: w15021
 * @create: 2021-12-02
 **/
public class TestShell {
    public static void main(String[] args) {
        System.out.println("test shell");
        execCommand("date");
    }
    public static void execCommand(String cmd){
        try{
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec(cmd,null,null);
            InputStream stderr =  proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(stderr,"GBK");
            BufferedReader br = new BufferedReader(isr);
            String line="";
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}