package com.example.dailytest.testmysql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ReadMysqlDataTest {

    @Test
    void readData() {
        ReadMysqlData readMysqlData = new ReadMysqlData();
        readMysqlData.readData();
    }
}