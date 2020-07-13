/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestJsonToXml
 * Date Created : 2020-07-11
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-11       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-11
 **/
public class TestJsonToXml {

    public static void main(String[] args) {
        System.out.println("testing json to xml");
        /*StringBuilder stringBuilder = new StringBuilder
                ("{\"Options\":\"ReturnItemName=true\",\"ItemList\":{\"Items\":\"ItemName=铁岭高速.Channel_1.Device_1.AI.温度1\"}}");
        //{"Options":"ReturnItemName=true","ItemList":{"Items":"ItemName=铁岭高速.Channel_1.Device_1.AI.温度1"}}
        String sourceStr = stringBuilder.toString();
        System.out.println(sourceStr);*/
        JSONObject jsonObject = new JSONObject();
        //jsonObject.put("String", "I am String");

        JSONObject subJsonObject = new JSONObject();
        subJsonObject.put("subJsonObject", "I am subJsonObject");

        //jsonObject.put("subJsonObject", subJsonObject);


        JSONObject subJsonObject1_forArray = new JSONObject();
        subJsonObject1_forArray.put("a", "a_forArray");

        JSONObject subJsonObject2_forArray = new JSONObject();
        subJsonObject2_forArray.put("b", "b_forArray");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(subJsonObject1_forArray);
        jsonArray.add(subJsonObject2_forArray);

        jsonObject.put("jsonArray", jsonArray);

        System.out.println(jsonObject);

        String jsonToXmlStr = jsonToXml(jsonObject, "Read", "http://opcfoundation.org/webservices/XMLDA/1.0/");
        System.out.println(jsonToXmlStr);
    }

    public static String jsonToXml(JSONObject jsonObject, String operation, String namespace) {
        String xml1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">\n" +
                "  <soap12:Body>\n" +
                "    <" + operation + " xmlns=\"" + namespace + "\"" + ">\n";
        String xml2 = "    </" + operation + ">\n"+"  </soap12:Body>\n" +
                "</soap12:Envelope>";
        String body = json2xml(jsonObject);
        String xml = xml1 + body + xml2;
        return xml;
    }

    public static String json2xml(JSONObject jsonObj) {
        StringBuffer buff = new StringBuffer();
        JSONObject tempObj = null;
        JSONArray tempArr = null;
        for (String temp : jsonObj.keySet()) {
            jsonObj.get(temp);
            if (jsonObj.get(temp) instanceof JSONObject) {
                buff.append("<" + temp.trim() + ">");
                tempObj = (JSONObject) jsonObj.get(temp);
                buff.append(json2xml(tempObj));
                buff.append("</" + temp.trim() + ">");
            } else if (jsonObj.get(temp) instanceof JSONArray) {
                buff.append("<" + temp.trim() + ">");
                tempArr = (JSONArray) jsonObj.get(temp);
                if (tempArr.size() > 0) {
                    for (int i = 0; i < tempArr.size(); i++) {
                        tempObj = (JSONObject) tempArr.get(i);
                        buff.append(json2xml(tempObj));
                    }
                }
                buff.append("</" + temp.trim() + ">");
            } else {
                buff.append("<" + temp.trim() + " ");
                String tempStr = jsonObj.get(temp).toString();
                buff.append(tempStr.trim());
                buff.append("></" + temp.trim() + ">");
            }
        }
        return buff.toString();
    }
}