/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestXmlToJson
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

import java.io.IOException;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-14
 **/
public class TestXmlToJson {
    public static void main(String[] args) {
        System.out.println("TestXmlToJson");
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<Message>\n" +
                "        <PolicyList>\n" +
                "            <PolicyDetail>\n" +
                "                <Apply>\n" +
                "                    <ApplyNo>2017121212100001</ApplyNo>\n" +
                "                    <ApplicationNo>2017121212100003</ApplicationNo>\n" +
                "                    <Status>3</Status>\n" +
                "                    <PolicyAmount>50000.00</PolicyAmount>\n" +
                "                    <Premium>5.67</Premium>\n" +
                "                </Apply>\n" +
                "                <Holder>\n" +
                "                    <Name>aaa</Name>\n" +
                "                    <CertType>1</CertType>\n" +
                "                    <CertNo>sdsd</CertNo>\n" +
                "                    <Mobile>dfdf</Mobile>\n" +
                "                </Holder>\n" +
                "                <InsuredList>\n" +
                "                    <Insured>\n" +
                "                        <Name>查</Name>\n" +
                "                        <CertType>1</CertType>\n" +
                "                        <CertNo>sdsd</CertNo>\n" +
                "                        <Mobile>dfdf</Mobile>\n" +
                "                        <Address>sdsd</Address>\n" +
                "                    </Insured>\n" +
                "                    <Insured>\n" +
                "                        <Name>哈哈</Name>\n" +
                "                        <CertType>1</CertType>\n" +
                "                        <CertNo>sdsd</CertNo>\n" +
                "                        <Mobile>dfdf</Mobile>\n" +
                "                        <Address>sdsd</Address>\n" +
                "                    </Insured>\n" +
                "                </InsuredList>\n" +
                "                <Vehicle>\n" +
                "                    <LicensePlateNo>沪A 12345</LicensePlateNo>\n" +
                "                    <LicensePlateType>02</LicensePlateType>\n" +
                "                    <MotorTypeCode>11</MotorTypeCode>\n" +
                "                    <MotorUsageTypeCode>200</MotorUsageTypeCode>\n" +
                "                </Vehicle>\n" +
                "            </PolicyDetail>\n" +
                "        </PolicyList>\n" +
                "        <Sign>W05YVZk6J6CyIqnmLjbDpvNVfKXp8NXGchPSAWZuVCR2PM6J34QRdTIHiNsYlHZWtrQcVASe48bPEZ8+VU6U3iLs1EmJdJWX0fZdaf+yeA3K966G1xY3xgJB2BNoyYt1EB27I0P7fxx+VRZdfPELm86x+ItTxrWli8xWAA+Qnn0=</Sign>\n" +
                "</Message>\n";
        try {
            //xml = FileUtils.readFileToString(new File("E:\\code\\test\\1.xml"));
            System.out.println(org.json.XML.toJSONObject(xml).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}