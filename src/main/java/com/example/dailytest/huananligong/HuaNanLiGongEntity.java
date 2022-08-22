/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : HuaNanLiGongEntity
 * Date Created : 2021-02-05
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-02-05       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.huananligong;

import com.alibaba.fastjson.JSONObject;
//import com.example.dailytest.testMongoConnection.EntityForAggregationTest;
import lombok.Data;
import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: com.example.dailytest.huananligong
 * @description: xxx
 * @author: w15021
 * @create: 2021-02-05
 **/

@Data
//@Document("huananligong")
public class HuaNanLiGongEntity {
    @Id
    private String id;
    private JSONObject object;
}