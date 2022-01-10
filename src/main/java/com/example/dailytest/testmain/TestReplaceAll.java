/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestReplaceAll
 * Date Created : 2020-03-18
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-18       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

/**
 * @program: com.example.lishuiduijie_test.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-18
 **/
public class TestReplaceAll {
    public static void main(String[] args) {
        System.out.println("say hi");
        String str = "INSERT INTO public.apis VALUES ('75844ae1-3980-4825-9a4a-8b4e47ecd337', 'auth_baas', 'http://iotbaas:80', false, '2020-02-17 18:29:36.11', 5, false, false, NULL, '[\"\\/auth\\/iotbaas\"]', NULL, true, 60000, 60000, 60000);";
        System.out.println(str);
        String svc = "iotbaas";
        String regex = "http://"+svc;
        String ip = "0.0.0.0";
        String replacement = "http://"+ ip;
        System.out.println(str.replaceFirst(regex,replacement));

        // http://192.168.110.250/home/
        String url = "http://192.168.110.222:8086/log/a/b/c/directory?hostname";
        String urlAfterReplace = url.replace("//.*/", "//vm222:8888/");
        System.out.println(urlAfterReplace);
    }
}