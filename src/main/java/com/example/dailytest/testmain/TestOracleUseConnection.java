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
    /*public static void main(String[] args) {
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
    }*/
    public static void main(String[] args){
        Connection conn = null;
        String url = "jdbc:oracle:thin:@//192.168.56.45:1522/orcl2";
        String username = "system";
        String password = "iotadmin_2021";
        String tableName = "test_oracle";
        try {
            System.out.println();
            System.out.println("begin to connect oracle");
            System.out.println("url:" + url + "--" + username + ":" + password);
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, username, password);
            conn.prepareStatement("select count(1) from " + tableName).executeQuery();
            System.out.println(conn);
            System.out.println("数据库连接成功");
        } catch (Exception e) {
            System.out.println("数据库连接异常");
            e.printStackTrace();
            String message = e.toString();
            if (message.contains("ORA-01017")) {
                System.out.println("数据库连接失败，请检查用户名或密码！");
            } else if (message.contains("SQLRecoverableException") && message.contains("The Network Adapter could not establish the connection")) {
                System.out.println("数据库连接失败，请检查IP和PORT是否输入正确！");
            } else {
                System.out.println("数据库连接失败，配置错误请检查!");
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("conn 关闭异常");
            }
        }
    }
}