/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : APITest
 * Date Created : 2020-04-25
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-04-25       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.shenzhenalarm.testapi;

import com.alibaba.fastjson.JSONObject;
import com.ctg.ag.sdk.biz.AepDeviceCommandClient;
import com.ctg.ag.sdk.biz.aep_device_command.CreateCommandRequest;
import com.ctg.ag.sdk.biz.aep_device_command.CreateCommandResponse;
import org.junit.Test;

/**
 * @program: com.example.shenzhenalarm.testapi
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-25
 **/
public class APITest {
    @Test
    public void testApi() throws Exception {

        AepDeviceCommandClient client = AepDeviceCommandClient.newClient().appKey("eke3uNOLPfd").appSecret("wq0xibKkv1").build();

        {
            CreateCommandRequest request = new CreateCommandRequest();
            // request.setParam..  	// set your request params here
            request.setParamMasterKey("4dd773bb798b4c39857b10b8d84c787e");
            byte[] byteBody = buildRequstBody(
                    "362b2c484dc04a65a9d99957e319ae78",
                    "h3c",
                    10035159,
                    7800,
                    2,
                    "SER_CTRL_ALARM_FLG",
                    1,
                    "CTRL_ALARM_FLG",
                    "0");

            request.setBody(byteBody);

            System.out.println("#############################");
            CreateCommandResponse commandResponse = client.CreateCommand(request);
            System.out.println(commandResponse);
            int statusCode = commandResponse.getStatusCode();
            if (statusCode == 200){
                System.out.println("SENT");
            }else{
                System.out.println("FAILED");
            }
            System.out.println("#############################");
        }

        client.shutdown();

    }

    @Test
    public void testApiGetDeviceList() throws Exception {

        AepDeviceCommandClient client = AepDeviceCommandClient.newClient().appKey("eke3uNOLPfd").appSecret("wq0xibKkv1").build();

        {
            CreateCommandRequest request = new CreateCommandRequest();
            // request.setParam..  	// set your request params here
            request.setParamMasterKey("4dd773bb798b4c39857b10b8d84c787e");
            byte[] byteBody = buildRequstBody(
                    "362b2c484dc04a65a9d99957e319ae78",
                    "h3c",
                    10035159,
                    7800,
                    2,
                    "SER_CTRL_ALARM_FLG",
                    1,
                    "CTRL_ALARM_FLG",
                    "0");

            request.setBody(byteBody);

            System.out.println("#############################");
            CreateCommandResponse commandResponse = client.CreateCommand(request);
            System.out.println(commandResponse);
            int statusCode = commandResponse.getStatusCode();
            if (statusCode == 200){
                System.out.println("SENT");
            }else{
                System.out.println("FAILED");
            }
            System.out.println("#############################");
        }



        client.shutdown();

    }

    /*最终构造出这个接口的请求体
    {
        "deviceId":"8264717e451348beac3c01ebc64603db",
        "operator":"joinzn",
        "productId":10035159,
        "ttl":7800,
        "level":2,
        "content":{
            "serviceIdentifier":"SER_CTRL_ALARM_FLG",
            "isReturn":1,
            "params":{
                "CTRL_ALARM_FLG":0
            }
        }
    }
    */
    public byte[] buildRequstBody(String deviceId, String operator, int productId, int ttl, int level,
                                      String serviceIdentifier, int isReturn, String paramKey, String paramValue) throws Exception{
        JSONObject paramsObj = new JSONObject();
        paramsObj.put(paramKey,paramValue);

        JSONObject contentObj = new JSONObject();
        contentObj.put("serviceIdentifier", serviceIdentifier);
        contentObj.put("isReturn", isReturn);
        contentObj.put("params", paramsObj);

        JSONObject requestBodyObj = new JSONObject();
        requestBodyObj.put("deviceId", deviceId);
        requestBodyObj.put("operator", operator);
        requestBodyObj.put("productId", productId);
        requestBodyObj.put("ttl", ttl);
        requestBodyObj.put("level", level);
        requestBodyObj.put("content", contentObj);

        byte[] byteBody = requestBodyObj.toString().getBytes("utf-8");

        return byteBody;
    }
}