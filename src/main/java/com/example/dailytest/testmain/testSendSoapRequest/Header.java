package com.example.dailytest.testmain.testSendSoapRequest;

import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author lys1698
 * @date 2019/8/15 17:01
 */
@Data
public class Header {

    private String auth;
    @Pattern(regexp = "[a-zA-Z0-9_]{0,31}$", message = "acessKey不超过32个字符，支持英文大小写、数字、下划线")

    private String acessKey;

    @Pattern(regexp = "[a-zA-Z0-9_]{0,31}$", message = "secretKey不超过32个字符，支持英文大小写、数字、下划线")
    private String secretKey;

    private List<HeaderMap> headers;
}