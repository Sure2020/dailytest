package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * @author lys1698
 * @date 2019/10/18 10:05
 */
@Data
public class WebService {
    @Pattern(regexp = "^[a-zA-Z0-9_]{1,50}$", message = "operation由数字、英文、下划线组成，最多50个字符")
    private String operation;
    private String namespace;
    private String respType;
}