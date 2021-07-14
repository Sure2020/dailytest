/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestSms
 * Date Created : 2021-07-01
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-07-01       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.huazhongkeji;

/**
 * @program: com.example.dailytest.huazhongkeji
 * @description: xxx
 * @author: w15021
 * @create: 2021-07-01
 **/

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.xfire.client.Client;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestSms extends TestCase{

    private static ObjectMapper mapper = new ObjectMapper();
    @Test
    public  void testSendSms() {
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] {});
            //webservice地址由正式环境决定
            //org.springframework.core.io.Resource resource = appContext.getResource("url:http://ucs.hust.edu.cn/service/SmsService?wsdl");
            //org.springframework.core.io.Resource resource = appContext.getResource("url:http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl");
            org.springframework.core.io.Resource resource = appContext.getResource("url:http://192.168.56.74:2345/services/ws/api?wsdl");
            //获取时间
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            //授权处理，需要在平台端，系统管理-权限项管理中设置
            //秘钥，必须
            map.put("secret_key", getSHA("XXXXXXXXXXXXXXXX"));
            //对应的第三方系统名称（协议值），必须
            map.put("tp_name", "EnglishName");
            //对应的模块名称（协议值），必须
            map.put("module_id", "sms");
            //对应的平台系统名称（协议值），必须
            map.put("sys_id", "mp");
            //对应的接口方法名称（协议值），必须
            map.put("interface_method", "sms");

            //参数列表
            //接收人信息,每个人员信息格式为： 名字|学工号|部门ID|部门名称|电话号码，人与人之间用“^@^”隔开（如果数据无法提供，可以写空，但是“|”不可省略），必须
            map.put("person_info", "霍一|11111111|1111222338804352|XXX部门|1XXXX^@^张三|09901|11644008804352|XXXXX|18640115761");
            //短信内容，必须
            map.put("sms_info", "test again");
            //发送优先级（1：紧急通知；2：验证码；3：立即发送；4：发送），必须
            map.put("send_priority", "4");
            //发送时间，String型，可为空，参数不可省略
            map.put("send_time", sdf.format(date));
            //发送人UID，发送模板的时候不可为空，参数不可省略
            map.put("operator_id", "09901");
            //发送人ID_NUMBER，需要发送回执的时候不可为空，其他可为空，参数不可省略
            map.put("operator_id_number", "09901");
            //发送人姓名，可为空，参数不可省略
            map.put("operator_name", "杨辉");
            //发送人部门ID，不可为空，参数不可省略，有关于短信的配额问题
            map.put("operator_unit_id", "10010");
            //发送人部门姓名，可为空，参数不可省略
            map.put("operator_unit_name", "");
            //发送模板选择，不发送模板值为”0”，参数不可省略
            map.put("templet_id", "0");
            //发送回执选择，不发送模板值为”0”，参数不可省略
            map.put("receipt_id", "0");
            //发送人签名，根据模板而定，选择的模板有“发送人签名”标签的需要写值，其他为空，参数不可省略
            map.put("person_send", "杨辉");
            //发送平台码，必须
            map.put("send_sys_id", "1");
            //发送平台名称，必须
            map.put("send_sys_name", "第三方平台");
            //发送使用的浏览器，可为空，参数不可省略
            map.put("user_browser", "FireFox");
            //转化
            String json = mapper.writeValueAsString(map);

            System.out.println("json:"+json);
            //调用
            Client client = new Client(resource.getInputStream(), null);
            //输出结果 boolean型，true代表推送成功，false为失败
            //Object[] result = client.invoke("saveSmsInfo", new Object[]{json});
            //Object[] result = client.invoke("getSupportCity", new Object[]{"浙江"});
            //helloMessageServer
            Object[] result = client.invoke("emrService", new Object[]{"abc"});

            System.out.println("result[0]:" + result[0]);

            for(int i = 0; i < result.length; i++){
                System.out.println("resut[" + i + "]: " + result[i]);
            }
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static String getSHA(String password){
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA");
            sha.update(password.getBytes());
            byte[] hash = sha.digest();
            return new String(Base64.encodeBase64(hash));
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        return "";
    }

}
