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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
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
        String operation = "Read";
        QName bodyName =  new QName("http://opcfoundation.org/webservices/XMLDA/1.0/", operation);
        /*SOAPBodyElement bodyElementTemp = body.addBodyElement(bodyName);

        SOAPElement bodyElement = bodyElementTemp;*/
        SOAPElement bodyElement = body.addBodyElement(bodyName);

        /*SOAPElement se = bodyElement.addChildElement("Options");
        se.setAttribute("LocaleID", "en-US");

        bodyElement.setAttribute("ItemName", "铁岭高速.Channel_1.Device_1.AI");


        SOAPElement se2 = bodyElement.addChildElement("testValue");
        se2.setValue("VALUE");

        SOAPElement se3 = bodyElement.addChildElement("ItemList");
        SOAPElement itemsElement = se3.addChildElement("Items");
        itemsElement.setAttribute("ItemName", "valueOfItemName");*/
        System.out.println("##############################  测试递归组装xml请求体   ##############################");
        JSONObject optionJSONObject = new JSONObject();
        optionJSONObject.put("ReturnItemName", "true");

        JSONObject itemListJSONObject = new JSONObject();
        JSONObject itemsJSONObject = new JSONObject();
        itemsJSONObject.put("ItemName", "铁岭高速.Channel_1.Device_1.AI.温度1");
        itemListJSONObject.put("Items", itemsJSONObject);

        JSONObject requestJSONObject = new JSONObject();
        requestJSONObject.put("Options", optionJSONObject);
        requestJSONObject.put("ItemList", itemListJSONObject);

        JSONObject operationJSONObject = new JSONObject();
        operationJSONObject.put("ReturnErrorText", "true");

        requestJSONObject.put(operation, operationJSONObject);

        System.out.println("requestJSONObject: " + requestJSONObject);
        /*组装后的结构：
        {
            "Options":{
            "ReturnItemName":"true"
        },
            "ItemList":{
            "Items":{
                "ItemName":"铁岭高速.Channel_1.Device_1.AI.温度1"
            }
        }
        }*/

        addAttributeForbodyElement(bodyElement, requestJSONObject, operation);
        System.out.println("requestJSONObject: " + requestJSONObject);
        soapMessageToString(message);
        addChildElementForElement(bodyElement,requestJSONObject);

        System.out.println("##############################  测试解析返回值   ##############################");
        String xmlString = soapMessageToString(message);

        //return xmlString;
    }




    public void fuction () {
        //循环读取每个json的key，
        //判断当前key的value是json对象还是string
        //如果是string，执行addChildElement（key）
        //setArrtibute(se,)


        //终止条件：当前key的value是string
        //终止动作：se.setAttribute
    }

    public static void addChildElementForElement (SOAPElement soapElement, JSONObject requestObj) throws SOAPException {

        for (String currentObjKey : requestObj.keySet()) {
            Object currentObj = requestObj.get(currentObjKey);
            if (currentObj instanceof JSONObject) {
                JSONObject currentJsonObj = (JSONObject)currentObj;
                SOAPElement se = soapElement.addChildElement(currentObjKey);
                //递归
                addChildElementForElement(se, currentJsonObj);
            } else if (currentObj instanceof String){
                String currentObjValue = currentObj.toString();
                soapElement.setAttribute(currentObjKey, currentObjValue);
            } else if (currentObj instanceof JSONArray) {
                log.error("当xml参数风格为key=value时，暂不支持该分支的情况");
            } else {
                log.error("不支持的类型");
                return;
            }
        }
    }

    public static void addAttributeForbodyElement(SOAPElement soapElement, JSONObject requestObj, String operation){
        if(requestObj.keySet().contains(operation)){
            JSONObject jsonObjectNamedOperation = requestObj.getJSONObject(operation);
            if(jsonObjectNamedOperation != null && jsonObjectNamedOperation.size() > 0) {
                for(String currentObjKey : jsonObjectNamedOperation.keySet()){
                    String currentObjValue = jsonObjectNamedOperation.getString(currentObjKey);
                    soapElement.setAttribute(currentObjKey, currentObjValue);
                }
            }

            requestObj.remove(operation);
        }
        return;
    }

    public static void soapMsgToStr(SOAPMessage message) throws IOException, SOAPException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        String strMsg = new String(out.toByteArray());
        System.out.println(strMsg);
    }

    //找到的一个很好很规范的soapMessage转为String的函数
    public static String soapMessageToString(SOAPMessage message)
    {
        String result = null;

        if (message != null)
        {
            ByteArrayOutputStream baos = null;
            try
            {
                baos = new ByteArrayOutputStream();
                message.writeTo(baos);
                result = baos.toString();
            }
            catch (Exception e)
            {
            }
            finally
            {
                if (baos != null)
                {
                    try
                    {
                        baos.close();
                    }
                    catch (IOException ioe)
                    {
                    }
                }
            }
        }
        System.out.println("soapMessageToString: " + result);
        return result;
    }
}