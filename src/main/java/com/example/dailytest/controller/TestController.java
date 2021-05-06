/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestController
 * Date Created : 2020-03-12
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-12       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.dailytest.entity.DeviceDetail;
import com.example.dailytest.entity.request.DeviceDataChanged;
import com.example.dailytest.testStaticMethodAndAutowired.TestStaticMethodAndAutowired;
import com.example.dailytest.testmain.TestAtValue;
import com.example.dailytest.utils.Constant;
import com.example.dailytest.utils.ConstantProperties;
import com.example.dailytest.zhihuiqingcheng.TestXianHongAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.lishuiduijie_test.controller
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-12
 **/

@RestController
@Slf4j
public class TestController {
    @Autowired
    ConstantProperties constantProperties;
    @Autowired
    TestXianHongAPI testXianHongAPI;
    @Value("${testValue}")
    private String testValue;

    //经过尝试，用以下这种方式从配置文件中取常量值取不到
    /*public static final String KEY;
    public static final String API;
    static {
        KEY = ConstantProperties.getChengyunKeyPrivate();
        API = Constant.CHENGYUNAPIPARKINGS;
    }*/

    @PostMapping("/test/post")
    public String testPost(@RequestBody DeviceDetail deviceDetail){

        System.out.println(deviceDetail);
        System.out.println(deviceDetail.toString());
        return "yes";
    }

    @GetMapping("/test/atValue")
    public String atValue(){

        System.out.println(constantProperties.getTestValue());
        System.out.println(constantProperties.getCallbackBaseUrl());
        System.out.println(testValue);
        System.out.println(Constant.CALLBACK_BASE_URL);
        System.out.println(Constant.DEVICE_ADDED_CALLBACK_URL);
        System.out.println(new TestAtValue().testAtValue());
        return "yes";
    }

    @PostMapping("/test/requestToClass")
    public String requestToClass (@RequestBody DeviceDataChanged deviceDataChanged){
        System.out.println("the deviceDataChanged request: "+deviceDataChanged);

        return "hello test";
    }
    @PostMapping("/test/create")
    public JSONObject testCreate (@RequestBody JSONObject jsonObject){

        System.out.println(jsonObject.getString("paramA"));
        System.out.println(jsonObject.getIntValue("paramB"));
        //return "testCreate";
        JSONObject resultObj = new JSONObject();
        //resultObj.put("returnA", "returnA");
        resultObj.put("code", 200);
        JSONObject dataObj = new JSONObject();
        dataObj.put("a","a");
        dataObj.put("b", "b");
        resultObj.put("msg", "SUCCESS");
        resultObj.put("data", dataObj);
        return resultObj;
    }

    @PostMapping("/test/modId")
    public JSONObject testModId (/*String modId,*/ @RequestBody JSONObject jsonObject){
//        System.out.println("modId: "+ modId);
        System.out.println(jsonObject.toString());
        return jsonObject;
    }

    @GetMapping("/test/lock")
    public JSONObject lock (@RequestParam String lockerId) {
        System.out.println(lockerId);
        JSONObject resultObj = new JSONObject();
        JSONObject lockObj = new JSONObject();
        List resultList = new ArrayList();
        if ("locker1".equals(lockerId)) {
            lockObj.put("lockId", "lock1");
            lockObj.put("lockerId", "locker1");
            resultList.add(lockObj);
        }
        if ("locker2".equals(lockerId)) {
            lockObj.put("lockId", "lock2");
            lockObj.put("lockerId", "locker2");
            resultList.add(lockObj);
        }


        resultObj.put("total", 1);
        resultObj.put("deviceList", resultList);

        for(int i =0; i< 20; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return resultObj;
    }

    @GetMapping("/test/locker")
    public JSONObject locker () {
        JSONObject resultObj = new JSONObject();
        JSONObject lockerObj1 = new JSONObject();
        JSONObject lockerObj2 = new JSONObject();
        List resultList = new ArrayList();

        lockerObj1.put("lockerId", "locker1");
        lockerObj2.put("lockerId", "locker2");

        resultList.add(lockerObj1);
        resultList.add(lockerObj2);

        resultObj.put("total", 2);
        resultObj.put("deviceList", resultList);

        return resultObj;
    }

    @RequestMapping("/test/TestStaticMethodAndAutowired")
    public void testStaticMethodAndAutowired () {
        TestStaticMethodAndAutowired.testStaticMethodAndAutowired();
    }

    @RequestMapping("/test/zhihuiqingcheng/xianhong")
    public Object testZhihuiqingchengXianhong(@RequestBody JSONObject jsonObject){
        //String[] strings = {"","",""};

        JSONObject resultJSONObject = testXianHongAPI.main(jsonObject);
        return resultJSONObject;
    }

    @PostMapping("/test/zhihuiqingcheng/chengyun")
    public Object testZhihuiqingchengChengyun(){
        String KEY = ConstantProperties.getChengyunKeyPrivate();
        String API = Constant.CHENGYUNAPIPARKINGS;
        log.info("KEY: {}", KEY);
        log.info("API: {}", API);

        return "testZhihuiqingchengChengyun";
    }

    //测试从配置文件取到值为true的配置时，读到的是字符串“true”，而非布尔true
    @GetMapping("/test/xianhong/autoDeleteZeroLocationValue")
    public Object autoDeleteZeroLocationValue(){
        String autoDeleteZeroLocationValue = Constant.AUTODELETEZEROLOCATIONVALUE;
        log.info("autoDeleteZeroLocationValue: {}", autoDeleteZeroLocationValue);
        if("true".equals(autoDeleteZeroLocationValue)){
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("/test/request/post")
    public Object testRequestPost(@RequestBody JSONObject jsonObject){
        log.info("request body: {}", jsonObject);
        return jsonObject;
    }
}