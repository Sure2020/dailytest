/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestKongOauth2Application
 * Date Created : 2021-11-24
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-11-24       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testKongOauth2;

import com.example.dailytest.shenzhenalarm.RestTemplateConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * @program: com.example.dailytest.testKongOauth2
 * @description: xxx
 * @author: w15021
 * @create: 2021-11-24
 **/

//加上该注释后，就可以将该包下面的代码单独运行
@SpringBootApplication(scanBasePackages = {"com.example.dailytest.testKongOauth2"})
public class TestKongOauth2Application {

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        SpringApplication.run(TestKongOauth2Application.class, args);

        // 绕过证书验证
        String url = "https://192.168.110.131:18443/auth/iotbaas/oauth2/token?apikey=99ynYdGumCCdXQEN0Q0bkECo4zGLrGUd";
        RestTemplate restTemplateHttps = new RestTemplate(RestTemplateConfig.generateHttpRequestFactory());
        /*ResponseEntity<String> results = restTemplateHttps.exchange(url, HttpMethod.GET, entity(), String.class);
        JSONObject json = JSON.parseObject(results.getBody());
        System.out.println(json);*/
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("client_id", "iotbaas_oauth2_clientid");
        params.add("grant_type", "password");
        params.add("client_secret", "Aa12345678@h3c");
        params.add("provision_key", "iotbaas_provision");
        params.add("authenticated_userid", "kangzhenyu");
        params.add("username", "kangzhenyu");
        params.add("password", "123456789");

        HttpEntity<LinkedMultiValueMap<String, Object>> request = new HttpEntity<>(params,
                headers);

// 泛型为接口返回数据的类型
        ResponseEntity<Object> response = restTemplateHttps.postForEntity(url, request, Object.class);

// 获取响应主体
        Object out = response.getBody();
        System.out.println(out);


        // 正常调用https的接口，不绕过证书验证。
        /*final RestTemplate restTemplate = new RestTemplate();
        String url = "https://192.168.110.131:18443/auth/iotbaas/oauth2/token?apikey=99ynYdGumCCdXQEN0Q0bkECo4zGLrGUd";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("client_id", "iotbaas_oauth2_clientid");
        params.add("grant_type", "password");
        params.add("client_secret", "Aa12345678@h3c");
        params.add("provision_key", "iotbaas_provision");
        params.add("authenticated_userid", "kangzhenyu");
        params.add("username", "kangzhenyu");
        params.add("password", "123456789");

        HttpEntity<LinkedMultiValueMap<String, Object>> request = new HttpEntity<>(params,
                headers);

// 泛型为接口返回数据的类型
        ResponseEntity<Object> response = restTemplate.postForEntity(url, request, Object.class);

// 获取响应主体
        Object out = response.getBody();
        System.out.println(out);*/
    }
}