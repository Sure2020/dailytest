/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : ClientController
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

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * @author zeroJun
 * @program demo
 * @description 发送端
 * @create 2018-12-16 09:48
 * @since 1.0
 **/
public class ClientController {

    /**
     * 私钥
     */
    private final static String PRIVATE_KEY = "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAraqkAA0eEXqPmdNwcaEeUkGe3VmxhXo3J73qztU5FmuZwyf0VtVjNfLo1vCMEqzsjl793AZ8QI/uwPQMThV8+wIDAQABAkBRDBbXc0e6DoGf315VmUSmTLuQP8CqMzw0TtybREUNIcpxfi5EDCGhsSvKjsPq7TAoWcMKl+MolXbE0ncJ+3jxAiEA6KYJVB62XXjALk9iDDD4QCs9eqpMVYgQoYs3wxnxHnkCIQC/GQvpjEM79k8h/IY7+BhNW1bI9Mjxfb4B71/UsBuKEwIgfJRcrnT7xrXgg2vy3wBiD0qYU1VaJvsDnN3F8G211lECIEAublTLOg2ahStZ/8+GXMsmYThvFkodPEK0HdB2MVmnAiB9E4ORf2cWfVSmyY5QTlDYfvBHGccol/nU+4WKZFW/2g==";

    public static String sender() throws InvalidKeySpecException, NoSuchAlgorithmException,
            InvalidKeyException, SignatureException, UnsupportedEncodingException {
        // 请求所需的参数
        Map<String, Object> requestParam = new HashMap<>(16);
        requestParam.put("userName", "×××");
        requestParam.put("phone", "15866552236");
        requestParam.put("address", "北京");
        requestParam.put("status", 1);

        // 将需要签名的参数内容按参数名的字典顺序进行排序，并拼接为字符串
        StringBuilder sb = new StringBuilder();
        requestParam.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(entry ->
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&")
        );
        String paramStr = sb.toString().substring(0, sb.length() - 1);

        // 使用私钥生成签名字符串
        String sign = JdkSignatureUtil.executeSignature(PRIVATE_KEY, paramStr);
        // 对签名字符串进行url编码
        String urlEncodeSign = URLEncoder.encode(sign, StandardCharsets.UTF_8.toString());
        // 请求参数中需带上签名字符串
        requestParam.put("sign", urlEncodeSign);

        // 发送请求
        //return postJson("http://localhost:8080/server", requestParam);
        ServerController serverController = new ServerController();
        return serverController.serverInner(requestParam);
    }

    /**
     * 发送数据类型为json的post请求
     *
     * @param url
     * @param param
     * @param <T>
     * @return
     */
    public static <T> String postJson(String url, T param) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<T> httpEntity = new HttpEntity<>(param, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, httpEntity, String.class);

        return responseEntity.getBody();
    }

    public static void main(String[] args) {
        try {
            System.out.println(sender());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}