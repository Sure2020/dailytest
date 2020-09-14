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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: com.example.dailytest.testMongoConnection
 * @description: xxx
 * @author: w15021
 * @create: 2020-05-11
 **/
@Slf4j
@RestController
public class ControllerTest {
    @Autowired
    DBDaoTest dbDaoTest;
    @Autowired
    DBServiceTest dbServiceTest;
    @Autowired
    MongoTemplate mongoTemplate;

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
            case "insertData":
                log.info("insertData");
                DBEntityTestIndex dbEntityTestIndex1 = new DBEntityTestIndex();
                dbEntityTestIndex1.setParam1("a");
                dbEntityTestIndex1.setParam2("a");

                DBEntityTestIndex dbEntityTestIndex2 = new DBEntityTestIndex();
                dbEntityTestIndex2.setParam1("b");
                dbEntityTestIndex2.setParam2("b");

                List<DBEntityTestIndex> dbEntityTestIndexList = Arrays.asList(dbEntityTestIndex1, dbEntityTestIndex2);

                DBTestModel dbTestModel = new DBTestModel();
                dbTestModel.setId("a");
                dbTestModel.setDbEntityTestIndexList(dbEntityTestIndexList);

                dbDaoTest.insertData(dbTestModel);

                break;
            case "findData":
                log.info("findData");
                //dbDaoTest.insertData();
                Query query1 = new Query().addCriteria(Criteria.where("Id").is("a")/*.and("dbEntityTestIndexList.param1").is("a")*/);
                log.info("query1: {}", query1);
                //List<DBEntityTestIndex> resultList = mongoTemplate.find(query1, DBEntityTestIndex.class);
                log.info("the result is: {}", mongoTemplate.find(query1, DBTestModel.class).toString());

                Query query2 = new Query().addCriteria(Criteria.where("Id").is("a").and("dbEntityTestIndexList.param1").is("a"));
                log.info("query2: {}", query2);
                log.info("the result is: {}", mongoTemplate.find(query2, DBTestModel.class).toString());


                Query query3 = new Query().addCriteria(Criteria.where("Id").is("a"));
                //query3.fields().include("dbEntityTestIndexList"); //包含该字段
                query3.fields().exclude("dbEntityTestIndexList");//不包含该字段
                log.info("query3: {}", query3);
                log.info("the result is: {}", mongoTemplate.find(query3, DBTestModel.class).toString());


                /*MongoCollection<Document> collection =
                        mongoClient.getDatabase("dailyTest").getCollection("DBTestModel");
                FindIterable<Document> findIterable = collection.find()
                        .filter(eq("_id", new ObjectId("a")))
                        .projection(fields(include("comments"), excludeId(), slice("comments", 2)));
                Document document = findIterable.first();
                if (document != null) {
                    Object o = document.get("comments");
                    if (o instanceof List) {
                        List comments = (List) o;
                        assert comments.size() == 2;
                    }
                }*/

                //mongoTemplate aggregate使用，获取嵌套的文档
                /*
                源数据：
                > db.DBTestModel.find().pretty()
                {
                        "_id" : "a",
                        "dbEntityTestIndexList" : [
                                {
                                        "param1" : "a",
                                        "param2" : "a"
                                },
                                {
                                        "param1" : "b",
                                        "param2" : "b"
                                }
                        ]
                }
                 */
                DBEntityTestIndex dbEntityTestIndex = null;
                //封装对象列表查询条件
                List<AggregationOperation> commonOperations = new ArrayList<>();
                //1. 指定查询主文档
                MatchOperation match = Aggregation.match(Criteria.where("_id").is("a"));
                commonOperations.add(match);
                //2. 指定投影，返回哪些字段
                ProjectionOperation project = Aggregation.project("dbEntityTestIndexList");
                commonOperations.add(project);
                //3. 拆分内嵌文档
                UnwindOperation unwind = Aggregation.unwind("dbEntityTestIndexList");
                commonOperations.add(unwind);
                //4. 指定查询子文档
                MatchOperation match2 = Aggregation.match(
                        Criteria.where("dbEntityTestIndexList.param1").is("a"));
                commonOperations.add(match2);

                //创建管道查询对象
                Aggregation aggregation = Aggregation.newAggregation(commonOperations);
                AggregationResults<JSONObject> reminds = mongoTemplate
                        .aggregate(aggregation, "DBTestModel", JSONObject.class);
                //reminds: Document{{results=[Document{{_id=a, dbEntityTestIndexList=Document{{param1=a, param2=a}}}}], ok=1.0}}
                log.info("reminds: {}", reminds.getRawResults());
                //reminds: {"_id":"a","dbEntityTestIndexList":{"param1":"a","param2":"a"}}
                log.info("reminds: {}", reminds.getUniqueMappedResult());
                //reminds: [{"_id":"a","dbEntityTestIndexList":{"param1":"a","param2":"a"}}]
                log.info("reminds: {}", reminds.getMappedResults());
                //reminds: null
                log.info("reminds: {}", reminds.getServerUsed());
                JSONObject resultObj = reminds.getUniqueMappedResult();
                //log.info("mappedResults: {}", mappedResults.toString());


                if (resultObj != null && resultObj.size() > 0) {
                    //size: 2
                    log.info("size: {}", resultObj.size());
                    dbEntityTestIndex = JSONObject
                            .parseObject(resultObj.getJSONObject("dbEntityTestIndexList").toJSONString(), DBEntityTestIndex.class);
                }else{
                    log.error("resultObj is null");
                }

                //the dbEntityTestIndex is : DBEntityTestIndex(param1=a, param2=a)
                log.info("the dbEntityTestIndex is : {}", dbEntityTestIndex.toString());

                break;
            default:
                System.out.println("other");
        }
        return "hi";

    }
}