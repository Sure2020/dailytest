/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ControllerTest
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

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.example.dailytest.testMongoConnection
 * @description: xxx
 * @author: w15021
 * @create: 2020-05-11
 **/
@RestController
public class ControllerTest {
    @Autowired
    DBDaoTest dbDaoTest;
    @Autowired
    DBServiceTest dbServiceTest;

    @PostMapping("/test/mongodb")
    public  Object mongodbTest(@RequestBody JSONObject requestObj){
        System.out.println("requstObj: " + requestObj.toString());

        String testID = requestObj.getString("testID");
        if (testID == null) {
            testID = "testid";
        }
        String testParam1 = requestObj.getString("testParam1");
        String testParam2 = requestObj.getString("testParam2");
        String testParam3 = requestObj.getString("testParam3");
        String operation = requestObj.getString("operation");
        DBEntityTest dbEntityTest = new DBEntityTest();
        dbEntityTest.setTestID(testID);
        dbEntityTest.setTestParam1(testParam1);
        dbEntityTest.setTestParam2(testParam2);
        dbEntityTest.setTestParam3(testParam3);

        switch (operation) {
            case "insert" :
                System.out.println("insert");
                dbDaoTest.insertTest(dbEntityTest);
                break;
            case "save":
                System.out.println("save");
                dbDaoTest.saveTest(dbEntityTest);
                break;
            case "upsert":
                System.out.println("upsert");
                dbDaoTest.upsertTest(dbEntityTest);
                break;
            case "read":
                System.out.println("read");
                dbServiceTest.readDB(0,10);
                break;
            default:
                System.out.println("other");
        }
        return "hi";

    }
}