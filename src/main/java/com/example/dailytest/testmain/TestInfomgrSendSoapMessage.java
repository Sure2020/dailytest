/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestInfomgrSendSoapMessage
 * Date Created : 2020-07-15
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-15       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.example.dailytest.testmain.testSendSoapRequest.HttpClientPoolUtils;
import lombok.extern.slf4j.Slf4j;
import org.json.XML;

import javax.xml.namespace.QName;
import javax.xml.soap.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.dailytest.testmain.TestSOAPElement.*;


/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-15
 **/
@Slf4j
public class TestInfomgrSendSoapMessage {
    public static void main(String[] args) throws Exception {
        String endpoint = "http://127.0.0.1:8086/soap/";
        JSONObject requestBody = new JSONObject();
        //requestBody.put("ItemName","Demo_W7.1001.D3");
        requestBody = JSONObject.parseObject("{\"Options\":{\"ReturnItemName\":\"true\"},\"ItemList\":{\"Items\":{\"ItemName\":[\"Demo_W7.1001.D3.回风温度\",\"Demo_W7.1001.D3.送风湿度\"]}}}");
        //requestBody = JSONObject.parseObject("{\"Options\":{\"ReturnItemName\":\"true\"},\"ItemList\":{\"Items\":{\"ItemName\":\"Demo_W7.1001.D3.回风温度\"}}}");
        //requestBody = JSONObject.parseObject("{\"ItemList\":{\"Items\":{\"ItemName\":[\"Demo_W7.1001.D3.回风温度\",\"Demo_W7.1001.D3.送风湿度\"]}}}");

        System.out.println("request body: " + requestBody.toString());

        ArrayList tempList = new ArrayList();
        tempList.add("Demo_W7.1001.D3.送风湿度");
        tempList.add("Demo_W7.1001.D3.回风温度");

        requestBody.getJSONObject("ItemList").getJSONObject("Items").put("ItemName",tempList);

        System.out.println("request body: " + requestBody.toString());
        Object tempObj = requestBody.getJSONObject("ItemList").getJSONObject("Items").get("ItemName");
        System.out.println(tempObj.toString());
        if (tempObj instanceof ArrayList) {
            System.out.println("I'm a ArrayList !!!");
        }
        if (tempObj instanceof JSONArray) {
            System.out.println("I'm a JSONArray !!!");
        }
        if (tempObj instanceof List) {
            System.out.println("I'm a List !!!");
        }
        getWebServiceResultKeyValueStyle(endpoint, requestBody, "Read");
    }

    public static void getWebServiceResultKeyValueStyle(String endpoint, JSONObject requestBody, String operation) throws Exception {

        /*WebService webService = serviceParam.getWebService();
        String operation = webService == null ? null : webService.getOperation();
        String namespace = webService == null ? null : webService.getNamespace();
        //String resType = webService == null ? null : webService.getRespType();*/
        //String operation = "Read";
        String namespace = "http://opcfoundation.org/webservices/XMLDA/1.0/";

        //  创建消息对象
        // ===========================================
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();

        MimeHeaders mh = message.getMimeHeaders();
        mh.removeAllHeaders();
        /*for(HeaderMap headerMap : headerMapList) {
            mh.addHeader(headerMap.getKey(),headerMap.getValue());
        }*/
        //这里将Content-Type设置为"text/xml; charset=utf-8"，防止用户遗忘设置header的情况。如果用户有设置，则该项无效。
        mh.addHeader("Content-Type","text/xml; charset=utf-8");
        mh.addHeader("SOAPAction","http://opcfoundation.org/webservices/XMLDA/1.0/" + operation);

        // 获取soap的信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        //envelope.setPrefix("soap");

        // 获取消息的body
        SOAPBody body = message.getSOAPBody();
        //body.setPrefix("soap");
        QName bodyName =  new QName(namespace, operation);
        //SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
        SOAPElement bodyElement = body.addBodyElement(bodyName);

        //见函数说明
        HttpClientPoolUtils.addAttributeForbodyElement(bodyElement, requestBody, operation);
        System.out.println(soapMessageToString(message));
        System.out.println("#################");
        //见函数说明
        HttpClientPoolUtils.addChildElementForElement(bodyElement, requestBody);
        System.out.println(soapMessageToString(message));

        int httpCode = -1;
        SOAPMessage response = null;
        try {
            SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
            response = connection.call(message, endpoint);
            connection.close();
            //暂时没找到怎么从SOAPMessage 类型的response中获取http code，于是先这样处理
            httpCode = 200;
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }

        SOAPBody responseBody = response.getSOAPBody();
        String responseBodyStr = convertToString(responseBody);
        System.out.println("responseBodyStr:\n" + responseBodyStr);
        String responseBodyJSONObjectStr = XML.toJSONObject(responseBodyStr).toString();

        JSONObject resultJSONObject = JSONObject.parseObject(responseBodyJSONObjectStr);
        resultJSONObject.put("code",200);
        resultJSONObject.put("message","成功");
        log.info("解析后结果:" + resultJSONObject.toString());
        //return HttpClientResult.build(httpCode, resultJSONObject.toJSONString());
    }
}