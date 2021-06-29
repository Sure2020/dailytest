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
import com.example.dailytest.huananligong.HuaNanLiGongEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;

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
    public Object mongodbTest(@RequestBody JSONObject requestObj) {
        System.out.println("requstObj: " + requestObj.toString());

        String testID = requestObj.getString("testID");
        if (testID == null) {
            //testID = "testid";
            System.out.println("testId can not be null");
            return "testId can not be null";
        }
        String testParam1 = requestObj.getString("testParam1");
        String testParam2 = requestObj.getString("testParam2");
        String testParam3 = requestObj.getString("testParam3");
        String operation = requestObj.getString("operation");
        String regexStr = requestObj.getString("regexStr");
        DBEntityTest dbEntityTest = new DBEntityTest();
        dbEntityTest.setTestID(testID);
        dbEntityTest.setTestParam1(testParam1);
        dbEntityTest.setTestParam2(testParam2);
        dbEntityTest.setTestParam3(testParam3);

        switch (operation) {
            case "insert":
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
                dbServiceTest.readDB(0, 10);
                break;
            case "remove":
                System.out.println("remove");
                dbDaoTest.removeTest(Arrays.asList("testParam111"));
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

                // 试用查询结果包含或取除指定字段
                Query query3 = new Query().addCriteria(Criteria.where("Id").is("a"));
                //query3.fields().include("dbEntityTestIndexList"); //包含该字段
                query3.fields().exclude("dbEntityTestIndexList");//不包含该字段
                log.info("query3: {}", query3);
                log.info("the result is: {}", mongoTemplate.find(query3, DBTestModel.class).toString());

                // 试用 where in 条件查询
                Query query4 = new Query().addCriteria(Criteria.where("testParam1").in(Arrays.asList("testParam1", "testParam111")));
                log.info("query4: {}", query4);
                log.info("the result is: {}", mongoTemplate.find(query4, DBEntityTest.class).toString());

                // 试用regex模糊查询
                //Query query5 = new Query().addCriteria(Criteria.where("Id").is("a.b.c"));
                Query query5 = new Query().addCriteria(Criteria.where("Id").regex(regexStr));
                log.info("query5: {}", query5);
                log.info("query5: {}", query5.toString());
                log.info("the result is: {}", mongoTemplate.find(query5, DBTestModel.class).toString());

                // 试用Aggregation分组聚合操作
                Aggregation aggregationForCount = Aggregation.newAggregation(
                        group("testParam1").count().as("count"),
                        project("count").and("testParam1").previousOperation()
                );
                AggregationResults<MessageCount> outputTypeCount = mongoTemplate.aggregate(aggregationForCount, DBEntityTest.class, MessageCount.class);
                //return outputTypeCount.getMappedResults();
                System.out.println("测试数据统计的方法！！！");
                List<MessageCount> messageCountList = outputTypeCount.getMappedResults();
                System.out.println(outputTypeCount.getMappedResults());
                System.out.println(messageCountList);
                System.out.println(messageCountList.size());
                //System.out.println(outputTypeCount.getRawResults());

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
                ProjectionOperation project = project("dbEntityTestIndexList");
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
                } else {
                    log.error("resultObj is null");
                }

                //the dbEntityTestIndex is : DBEntityTestIndex(param1=a, param2=a)
                //log.info("the dbEntityTestIndex is : {}", dbEntityTestIndex.toString());

                break;
            default:
                System.out.println("other");
        }
        return "hi";

    }

    @PostMapping("test/mongodb/aggregation")
    public Object mongodbAggregationTest(@RequestBody JSONObject requestObj) {

        System.out.println("requstObj: " + requestObj.toString());
        String operation = requestObj.getString("operation");
        Object resultObject = "success";
        switch (operation) {
            case "insert":
                System.out.println("insert");

                EntityForAggregationTest entityForAggregationTest = new EntityForAggregationTest();
                DBForAggregationTest dbForAggregationTest = new DBForAggregationTest();

                // 插入第一组数据
                entityForAggregationTest.setDeviceId("deviceId_a");
                entityForAggregationTest.setDeviceTypeId("typeId_1");
                entityForAggregationTest.setDeviceTypeName("typeName_1");

                dbForAggregationTest.setId("doc1");
                dbForAggregationTest.setAttributes(entityForAggregationTest);
                dbDaoTest.aggregationInsertTest(dbForAggregationTest);

                // 插入第二组数据
                entityForAggregationTest.setDeviceId("deviceId_b");
                entityForAggregationTest.setDeviceTypeId("typeId_2");
                entityForAggregationTest.setDeviceTypeName("typeName_2");

                dbForAggregationTest.setId("doc2");
                dbForAggregationTest.setAttributes(entityForAggregationTest);
                dbDaoTest.aggregationInsertTest(dbForAggregationTest);

                // 插入第三组数据
                //entityForAggregationTest.setDeviceId("deviceId_c");
                //entityForAggregationTest.setDeviceTypeId("2");

                dbForAggregationTest.setId("doc3");
                dbForAggregationTest.setAttributes(null);
                dbDaoTest.aggregationInsertTest(dbForAggregationTest);

                break;
            case "aggregation":
                // 试用Aggregation分组聚合操作
                Criteria criteria = Criteria.where("attributes.deviceTypeId").exists(true);
                //criteria.where("attributes.deviceTypeId").exists(true);
                //criteria.where("_id").is("doc1");
                Aggregation aggregationForCount = Aggregation.newAggregation(
                        Aggregation.match(criteria),
                        group("attributes.deviceTypeId").count().as("count")
                                .first("attributes.deviceTypeName").as("name")
                                .first("attributes.deviceTypeId").as("id")
                        //Aggregation.group("name").count().as("num_name")
                        //Aggregation.project("count").and("deviceTypeId").previousOperation()
                );
                AggregationResults<MessageCount2> outputTypeCount = mongoTemplate.aggregate(aggregationForCount, DBForAggregationTest.class, MessageCount2.class);
                //return outputTypeCount.getMappedResults();
                System.out.println("测试数据统计的方法！！！");
                List<MessageCount2> messageCountList = outputTypeCount.getMappedResults();
                //System.out.println(outputTypeCount.getMappedResults());
                System.out.println(messageCountList);
                int size = messageCountList.size();
                System.out.println(size);
                for (int i = 0; i < size; i++) {
                    MessageCount2 messageCount2 = messageCountList.get(i);
                    if (messageCount2.getId() == null) {
                        size--;
                    }
                }
                System.out.println(size);
                resultObject = messageCountList;
                break;
            case "ne":
                log.info("ne");
                Query query_ne = new Query().addCriteria(Criteria.where("id").ne("doc1")/*.and("dbEntityTestIndexList.param1").is("a")*/);
                log.info("query_ne: {}", query_ne);
                //List<DBEntityTestIndex> resultList = mongoTemplate.find(query1, DBEntityTestIndex.class);
                log.info("the result is: {}", mongoTemplate.find(query_ne, DBForAggregationTest.class).toString());
                break;

            default:
                System.out.println("other");
        }
        return resultObject;
    }

    @PostMapping("/test/mongodb/huananligong")
    public Object huananligongDBInsert(@RequestBody JSONObject requestObj) {
        System.out.println("requstObj: " + requestObj.toString());
        String operation = requestObj.getString("operation");
        Object resultObject = "success";
        switch (operation) {
            case "insert":
                System.out.println("insert");
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("class1", "8:30");
                jsonObject.put("class2", "9:45");
                HuaNanLiGongEntity huaNanLiGongEntity = new HuaNanLiGongEntity();
                huaNanLiGongEntity.setId("a");
                huaNanLiGongEntity.setObject(jsonObject);
                dbDaoTest.huananligongInsert(huaNanLiGongEntity);

                break;
            case "aggregation":
                //
                break;
            case "ne":
                //
                break;

            default:
                System.out.println("other");
        }
        return resultObject;
    }

    @PostMapping("test/mongodb/orOperator")
    public Object mongodbOrOperater(@RequestBody JSONObject requestObj) {
        Criteria criteria1 = Criteria.where("testID").is("e");
        criteria1.orOperator(Criteria.where("testParam1").is(""), Criteria.where("testParam1").is("0.0"), Criteria.where("testParam1").is(null)
                , Criteria.where("testParam2").is(""), Criteria.where("testParam2").is("0.0"), Criteria.where("testParam2").is(null));
        Query query1 = new Query();//.addCriteria(Criteria.where("testID").is("a")/*.and("dbEntityTestIndexList.param1").is("a")*/);
        query1.addCriteria(criteria1);
        log.info("query1: {}", query1);
        //List<DBEntityTestIndex> resultList = mongoTemplate.find(query1, DBEntityTestIndex.class);
        log.info("the result is: {}", mongoTemplate.find(query1, DBEntityTest.class).toString());

        return "testing";
    }

    @GetMapping("/test/mongodb/update_inc")
    public Object updateAndInc() {

        Criteria criteria = new Criteria().where("year").is(2021).and("month").is(6);
        //criteria.where("year").is(2021);//.and("month").is(6);
        Query query = new Query(criteria);
        //query.addCriteria(criteria);
        Update update = new Update().inc("count", 1);
        //update.inc("count", 1);
        //update.set("count",100);
        mongoTemplate.upsert(query, update, APICallCount.class);


        //mongoTemplate.upsert(new Query(Criteria.where("year").is(2021)), new Update().set("count", 100), APICallCount.class);

        /*为什么把query criteria分开写 这样upsert就不行
        Criteria c = new Criteria();
        c.where("year").is(2023).and("month").is(7);
        Query q = new Query();
        q.addCriteria(c);
        Update u = new Update().set("count",200);
        u.set("count",100);
        mongoTemplate.upsert(q, u, APICallCount.class);
        */
        return "update and inc";
    }

    @GetMapping("/test/mongodb/orderby")
    public Object testOrderby() {
        Query query = new Query();
        query.with(Sort.by(new Sort.Order(Sort.Direction.DESC, "year")));
        query.with(Sort.by(new Sort.Order(Sort.Direction.DESC, "month")));
        query.limit(12);
        List<APICallCount> list = mongoTemplate.find(query, APICallCount.class);
        list.forEach(obj -> {
            System.out.println(obj.toString());
        });
        for (int i = list.size() - 1; i >= 0; i--) {
            APICallCount apiCallCount = list.get(i);
            System.out.print(apiCallCount.getYear());
            System.out.println(apiCallCount.getMonth());
        }
        //query.with(Sort.by(new Order(Direction.ASC, "name")));
        return "testOrderby";
    }

    @GetMapping(value = "/test/mongodb/sum"/*,produces="application/x-javascript; charset=gb2312"*/)
    public Object getSum(HttpServletResponse response){
        response.addHeader("Baeldung-Example-Header", "Value-HttpServletResponse");
        //事实证明这样设置Content-Type也不行，不会生效，只能用在@RequestMapping中指定produces来实现
        //response.setHeader("Content-Type", "application/x-javascript; charset=gb2312");
        response.addHeader("Content-Type", "application/x-javascript; charset=gb2312");
        // 试用Aggregation分组聚合操作
        Aggregation aggregation = Aggregation.newAggregation(
                group("year").sum("count").as("totalCalls")
                /*project("totalCalls")*/
        );
        AggregationResults<JSONObject> outputTypeCount = mongoTemplate.aggregate(aggregation, APICallCount.class, JSONObject.class);
        //return outputTypeCount.getMappedResults();
        System.out.println("测试数据统计的方法！！！");
        List<JSONObject> messageCountList = outputTypeCount.getMappedResults();
        System.out.println(messageCountList);
        int totalCalls = 0;
        for (JSONObject object: messageCountList  ) {
            System.out.println(object);
            totalCalls += object.getIntValue("totalCalls");

        }
        return "总个数：" + totalCalls;

        /*
        db.importedDataItems.aggregate({
    $match: {
        mobile: "1234567890"
    }
}, {
    $group: {
        _id: 'mobile',
        calls: { $sum: '$calls' }
    }
 })

 参考：https://stackoverflow.com/questions/33390407/mongotemplate-sum-values-of-keys-for-documents-matching-a-certain-criterion
         */

    }

    @GetMapping("/test/mongodb/exists")
    public Object testExists () {
        Query query = new Query();
        query.addCriteria(Criteria.where("year").exists(true).ne("2020"));
        log.info(query.toString());
        //query查询条件，多个ne，只会生效最后面那一个
        //Query query = new Query(new Criteria().where("year").exists(true).ne("2020").ne(2020));
        List<APICallCount> list = mongoTemplate.find(query, APICallCount.class);
        for (int i = list.size() - 1; i >= 0; i--) {
            APICallCount apiCallCount = list.get(i);
            System.out.print(apiCallCount.getYear());
            System.out.println(apiCallCount.getMonth());
        }

        return list;
    }

    @PostMapping ("/test/mongodb/regex")
    public Object testRegex(@RequestBody JSONObject requestObj){
        String regexStr = requestObj.getString("regex");
        System.out.println("regex: " + regexStr);
        String regex = strToCom(regexStr);
        // 试用regex模糊查询
        //Query query5 = new Query().addCriteria(Criteria.where("Id").is("a.b.c"));
        Pattern pattern = Pattern.compile(regexStr, Pattern.CASE_INSENSITIVE);
        Query query5 = new Query().addCriteria(Criteria.where("testParam1").regex(regex));
        log.info("query5: {}", query5);
        log.info("query5: {}", query5.toString());
        String result = mongoTemplate.find(query5, DBEntityTest.class).toString();
        log.info("the result is: {}", result);
        return result;
    }

    /**
     * 模糊查询特殊字符替换
     */
    public static String strToCom(String str) {
        String newCloudName = str.replace("\\", "\\\\")
                .replace("*", "\\*").replace("+", "\\+")
                .replace("|", "\\|")
                .replace("{", "\\{").replace("}", "\\}")
                .replace("(", "\\(").replace(")", "\\)")
                .replace("^", "\\^").replace("$", "\\$")
                .replace("[", "\\[").replace("]", "\\]")
                .replace("?", "\\?").replace(",", "\\,")
                .replace(".", "\\.").replace("&", "\\&");
        return newCloudName;
    }
}