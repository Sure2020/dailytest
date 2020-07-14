package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

@Data
public class HttpClientResult {
    private int code;
    private Object entity;

    public HttpClientResult(int code, Object entity){
        this.code=code;
        this.entity=entity;
    }
    public HttpClientResult(){}
    public static HttpClientResult build(Integer code, Object entity ){
        return new HttpClientResult(code,entity);
    }

}
