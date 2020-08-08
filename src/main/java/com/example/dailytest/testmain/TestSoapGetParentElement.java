/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestSoapSetParentElement
 * Date Created : 2020-08-08
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-08-08       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSONObject;
import com.example.dailytest.testmain.testSendSoapRequest.HttpClientPoolUtils;
import lombok.extern.slf4j.Slf4j;
import org.json.XML;

import javax.xml.namespace.QName;
import javax.xml.soap.*;

import static com.example.dailytest.testmain.TestSOAPElement.convertToString;
import static com.example.dailytest.testmain.TestSOAPElement.soapMessageToString;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-08-08
 **/
@Slf4j
public class TestSoapGetParentElement {
    public static void main(String[] args) throws SOAPException {
        System.out.println("TestSoapSetParentElement");
        /*WebService webService = serviceParam.getWebService();
        String operation = webService == null ? null : webService.getOperation();
        String namespace = webService == null ? null : webService.getNamespace();
        //String resType = webService == null ? null : webService.getRespType();*/
        //String operation = "Read";
        String namespace = "http://opcfoundation.org/webservices/XMLDA/1.0/";
        String operation = "Read";

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


        SOAPElement se = bodyElement.addChildElement("ItemList");
        SOAPElement itemsElem = null;
        se.setAttribute("LocaleID", "en-US");
        itemsElem = se.addChildElement("Items");
        itemsElem.setAttribute("key","value");
        itemsElem.getParentElement().setAttribute("parent","parent");
        //itemsElem.setParentElement();

        soapMessageToString(message);

        //见函数说明
        //HttpClientPoolUtils.addAttributeForbodyElement(bodyElement, requestBody, operation);
        //System.out.println(soapMessageToString(message));
        //System.out.println("#################");
        //见函数说明
        //HttpClientPoolUtils.addChildElementForElement(bodyElement, requestBody);
        //System.out.println(soapMessageToString(message));
    }
}