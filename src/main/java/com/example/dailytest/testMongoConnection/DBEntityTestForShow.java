/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DBEntityTestForShow
 * Date Created : 2020-05-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-05-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testMongoConnection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: com.example.dailytest.testMongoConnection
 * @description: 如果数据库中存储字段较多，但返回时只想返回部分字段，那么可以另外新建一个类，该类中写明要返回的若干字段
 * @author: w15021
 * @create: 2020-05-13
 **/

@Data
@Document("entityTest")
public class DBEntityTestForShow {
    @Id
    private String testID;
    private String testParam1;
    //private String testParam2;
}