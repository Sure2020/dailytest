/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestJsonToClass
 * Date Created : 2020-03-09
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-09       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSONObject;
import com.example.dailytest.entity.DeviceDetail;
//import org.json.JSONObject;


/**
 * @program: com.example.lishuiduijie_test.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-09
 **/
public class TestJsonToClass {

    public static void main(String args[]){

        //String str = "{\"totalCount\":2,\"pageNo\":0,\"pageSize\":25,\"devices\":[{\"deviceId\":\"7796690c-e914-4e12-9eae-8f65b6197453\",\"gatewayId\":\"7796690c-e914-4e12-9eae-8f65b6197453\",\"deviceInfo\":{\"nodeId\":\"869975038108471\",\"name\":\"869975038108471\",\"mute\":\"FALSE\"},\"alarmInfo\":{\"alarmStatus\":\"true\",\"alarmTime\":\"10\"}}]}";
        String str = "{\"name\":\"7d79e79e-8110-4328-a9bb-3956f1384a01\",\"mute\":0,\"alarmInfo\":{\"alarmStatus\":0,\"alarmTime\":\"1234\"}}";
        JSONObject jsonObject = JSONObject.parseObject(str);
        System.out.println(jsonObject);
        DeviceDetail deviceDetail = new DeviceDetail();
        deviceDetail = jsonObject.toJavaObject(DeviceDetail.class);
        System.out.println(deviceDetail);
        System.out.println(deviceDetail.getAlarmInfo().getAlarmTime());

        //JSONArray devicesList = jsonObject.getJSONArray("devices");
        //System.out.println(devicesList.get(0));

        //Devices devices = (Devices) JSONObject.toBean(devicesList.get(0), Devices.class);

        //System.out.println(devices);

        //JSONObject deviceInfo = ((JSONObject) devicesList.get(0)).getJSONObject("deviceInfo");
        //System.out.println(deviceInfo.isEmpty());
        //System.out.println(deviceInfo);
    }
}