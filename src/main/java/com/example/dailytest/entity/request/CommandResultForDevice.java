/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : CommandResultForDevice
 * Date Created : 2020-03-08
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-08       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.entity.request;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @program: com.h3c.iot.iotinfomgr.lishuiduijie.entity.request
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-08
 **/
@Data
public class CommandResultForDevice {
    private String resultCode;
    private JSONObject resultDetail;
}