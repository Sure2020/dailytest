package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import java.util.List;

/**
 * @author lys1698
 * @date 2019/8/15 16:36
 */
@Data
public class Subscribe {
    // 时间订阅地址
    private String subscribeUrl;
    //报文参数
    private List<RespApiParamReq> subscribeParams;

    private List<Rule> rules;

    private List<RespAPIParams> subscribeStructs;

}