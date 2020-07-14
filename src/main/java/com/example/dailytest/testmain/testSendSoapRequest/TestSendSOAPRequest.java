/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestSentSOAPRequest
 * Date Created : 2020-07-14
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-14       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain.testSendSoapRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.dailytest.testmain.TestSOAPElement;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import javax.xml.soap.SOAPException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-14
 **/
@Slf4j
public class TestSendSOAPRequest {
    public static void main(String[] args) throws IOException, SOAPException {
        System.out.println("test sending soap request");
        //String requestString = TestSOAPElement.main(null);
        String requestString = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><Read xmlns=\"http://opcfoundation.org/webservices/XMLDA/1.0/\"><Options ClientRequestHandle=\"\" LocaleID=\"en-US\" ReturnItemName=\"true\" ReturnItemTime=\"true\"/><ItemList><Items ClientItemHandle=\"1\" ItemName=\"Demo_W7.1001.D3.风机启动\"/></ItemList></Read></soap:Body></soap:Envelope>";
        HttpPost mHttpPost = new HttpPost("http://127.0.0.1:8086/soap");
        StringEntity data = new StringEntity(requestString, Charset.forName("UTF-8"));
        mHttpPost.setEntity(data);
        int code = -1;
        String result = "返回数据为空";
        HttpResponse mHttpResponse = null;
        CloseableHttpClient mHttpClients = HttpClientPoolUtils.getHttpClient();
        //ִ执行网络请求
        try {
            System.out.println("execute");
            for (int i = 0; i <= 3; i++) {
                mHttpResponse = mHttpClients.execute(mHttpPost);
                int respons_code = mHttpResponse.getStatusLine().getStatusCode();
                String codeStr = String.valueOf(respons_code);
                log.info("reponCode:" + codeStr);
                if (null != mHttpResponse && codeStr.startsWith("4")) {
                    //return HttpClientResult.build(respons_code, null);
                    log.info(HttpClientResult.build(respons_code, null).toString());
                }
                if (null != mHttpResponse && codeStr.startsWith("2")) {
                    break;
                } else {
                    ((CloseableHttpResponse) mHttpResponse).close();
                    mHttpPost.releaseConnection();
                }
                if (i == 3) {
                    if (null == mHttpResponse || !(codeStr.startsWith("2"))) {
                        //return HttpClientResult.build(respons_code, null);
                        log.info(HttpClientResult.build(respons_code, null).toString());
                    }
                }
            }
            if (mHttpResponse != null) {
                //获取返回结果
                HttpEntity mHttpEntity = mHttpResponse.getEntity();
                code = mHttpResponse.getStatusLine().getStatusCode();
                log.info("code:" + String.valueOf(code));
                if (mHttpEntity != null) {
                    result = EntityUtils.toString(mHttpEntity, "UTF-8");
                    EntityUtils.consume(mHttpEntity);
                }
            } else {
                //return HttpClientResult.build(1, "网络返回数据为空！");
                log.info(HttpClientResult.build(1, "网络返回数据为空！").toString());

            }
            System.out.println("end");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (mHttpResponse != null) {
                    //关闭流
                    ((CloseableHttpResponse) mHttpResponse).close();
                }
                if (mHttpPost != null) {
                    mHttpPost.releaseConnection();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        result = XmlUtil.XmlTojson(result, "xml");
        JSONObject jsonObject = new JSONObject();;
        if(/*serviceParam.getRespParams().isHttpStatusCode()*/true){
            if (result.startsWith("[")){
                //[{}] jsonArray
                List<JSONObject> tmp = JSONArray.parseArray(result, JSONObject.class);
                // logger.info("result:{}",result);
                jsonObject.put("null",tmp);
            } else {
                jsonObject = JSONObject.parseObject(result);
            }
            jsonObject.put("code",200);
            jsonObject.put("message","成功");
            log.info("解析后结果:" + jsonObject.toString());
            //return HttpClientResult.build(code, jsonObject.toJSONString());
            log.info(HttpClientResult.build(code, jsonObject.toJSONString()).toString());
        }
        log.info("解析后结果:" + result.toString());
        //return HttpClientResult.build(code, result.toString());
        log.info(HttpClientResult.build(code, result.toString()).toString());
    }
}