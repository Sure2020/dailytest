/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DefaultResultWrapper
 * Date Created : 2021-01-29
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-01-29       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.rocketapi;

/**
 * @program: com.example.dailytest.rocketapi
 * @description: xxx
 * @author: w15021
 * @create: 2021-01-29
 **/

import com.alibaba.fastjson.JSONObject;
import com.github.alenfive.rocketapi.entity.ResultWrapper;
import com.github.alenfive.rocketapi.extend.IResultWrapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 默认结果包装类
 */
@Component
public class DefaultResultWrapper  implements IResultWrapper {

    //@Override
    /*public Object wrapper(String code, String msg, Object data, HttpServletRequest request, HttpServletResponse response) {
        return new ResultWrapper(code,request.getRequestURI(),msg,data);
    }*/

    @Override
    public Object wrapper(Object data, HttpServletRequest request, HttpServletResponse response) {
        //return new ResultWrapper("0",request.getRequestURI(),"operation success",data);
        JSONObject resultJSONObject = new JSONObject();
        resultJSONObject.put("code",0);
        resultJSONObject.put("message","success");
        resultJSONObject.put("data", data);
        return resultJSONObject;
    }

    @Override
    public Object throwable(Throwable throwable, HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}