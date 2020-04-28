/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : DeviceTest
 * Date Created : 2020-04-23
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-04-23       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.shenzhenalarm.timestamp;

import com.alibaba.fastjson.JSONObject;
import com.ctg.ag.sdk.biz.AepDeviceCommandClient;
import com.ctg.ag.sdk.biz.AepDeviceManagementClient;
import com.ctg.ag.sdk.biz.aep_device_command.CreateCommandRequest;
import org.junit.Test;

/**
 * @program: com.example.shenzhenalarm.timestamp
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-23
 **/
public class DeviceTest {

    @Test
    public void testApiCommand() throws Exception {

        AepDeviceCommandClient client = AepDeviceCommandClient.newClient().appKey("eke3uNOLPfd").appSecret("wq0xibKkv1").build();

        {
            CreateCommandRequest request = new CreateCommandRequest();
            // request.setParam..  	// set your request params here
            request.setParamMasterKey("4dd773bb798b4c39857b10b8d84c787e");
            request.setParam("deviceId", "362b2c484dc04a65a9d99957e319ae78");
            request.setParam("operator", "joinzn");
            request.setParam("productId", 10035159);
            request.setParam("ttl", 7800);
            request.setParam("level", 2);
            /*JSONObject requestBodyObj = new JSONObject();
            requestBodyObj.put("deviceId", "362b2c484dc04a65a9d99957e319ae78");
            requestBodyObj.put("operator", "joinzn");
            requestBodyObj.put("productId", 10035159);
            requestBodyObj.put("ttl", 7800);
            requestBodyObj.put("level", 2);*/
            //request.setBody(byte[] test);
            JSONObject contentObj = new JSONObject();
            contentObj.put("CTRL_ALARM_FLG", "0");
            //request.setParam("content", contentObj);
            System.out.println("#############################");
            System.out.println(client.CreateCommand(request));
            System.out.println("#############################");
        }

        /*{
            QueryCommandListRequest request = new QueryCommandListRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryCommandList(request));
        }

        {
            QueryCommandRequest request = new QueryCommandRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryCommand(request));
        }

        {
            CancelCommandRequest request = new CancelCommandRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.CancelCommand(request));
        }*/

        client.shutdown();

    }
    /*@Test
    public void testApiCommand() throws Exception {

        AepDeviceCommandLwmProfileClient client = AepDeviceCommandLwmProfileClient.newClient().appKey("eke3uNOLPfd").appSecret("wq0xibKkv1").build();

        {
            CreateCommandLwm2mProfileRequest request = new CreateCommandLwm2mProfileRequest();
            // request.setParam..  	// set your request params here
            request.setParamMasterKey("4dd773bb798b4c39857b10b8d84c787e");
            request.setParam("deviceId", "362b2c484dc04a65a9d99957e319ae78");
            request.setParam("operator", "joinzn");
            request.setParam("productId", 10035159);
            request.setParam("ttl", 7800);
            request.setParam("level", 2);
            System.out.println("#############################");
            System.out.println(client.CreateCommandLwm2mProfile(request));
            System.out.println("#############################");
        }

        client.shutdown();

    }*/
    @Test
    public void testApi() throws Exception {

        //AepDeviceManagementClient client = AepDeviceManagementClient.newClient().build();
        AepDeviceManagementClient client = AepDeviceManagementClient.newClient().appKey("eke3uNOLPfd").appSecret("wq0xibKkv1").build();
        //MyDeviceManagementClient client = MyDeviceManagementClient.newClient().appKey("eke3uNOLPfd").appSecret("wq0xibKkv1").build();

        /*{
            QueryDeviceListRequest request = new QueryDeviceListRequest();
            // request.setParam..  	// set your request params here
            request.setParamMasterKey("4dd773bb798b4c39857b10b8d84c787e");
            request.setParamProductId("10035159");
            System.out.println("#############################");
            System.out.println(client.QueryDeviceList(request));
            System.out.println("#############################");
        }*/

/*		{
			QueryDeviceRequest request = new QueryDeviceRequest();
			// request.setParam..  	// set your request params here
            System.out.println("#############################");
            request.setParamMasterKey("4dd773bb798b4c39857b10b8d84c787e");
            request.setParamProductId("10035159");
            request.setParamDeviceId("8264717e451348beac3c01ebc64603db");
			System.out.println(client.QueryDevice(request));
            System.out.println("#############################");
		}*/

		/*{
			DeleteDeviceRequest request = new DeleteDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteDevice(request));
		}

		{
			UpdateDeviceRequest request = new UpdateDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateDevice(request));
		}

		{
			CreateDeviceRequest request = new CreateDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateDevice(request));
		}

		{
			BindDeviceRequest request = new BindDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.BindDevice(request));
		}

		{
			UnbindDeviceRequest request = new UnbindDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UnbindDevice(request));
		}

		{
			QueryProductInfoByImeiRequest request = new QueryProductInfoByImeiRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryProductInfoByImei(request));
		}*/

        client.shutdown();

    }
}