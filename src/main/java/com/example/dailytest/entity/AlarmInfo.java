/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : AlarmInfo
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
public class AlarmInfo {
    private Boolean alarmStatus;
    private String alarmTime;

    public Boolean getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(Boolean alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public String getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(String alarmTime) {
        this.alarmTime = alarmTime;
    }

    @Override
    public String toString() {
        return "AlarmInfo{" +
                "alarmStatus=" + alarmStatus +
                ", alarmTime='" + alarmTime + '\'' +
                '}';
    }
}