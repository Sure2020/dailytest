/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMyController
 * Date Created : 2020-05-20
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-05-20       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testRestTemplate;

/**
 * @program: com.example.dailytest.testRestTemplate
 * @description: xxx
 * @author: w15021
 * @create: 2020-05-20
 **/

import org.springframework.web.bind.annotation.*;

/**
 * Rest测试类
 */
@RestController
public class TestMyController {

    /**
     * get方法测试
     * @return
     */
    @GetMapping("testGet")
    public TestEntity testGet() {
        TestEntity testEntity = new TestEntity();
        testEntity.setId(1);
        testEntity.setName("get");
        return testEntity;
    }

    /**
     * post方法
     * @return
     */
    @PostMapping("testPost")
    public TestEntity testPost(){
        TestEntity testEntity = new TestEntity();
        testEntity.setId(1);
        testEntity.setName("post");
        return testEntity;
    }


    /**
     * post 方法传值
     * @param id
     * @param name
     * @return
     */
    @PostMapping("testPostParam")
    public String testPostParam(@RequestParam("id") String id,@RequestParam("name") String name){
        System.out.println("Post id:"+id);
        System.out.println("Post name:"+name);
        return "post succ";
    }


    /**
     * post 方法传值
     * @param id
     * @param name
     * @return
     */
    @PutMapping("testPut")
    public String testPut(@RequestParam("id") String id,@RequestParam("name") String name){
        System.out.println("put id:"+id);
        System.out.println("put name:"+name);
        return "del succ";
    }


    /**
     * del方法传值
     * @param id
     * @return
     */
    @DeleteMapping("testDel")
    public String testDel(@RequestParam("id") String id){
        System.out.println("del id:"+id);
        return "del succ";
    }

}