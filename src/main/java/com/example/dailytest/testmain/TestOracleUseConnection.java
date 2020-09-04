/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestOracleUseConnection
 * Date Created : 2020-09-02
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-09-02       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import org.bson.Document;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-09-02
 **/
public class TestOracleUseConnection {
    public static void main(String[] args) {
        System.out.println("TestOracleUseConnection");
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@192.168.56.156:1521:orcl";
            //String url = "jdbc:oracle:thin:@localhost:1521/orcl";
            connection = DriverManager.getConnection(url,
                    "testuser","Aa123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //StringBuilder sql = new StringBuilder("select first_name, last_name from employees");
        String sqlexcu = "select first_name, last_name from employees";
        List<Document> list = new ArrayList<>();
        //执行正常 字段参数 -->表名无误
        try {
            connection.prepareStatement("select count(1) from employees").executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = connection.prepareStatement(sqlexcu);
            ps.setFetchSize(2000);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                System.out.println("FIRST_NAME" + "  " + "LAST_NAME");
                System.out.println("---------------------");
                System.out.println(resultSet.getString(1) + " "
                        + resultSet.getString(2) + " ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}