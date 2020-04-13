/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DeviceAdded
 * Date Created : 2020-03-12
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-12       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.entity.request;

import lombok.Data;

/**
 * @program: com.h3c.iot.iotinfomgr.lishuiduijie.entity.request
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-12
 **/
@Data
public class DeviceAdded {
    private String notifyType;
    private String deviceId;
    private String gatewayId;
    private String nodeType;
    private DeviceInfoForRequest deviceInfoForRequest;
}