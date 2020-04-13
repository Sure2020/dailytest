/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : NorthTestController
 * Date Created : 2020-03-06
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-06       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.dailytest.entity.DeviceInfo;
import com.example.dailytest.entity.ResultInfo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.lishuiduijie_test.controller
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-06
 **/
@RestController
public class NorthTestController {
    @GetMapping("/devices/{appId}")
    public ResultInfo deviceInfo(@PathVariable("appId") String appId) {
        System.out.println("appId: " + appId);
        ResultInfo resultInfo = new ResultInfo();
        if (!"PnB_xNSiIp08g6AnOcG12NBtLdEa".equals(appId)) {
            resultInfo.setCode(204);
            resultInfo.setMessage("应用ID不存在，查询失败");
            return resultInfo;
        }

        DeviceInfo deviceInfo1 = new DeviceInfo();
        deviceInfo1.setDeviceId("7796690c-e914-4e12-9eae-8f65b6197453");
        deviceInfo1.setAlarmStatus(false);
        deviceInfo1.setAlarmTime("0");
        deviceInfo1.setBatteryLevel("5");
        deviceInfo1.setSignalStrength("5");

        DeviceInfo deviceInfo2 = new DeviceInfo();
        deviceInfo2.setDeviceId("8b3a613f-46db-4cf0-885b-837747243d48");
        deviceInfo2.setAlarmStatus(true);
        deviceInfo2.setAlarmTime("10");
        deviceInfo2.setBatteryLevel("1");
        deviceInfo2.setSignalStrength("1");

        List<DeviceInfo> deviceInfoList = new ArrayList<DeviceInfo>();
        deviceInfoList.add(deviceInfo1);
        deviceInfoList.add(deviceInfo2);

        resultInfo.setCode(200);
        resultInfo.setMessage("查询成功");
        resultInfo.setData(deviceInfoList);

        return resultInfo;
    }

    @PutMapping("/device/alarm")
    public ResultInfo command(@RequestBody JSONObject requstObj) {
        ResultInfo resultInfo = new ResultInfo();

        String deviceId = requstObj.getString("deviceId");
        int alarmStatus = requstObj.getIntValue("alarmStatus");

        System.out.println("deviceId: " + deviceId + " alarmStatus: " + alarmStatus);

        if (deviceId == null) {

            resultInfo.setCode(400);
            resultInfo.setMessage("参数不合法：deviceId不能为空，请求失败");
            return resultInfo;
        }

        if (alarmStatus != 0 && alarmStatus != 1) {

            resultInfo.setCode(400);
            resultInfo.setMessage("参数不合法：alarmStatus取值必须为0或1，请求失败");
            return resultInfo;
        }

        resultInfo.setCode(200);
        resultInfo.setMessage("报警命令执行成功");
        resultInfo.setData("报警命令执行成功");

        return resultInfo;
    }
}