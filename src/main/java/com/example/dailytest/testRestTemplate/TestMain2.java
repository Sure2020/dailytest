/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestMain2
 * Date Created : 2023-11-03
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2023-11-03       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;

/**
 * @program: com.example.hello.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2023-11-03
 **/
public class TestMain2 {
    private static Logger log = LoggerFactory.getLogger(TestMain2.class);

    public static void main(String[] args) throws URISyntaxException {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2OTg5NzgwMzEsInVzZXJuYW1lIjoiYWRtaW4ifQ.5tGxymVteToa0W3ypida-cumxWImk8M_Oe6eeMlnRbA";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("X-Access-Token", token);

        HttpEntity request = new HttpEntity(headers);

        String url = " http://60.191.74.30:19080/platform-boot/data/list?locateTime_end=2023-11-01 01:44:36&locateTime_begin=2023-10-21 01:44:36";
        log.info("request url: {}", url);
        ResponseErrorHandler responseErrorHandler = new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return true;
            }
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
            }
        };
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(responseErrorHandler);

        ResponseEntity<Object> response = null;
        URI uriObject = null;
        try {
            URL urlObject = new URL(url);
            log.info("URL: {}", urlObject.toString());
            uriObject = new URI(urlObject.getProtocol(), null, urlObject.getHost(), urlObject.getPort(), urlObject.getPath(), urlObject.getQuery(), null);
            log.info("URI: {}", uriObject.toString());
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
//(URI url, HttpMethod method, @Nullable HttpEntity<?> requestEntity, Class<T> responseType)
        try {
            response = restTemplate.exchange(uriObject,HttpMethod.GET,request,Object.class);
        } catch (Exception e) {
            log.error("error in request: " + e.getMessage());
            e.printStackTrace();
        }
        log.info("status code: {} ", response.getStatusCodeValue());
        if (response.getStatusCode() == HttpStatus.OK) {
            log.info("Request Successful.");
            log.info(response.getBody().toString());
        } else {
            log.error("Request Failed");
            log.info(response.getBody().toString());
            //System.out.println(response.getBody().toString());
            log.error(String.valueOf(response.getStatusCode()));
        }
        //System.out.println(response.getBody());
    }

}