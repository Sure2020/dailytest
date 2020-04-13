/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Devices
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

package com.example.dailytest.entity;

/**
 * @program: com.example.lishuiduijie_test.entity
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-09
 **/
public class Devices {
    private String deivceId;
    private String gatewayId;
    private DeviceDetail deviceInfo;
    private AlarmInfo alarmInfo;

    public String getDeivceId() {
        return deivceId;
    }

    public void setDeivceId(String deivceId) {
        this.deivceId = deivceId;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public DeviceDetail getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceDetail deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public AlarmInfo getAlarmInfo() {
        return alarmInfo;
    }

    public void setAlarmInfo(AlarmInfo alarmInfo) {
        this.alarmInfo = alarmInfo;
    }

    @Override
    public String toString() {
        return "Devices{" +
                "deivceId='" + deivceId + '\'' +
                ", gatewayId='" + gatewayId + '\'' +
                ", deviceInfo=" + deviceInfo +
                ", alarmInfo=" + alarmInfo +
                '}';
    }
}