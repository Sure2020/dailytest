package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import java.util.List;

/**
 * @author lys1698
 * @date 2019/8/15 16:50
 */
@Data
public class Condition {
    // 0 为或，1为与
    private String conditionRule;

    private List<ConditionChildren> conditionArray;

}