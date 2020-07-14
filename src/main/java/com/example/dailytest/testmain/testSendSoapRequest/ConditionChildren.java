package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

/**
 * @author lys1698
 * @date 2019/8/15 16:52
 */
@Data
public class ConditionChildren {
    // 参数名称
    private String respParamName;
    //参数字段
    private String respParamField;
    // 大于 等于 小于
    private String symbol;
    //参数值
    private String value;

}