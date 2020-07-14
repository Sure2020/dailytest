package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author lys1698
 * @date 2019/8/15 17:02
 */
@Data
public class HeaderMap {
    @Pattern(regexp = "[a-zA-Z0-9_]{0,31}$", message = "header中字段参数不超过32个字符，支持英文大小写、数字、下划线")
    private String key;
    @Size(min = 0, max = 200, message = "Header中参数值最大长度为200")
    private String value;
}