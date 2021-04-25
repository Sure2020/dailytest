/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ServerController
 * Date Created : 2021-04-20
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-04-20       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testsign;

/**
 * @program: com.example.dailytest.testsign
 * @description: xxx
 * @author: w15021
 * @create: 2021-04-20
 **/

import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.Comparator;
import java.util.Map;

/**
 * @author 01
 * @program demo
 * @description 接收端
 * @create 2018-12-16 09:48
 * @since 1.0
 **/
@RestController
public class ServerController {

    /**
     * 公钥
     */
    private final static String PUBLIC_KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAK2qpAANHhF6j5nTcHGhHlJBnt1ZsYV6Nye96s7VORZrmcMn9FbVYzXy6NbwjBKs7I5e/dwGfECP7sD0DE4VfPsCAwEAAQ==";

    @PostMapping(value = "/server")
    public String server(@RequestBody Map<String, Object> param) throws InvalidKeySpecException,
            NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        // 从参数中取出签名字符串并删除，因为sign不参与字符串拼接
        String sign = (String) param.remove("sign");
        // 对签名字符串进行url解码
        String decodeSign = URLDecoder.decode(sign, StandardCharsets.UTF_8.toString());

        // 将签名的参数内容按参数名的字典顺序进行排序，并拼接为字符串
        StringBuilder sb = new StringBuilder();
        param.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(entry ->
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&")
        );
        String paramStr = sb.toString().substring(0, sb.length() - 1);

        // 使用公钥进行验签
        boolean result = JdkSignatureUtil.verifySignature(PUBLIC_KEY, decodeSign, paramStr);
        if (result) {
            return "签名验证成功";
        }

        return "签名验证失败，非法请求";
    }

    public String serverInner(Map<String, Object> param) throws InvalidKeySpecException,
            NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {
        // 从参数中取出签名字符串并删除，因为sign不参与字符串拼接
        String sign = (String) param.remove("sign");
        // 对签名字符串进行url解码
        String decodeSign = URLDecoder.decode(sign, StandardCharsets.UTF_8.toString());

        // 将签名的参数内容按参数名的字典顺序进行排序，并拼接为字符串
        StringBuilder sb = new StringBuilder();
        param.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(entry ->
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&")
        );
        String paramStr = sb.toString().substring(0, sb.length() - 1);

        // 使用公钥进行验签
        boolean result = JdkSignatureUtil.verifySignature(PUBLIC_KEY, decodeSign, paramStr);
        if (result) {
            return "签名验证成功";
        }

        return "签名验证失败，非法请求";
    }
}