package com.example.dailytest.testmain.testSendSoapRequest;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class RespParams implements Serializable {
    //响应成功字段
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_.]{0,49}$",message ="响应成功字段不能为空且不超过50个字符，支持英文大小写、数字、下划线、英文.符号，必须以英文开头")
    private String respSuccessField;
    //响应成功标志
    @Pattern(regexp="^[a-zA-Z0-9_]{1,15}$",message ="响应成功标志不能为空且不超过15个字符，支持英文大小写、数字、下划线")
    private String respSuccessCode;

    private boolean httpStatusCode;

    public RespParams() {
    }

    public RespParams(String respSuccessField, String respSuccessCode) {
        this.respSuccessField = respSuccessField;
        this.respSuccessCode = respSuccessCode;
    }

    public String getRespSuccessField() {
        return respSuccessField;
    }

    public void setRespSuccessField(String respSuccessField) {
        this.respSuccessField = respSuccessField;
    }

    public String getRespSuccessCode() {
        return respSuccessCode;
    }

    public void setRespSuccessCode(String respSuccessCode) {
        this.respSuccessCode = respSuccessCode;
    }

    public boolean isHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(boolean httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    @Override
    public String toString() {
        return "RespParams{" +
                "respSuccessField='" + respSuccessField + '\'' +
                ", respSuccessCode='" + respSuccessCode + '\'' +
                '}';
    }
}
