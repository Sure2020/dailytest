/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DemoService
 * Date Created : 2020-04-24
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-04-24       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.shenzhenalarm.testRestTemplate;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @program: com.example.shenzhenalarm.testRestTemplate
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-24
 **/
@Service
public class DemoService {

    @Autowired
    private RestTemplate restTemplate;

    public String get(){
        String url = "http://ag-api.ctwing.cn/echo";
        //String url = "http://yapi.demo.qunar.com/mock/88981/dailytest/device";
        return restTemplate.getForObject(url,String.class);
    }

    public String getTimestamp(){
        String url = "http://ag-api.ctwing.cn/echo";
        ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);
        //HttpStatus statusCode = responseEntity.getStatusCode();
        //Object obj = responseEntity.getBody();
        HttpHeaders header = responseEntity.getHeaders();
        System.out.println(header);
        String timestamp = header.get("timestamp").get(0);
        System.out.println(timestamp);
        return "say hi";
    }

    public long getTimeOffset(){
        long offset = 0;
        String url = "http://ag-api.ctwing.cn/echo";

        long start = System.currentTimeMillis();
        ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);
        long end = System.currentTimeMillis();

        //HttpStatus statusCode = responseEntity.getStatusCode();
        //Object obj = responseEntity.getBody();
        HttpHeaders header = responseEntity.getHeaders();
        String responseTimestamp = header.get("timestamp").get(0);
        if (responseTimestamp.length() > 0) {
            long serviceTime = Long.parseLong(responseTimestamp);
            offset = serviceTime - (start + end) / 2L;
        }

        return offset;
    }

    public long getTimeOffset2() {
        long offset = 0;
        HttpResponse response = null;

        //构造httpGet请求
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpTimeGet = new HttpGet("https://ag-api.ctwing.cn/echo");

        try {
            long start = System.currentTimeMillis();
            response = httpClient.execute(httpTimeGet);
            long end = System.currentTimeMillis();
            //时间戳在返回的响应的head的x-ag-timestamp中
            Header[] headers = response.getHeaders("x-ag-timestamp");
            if (headers.length > 0) {
                long serviceTime = Long.parseLong(headers[0].getValue());
                offset = serviceTime - (start + end) / 2L;
            }
            httpClient.close();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return offset;
    }
}