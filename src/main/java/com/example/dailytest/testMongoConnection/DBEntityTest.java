/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DBEntityTest
 * Date Created : 2020-05-11
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-05-11       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testMongoConnection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: com.example.dailytest.testMongoConnection
 * @description: xxx
 * @author: w15021
 * @create: 2020-05-11
 **/
@Data
@Document("entityTest")
public class DBEntityTest {
    @Id
    private String testID;
    private String testParam1;
    private String testParam2;
    private String testParam3;
}