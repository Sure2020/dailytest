/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : StirngToJson
 * Date Created : 2020-03-07
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-07       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: com.example.lishuiduijie_test.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-07
 **/
public class StirngToJson {

    private Logger logger = LoggerFactory.getLogger(StirngToJson.class);

    public static void main(String args[]){
        System.out.println("hello");
        /*String str = "{\"totalCount\":1,\"pageNo\":0,\"pageSize\":25,\"devices\":[{\"deviceId\":\"8b3a613f-46db-4cf0-885b-837747243d48\",\"gatewayId\":\"8b3a613f-46db-4cf0-885b-837747243d48\",\"nodeType\":\"GATEWAY\",\"createTime\":\"20200305T052822Z\",\"lastModifiedTime\":\"20200305T052822Z\",\"deviceInfo\":{\"nodeId\":\"1113036006\",\"manufacturerId\":\"Water\",\"manufacturerName\":\"Water\",\"deviceType\":\"WaterMeter\",\"model\":\"demo130\",\"protocolType\":\"CoAP\",\"status\":\"OFFLINE\",\"statusDetail\":\"NOT_ACTIVE\"}}]}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject);
        System.out.println(jsonObject.toString());*/

        //TestLogger.testLogger();
        TestIntegerForLoop.testInteger();


    }
}