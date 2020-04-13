/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DeviceDetail
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
public class DeviceDetail {
    private String name;
    private Boolean mute;
    private AlarmInfo alarmInfo;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMute() {
        return mute;
    }

    public void setMute(Boolean mute) {
        this.mute = mute;
    }

    public AlarmInfo getAlarmInfo() {
        return alarmInfo;
    }

    public void setAlarmInfo(AlarmInfo alarmInfo) {
        this.alarmInfo = alarmInfo;
    }

    @Override
    public String toString() {
        return "DeviceDetail{" +
                "name='" + name + '\'' +
                ", mute=" + mute +
                ", alarmInfo=" + alarmInfo +
                '}';
    }
}