/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestInfomgrXmlToJson
 * Date Created : 2021-02-09
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-02-09       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSONObject;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import static com.example.dailytest.testmain.testSendSoapRequest.XmlUtil.dom4j2Json;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2021-02-09
 **/
public class TestInfomgrXmlToJson {
    public static void main(String[] args) {
        System.out.println("TestInfomgrXmlToJson");
        String sourceString = "<Entries xmlns=\"http://bigdata.h3c.com/dataservice\">\n" +
                "\t<Entry>\n" +
                "\t\t<tb_id>4</tb_id>\n" +
                "\t\t<XN>2020-2021</XN>\n" +
                "\t\t<XQ>1</XQ>\n" +
                "\t\t<BH>D3-d325</BH>\n" +
                "\t\t<MC>D3-d325</MC>\n" +
                "\t\t<XIAOQ>广州国际校区</XIAOQ>\n" +
                "\t\t<ZWS>108</ZWS>\n" +
                "\t\t<KSZWS>54</KSZWS>\n" +
                "\t\t<XQJ>2</XQJ>\n" +
                "\t\t<ZC>2-13周</ZC>\n" +
                "\t\t<JC>1-2</JC>\n" +
                "\t\t<KCMC>Inorganic Chemistry-III</KCMC>\n" +
                "\t\t<KCYWMC>Inorganic Chemistry-III</KCYWMC>\n" +
                "\t\t<BS>1</BS>\n" +
                "\t\t<XM>20041096/胡剑青</XM>\n" +
                "\t\t<JXBID>A944825BBEF264A1E05398C226CAA545</JXBID>\n" +
                "\t\t<ZS>2,3,4,5,6,7,8,9,10,11,12,13</ZS>\n" +
                "\t</Entry>\n" +
                "\t<Entry>\n" +
                "\t\t<tb_id>6</tb_id>\n" +
                "\t\t<XN>2020-2021</XN>\n" +
                "\t\t<XQ>1</XQ>\n" +
                "\t\t<BH>D3-d325</BH>\n" +
                "\t\t<MC>D3-d325</MC>\n" +
                "\t\t<XIAOQ>广州国际校区</XIAOQ>\n" +
                "\t\t<ZWS>108</ZWS>\n" +
                "\t\t<KSZWS>54</KSZWS>\n" +
                "\t\t<XQJ>3</XQJ>\n" +
                "\t\t<ZC>2-7周</ZC>\n" +
                "\t\t<JC>1-2</JC>\n" +
                "\t\t<KCMC>思想道德修养与法律基础</KCMC>\n" +
                "\t\t<KCYWMC>Ideological &amp;amp; Moral Cultivation and Introduction to Law</KCYWMC>\n" +
                "\t\t<BS>1</BS>\n" +
                "\t\t<XM>20051112/赖怡芳</XM>\n" +
                "\t\t<JXBID>A7A068E75CC4CCAAE05398C226CAF568</JXBID>\n" +
                "\t\t<ZS>2,3,4,5,6,7</ZS>\n" +
                "\t</Entry>\n" +
                "</Entries>";
        String resultString = XmlTojson(sourceString, "xml");
        System.out.println(resultString);
    }


    public static String XmlTojson(String xml, String resType) {
        if ("xml".equals(resType)) {
            try{
                Document doc= DocumentHelper.parseText(xml);
                JSONObject json=new JSONObject();
                dom4j2Json(doc.getRootElement(), json);
                return json.toJSONString();
            } catch (DocumentException e) {
                e.printStackTrace();
                return null;
            }
        }
        else if ("json".equals(resType)) {
            return xml;
        }
        return xml;
    }
}