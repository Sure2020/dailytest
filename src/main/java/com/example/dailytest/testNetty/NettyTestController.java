/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : NettyTestController
 * Date Created : 2020-07-27
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-27       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testNetty;

import com.example.dailytest.testNetty.server.NettyServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;

/**
 * @program: com.example.dailytest.testNetty
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-27
 **/
@RestController
public class NettyTestController {
    //  参考链接：https://developer.aliyun.com/article/706893
    @RequestMapping("/test/netty/startServer")
    public String startServer () {
        //启动服务端
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));
        System.out.println("netty server started");
        return "netty server started";
    }
}