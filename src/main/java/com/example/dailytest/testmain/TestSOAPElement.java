/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestSOAPElement
 * Date Created : 2020-07-13
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-13       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-13
 **/
public class TestSOAPElement {

    public static void main(String[] args) throws SOAPException, IOException {
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
        QName bodyName =  new QName("http://www.baidu.com", "Read");
        SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

        SOAPElement se = bodyElement.addChildElement("Options");
        se.setAttribute("LocaleID", "en-US");


        SOAPElement se2 = bodyElement.addChildElement("testValue");
        se2.setValue("VALUE");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        String strMsg = new String(out.toByteArray());
        System.out.println(strMsg);
    }
}