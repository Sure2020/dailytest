/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DBServiceTest
 * Date Created : 2020-05-12
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-05-12       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testMongoConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @program: com.example.dailytest.testMongoConnection
 * @description: xxx
 * @author: w15021
 * @create: 2020-05-12
 **/
@Service
public class DBServiceTest {
    @Autowired
    MongoPageHelper mongoPageHelper;
    public Object readDB (Integer pageNum, Integer pageSize) {
        if (pageNum == null) {
            pageNum = 0;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        PageResult<DBEntityTestForShow> pageResult = null;
        Query query = new Query();

        pageResult = mongoPageHelper.pageQuery(query, DBEntityTestForShow.class, pageSize, pageNum);
        System.out.println(pageResult.toString());
        return pageResult;
    }
}