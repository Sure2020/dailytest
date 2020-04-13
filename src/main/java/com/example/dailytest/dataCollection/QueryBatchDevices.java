/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : QueryBatchDevices
 * Date Created : 2020-03-05
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-05       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.dataCollection;

import java.util.HashMap;
import java.util.Map;

import com.example.dailytest.utils.Constant;
import com.example.dailytest.utils.HttpsUtil;
import com.example.dailytest.utils.JsonUtil;
import com.example.dailytest.utils.StreamClosedHttpResponse;

/**
 * @program: com.example.lishuiduijie_test.dataCollection
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-05
 **/
/**
 * Query Batch Devices:
 * This interface is used to query information about devices in batches.
 */
public class QueryBatchDevices {

    //
    public static void main(String args[]) throws Exception
    //public void queryBatchDevicesMethod () throws Exception
    {

        // Two-Way Authentication
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        // Authentication.get token
        String accessToken = login(httpsUtil);

        //Please make sure that the following parameter values have been modified in the Constant file.
        String appId = Constant.APPID;
        String urlQueryBatchDevices = Constant.QUERY_BATCH_DEVICES;

        //please replace the status (ONLINE|OFFLINE|ABNORMAL), when you call this interface.
        String status = "OFFLINE";
        Integer pageNo = 0;

        Map<String, String> paramQueryBatchDevices = new HashMap<>();
        paramQueryBatchDevices.put("status", status);
        paramQueryBatchDevices.put("pageNo", pageNo.toString());

        Map<String, String> header = new HashMap<>();
        header.put(Constant.HEADER_APP_KEY, appId);
        header.put(Constant.HEADER_APP_AUTH, "Bearer" + " " + accessToken);

        StreamClosedHttpResponse responseQueryBatchDevices = httpsUtil.doGetWithParasGetStatusLine(urlQueryBatchDevices,
                paramQueryBatchDevices, header);

        System.out.println("QueryBatchDevices, response content:");
        System.out.println(responseQueryBatchDevices.getStatusLine());
        System.out.println(responseQueryBatchDevices.getContent());
        System.out.println();
    }

    /**
     * Authentication.get token
     */
    @SuppressWarnings("unchecked")
    public static String login(HttpsUtil httpsUtil) throws Exception {

        String appId = Constant.APPID;
        String secret = Constant.SECRET;
        String urlLogin = Constant.APP_AUTH;

        Map<String, String> paramLogin = new HashMap<>();
        paramLogin.put("appId", appId);
        paramLogin.put("secret", secret);

        StreamClosedHttpResponse responseLogin = httpsUtil.doPostFormUrlEncodedGetStatusLine(urlLogin, paramLogin);

        System.out.println("app auth success,return accessToken:");
        System.out.println(responseLogin.getStatusLine());
        System.out.println(responseLogin.getContent());
        System.out.println();

        Map<String, String> data = new HashMap<>();
        data = JsonUtil.jsonString2SimpleObj(responseLogin.getContent(), data.getClass());
        return data.get("accessToken");
    }

}