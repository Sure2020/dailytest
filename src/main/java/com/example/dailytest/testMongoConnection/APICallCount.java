/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : APICallCount
 * Date Created : 2021-06-07
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-06-07       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testMongoConnection;

import lombok.Data;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: com.example.dailytest.testMongoConnection
 * @description: xxx
 * @author: w15021
 * @create: 2021-06-07
 **/
@Data
@Document("apiCallCount")
//name：索引名称 def：字段(1正序 -1倒序) unique：是否唯一索引
@CompoundIndex(name = "apiCallCount_index", def = "{year:1, month:1}", unique = true)
public class APICallCount {

    int year;
    int month;
    int count;
}