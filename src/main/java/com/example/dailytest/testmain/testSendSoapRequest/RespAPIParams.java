package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@Data
public class RespAPIParams implements Serializable {
    //参数字段
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{0,29}$", message = "API响应参数中的字段参数不能为空且不超过30个字符，支持英文大小写、数字、下划线，必须以英文开头")
    private String respParamField;

    private String respParamName;
    //参数数据类型
    private String respDataType;
    //关联的属性标识
    private String respBindIndex;
    //关联的属性名
    private String respBindAttr;

    private boolean isIndex;

    private Boolean markIndex;
    //孩子节点
    private List<RespAPIParams> apiChildrens;

}
