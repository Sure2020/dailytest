/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestGetHostnameAndIp
 * Date Created : 2022-02-22
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-02-22       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;
import java.net.InetAddress;
/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2022-02-22
 **/
public class TestGetHostnameAndIp {
    public static void main(String[] args)
            throws Exception {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr);
        System.out.println("Local HostAddress: "+addr.getHostAddress());
                String hostname = addr.getHostName();
        System.out.println("Local host name: "+hostname);

        System.out.println(InetAddress.getLocalHost().getHostAddress());
    }
}