/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DBDaoTest
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

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: com.example.dailytest.testMongoConnection
 * @description: xxx
 * @author: w15021
 * @create: 2020-05-11
 **/

@Component
public class DBDaoTest {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void insertTest(DBEntityTest dbEntityTest) {
        mongoTemplate.insert(dbEntityTest);
    }

    public void saveTest(DBEntityTest dbEntityTest) {
        mongoTemplate.save(dbEntityTest);
    }

    public void upsertTest(DBEntityTest dbEntityTest) {
        System.out.println("dbEntityTest: " + dbEntityTest);
        Query query = new Query();
        query.addCriteria(Criteria.where("testID").is(dbEntityTest.getTestID()));
        //query.addCriteria(Criteria.where("commentsDate").is(dbEntityTest.getCommentsDate()));
        Update update = new Update();
        update.set("testParam1", dbEntityTest.getTestParam1());
        update.set("testParam2", dbEntityTest.getTestParam2());
        update.set("testParam3", dbEntityTest.getTestParam3());
        //update.push方法会插入一个数组
        //update.push("comments", c.getC());
        UpdateResult upResult = mongoTemplate.upsert(query, update, DBEntityTest.class);
        System.out.println("upResult: " + upResult);
    }

    public void insertData(DBTestModel dbTestModel){
        mongoTemplate.insert(dbTestModel);
    }
    public void removeTest(List<String> list) {
        System.out.println("list: " + list);
        DeleteResult deleteResult = mongoTemplate.remove(new Query(Criteria.where("testID").is("testid2").and("testParam1").in(list)), DBEntityTest.class);
        System.out.println("deleteResult: " + deleteResult);
    }

    /*public void save(Polygon polygon){
        mongoTemplate.save(polygon);
    }

    public void saveRegions(List<GisRegion> gisRegionList){
        mongoTemplate.insert(gisRegionList,GisRegion.class);
    }

    public <T> T findById(Class<T> entityClass, String id) {
        return mongoTemplate.findById(id, entityClass);
    }

    public <T> List<T> findAll(Class<T> entityClass) {
        return mongoTemplate.findAll(entityClass);
    }

    public <T> void remove(T entity) {
        mongoTemplate.remove(entity);
    }

    public <T> void add(T entity) {
        mongoTemplate.insert(entity);
    }

    public <T> void addAll(List<T> entity) {
        mongoTemplate.insertAll(entity);
    }

    public <T> void saveOrUpdate(T entity) {
        mongoTemplate.save(entity);
    }

    public <T> T findOne(Class<T> entityClass) {
        return mongoTemplate.findOne(new Query(), entityClass);
    }

    public List<Polygon> findIntersective(GeoJson geoJson){
        Query query=new Query(Criteria.where("geometry").intersects(geoJson));
        List<Polygon> list=mongoTemplate.find(query,Polygon.class);
        return list;
    }

    public boolean isExistIntersective(GeoJson geoJson){
        Query query=new Query(Criteria.where("geometry").intersects(geoJson).and("_id").is(100000));
        boolean res=mongoTemplate.exists(query,GisRegion.class);
        return res;
    }*/

}