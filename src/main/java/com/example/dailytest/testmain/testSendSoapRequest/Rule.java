package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import java.util.List;

/**
 * @author lys1698
 * @date 2019/8/15 16:45
 */
@Data
public class Rule {
    // 0 为或，1为与 ,2无条件组
    private String rule;

    private List<Condition> condition;
    // 动作类型 0 add  1 update
    private Integer actionType;

    private List<Action> action;
}