package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import javax.validation.constraints.Pattern;

/**
 * @author lys1698
 * @date 2019/8/15 16:59
 */
@Data
public class Push {
    //推送地址
    private String pushUrl;
    //事件唯一标识
    @Pattern(regexp = "[a-zA-Z0-9_]{0,31}$", message = "eventId不超过32个字符，支持英文大小写、数字、下划线")
    private String eventId;
    //监听属性

    private String pushType;

    private String[] listenAttr;
}