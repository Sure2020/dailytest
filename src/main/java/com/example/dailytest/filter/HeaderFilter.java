/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : HeaderFilter
 * Date Created : 2021-06-17
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-06-17       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: com.example.dailytest.filter
 * @description: 给所有的响应体加响应头
 * @author: w15021
 * @create: 2021-06-17
 **/
//@Component  //测试完毕，将该类不再注册到bean，不再生效
public class HeaderFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //response.addHeader("Access-Control-Allow-Origin","*");
        //response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Cache-Control","no-store"); // HTTP 1.1.
        response.setHeader("Pragma","no-cache"); // HTTP 1.0.
        response.setHeader("Expires","0"); // Proxies.
        response.setHeader("my-name-is","Sure!"); // test.
        //如果直接对Resopnse中的content-type赋值,会被系统忽略,
        //在注解@RequestMapping增加一个produces参数项即可。
        //@RequestMapping(value = { "/api/v1/test" }, method = { RequestMethod.POST }, produces="application/json;charset=UTF-8")
        response.setHeader("Content-Type", "application/x-javascript; charset=gb2312");
        filterChain.doFilter(request, response);
    }
}