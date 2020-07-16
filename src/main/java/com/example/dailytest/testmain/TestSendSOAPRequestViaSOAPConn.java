/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestSendSOAPRequestViaSOAPConn
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

package com.example.dailytest.testmain;

import org.json.JSONException;
import org.json.XML;
//import org.opcfoundation.webservices.xmlda._1.ReadRequestItem;
//import org.opcfoundation.webservices.xmlda._1.ReadRequestItemList;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;

import static com.example.dailytest.testmain.TestSOAPElement.*;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-14
 **/
public class TestSendSOAPRequestViaSOAPConn {
    //public static String endpoint = "http://rap2.taobao.org:38080/app/mock/data/1619186";//"http://127.0.0.1:8086/soap";
    public static String endpoint = "http://127.0.0.1:8086/soap";
    private static final String namespace = "http://opcfoundation.org/webservices/XMLDA/1.0/";
    public static void main(String[] args) throws Exception {
        System.out.println("TestSendSOAPRequestViaSOAPConn ");
        //  创建消息对象
        // ===========================================
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();

        MimeHeaders mh = message.getMimeHeaders();
        mh.addHeader("SOAPAction", "http://opcfoundation.org/webservices/XMLDA/1.0/Read");

        // 获取soap的信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        envelope.setPrefix("soap");

        // 获取消息的body
        SOAPBody body = message.getSOAPBody();
        body.setPrefix("soap");
        QName bodyName =  new QName(namespace, "Read");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        SOAPElement se = bodyElement.addChildElement("Options");
        se.setAttribute("LocaleID", "en-US");
        se.setAttribute("ClientRequestHandle", "");
        se.setAttribute("ReturnItemTime", "false");
        se.setAttribute("ReturnItemName", "true");

        se = bodyElement.addChildElement("ItemList");
        SOAPElement itemsElem = se.addChildElement("Items");
        itemsElem.setAttribute("ItemName", "Demo_W7.1001.D3.风机启动");
        itemsElem.setAttribute("ClientItemHandle", "1");
        SOAPElement itemsElem2 = se.addChildElement("Items");
        itemsElem2.setAttribute("ItemName", "Demo_W7.1001.D3.送风温度");
        itemsElem2.setAttribute("ClientItemHandle", "2");

        SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
        SOAPMessage response = connection.call(message, endpoint);
        connection.close();

        System.out.println(soapMessageToString(response));

        SOAPBody responseBody = response.getSOAPBody();
        //String responseBodyStr = soapBodyToString(responseBody);
        String responseBodyStr = convertToString(responseBody);
        System.out.println(responseBodyStr);
        System.out.println(XML.toJSONObject(responseBodyStr).toString());

        //String responseString = soapMessageToString(response);

        //System.out.println(XML.toJSONObject(responseString).toString());
    }
}