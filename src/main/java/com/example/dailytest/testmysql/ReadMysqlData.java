/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ReadMysqlData
 * Date Created : 2020-09-04
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-09-04       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmysql;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.dailytest.testmysql
 * @description: xxx
 * @author: w15021
 * @create: 2020-09-04
 **/
@Slf4j
public class ReadMysqlData {
    public void readData() {
        System.out.println("okie-dokie");
        System.out.println("readData");

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/iotinfomgr", "admin","Aa123456");
        } catch (ClassNotFoundException e) {
            log.error("mysql 数据库连接地址不可用");
            e.printStackTrace();
        } catch (SQLException e) {
            log.error("mysql 数据库连接地址不可用");
            e.printStackTrace();
        }

        // 拼接sql查询语句
        String sqlexcu = "select * from tab";
        log.info("sql 查询 :{}",sqlexcu);
        //执行正常 字段参数 -->表名无误
        try {
            connection.prepareStatement(sqlexcu + " limit 0,1").executeQuery();
        }catch (SQLException e){
            log.error("参数配置有误");
        }
        List list = new ArrayList();
        list.add("a");
        list.add("b");
        try {
            PreparedStatement ps = connection.prepareStatement(sqlexcu);
            ps.setFetchSize(2000);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                log.info(rs.getString(1) + "  " + rs.getString(2));
                if (list.size() % 2000 == 0) {
                    processData(list);
                }
            }
            if (list.size() != 0) {
                processData(list);
            }
        } catch (SQLException e) {
            log.error("参数配置有误");
        }
        log.info("last size: " + list.size());
    }

    public void processData(List list){
        log.info(String.valueOf(list.size()));
        list.clear();
    }
}