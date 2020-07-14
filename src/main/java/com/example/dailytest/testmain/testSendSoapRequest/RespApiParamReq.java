package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class RespApiParamReq {
    //参数索引id
    private String id;
    //参数父节点id
    private String pid;
    //参数字段
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{0,49}$", message = "API响应参数中的字段参数不能为空且不超过50个字符，支持英文大小写、数字、下划线，必须以英文开头")
    private String respParamField;
    //参数数据类型
    private String respDataType;

    private String respParamName;
    private boolean isIndex;
    private Boolean markIndex;
    //关联的属性标识
    private String respBindIndex;
}
