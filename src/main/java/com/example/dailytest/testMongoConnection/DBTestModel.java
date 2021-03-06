/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DBTestModel
 * Date Created : 2020-06-28
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-06-28       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testMongoConnection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @program: com.example.dailytest.testMongoConnection
 * @description: xxx
 * @author: w15021
 * @create: 2020-06-28
 **/

@Data
@Document("DBTestModel")
public class DBTestModel {
    @Id
    private String id;
    private List<DBEntityTestIndex> dbEntityTestIndexList;
}