package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

/**
 * @author lys1698
 * @date 2019/8/15 16:56
 */
@Data
public class Action {
    //参数字段
    private String respParamField;
    private String respParamName;
    //参数值
    private String value;
    //关联 等于
    private String flag;
}