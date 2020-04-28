package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepDeviceEventClient;
import com.ctg.ag.sdk.biz.aep_device_event.QueryEventListRequest;
import com.ctg.ag.sdk.biz.aep_device_event.QueryEventListResponse;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepDeviceEventDemo {

	@Test
	public void testApi() throws Exception {

		AepDeviceEventClient client = AepDeviceEventClient.newClient().build();

		{
			QueryEventListRequest request = new QueryEventListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryEventList(request));
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		AepDeviceEventClient client = AepDeviceEventClient.newClient().build();

		{
			
			List<Future<QueryEventListResponse>> res = new ArrayList<Future<QueryEventListResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryEventListRequest request = new QueryEventListRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryEventList(request, new ApiCallBack<QueryEventListRequest, QueryEventListResponse>() {
					@Override
					public void onFailure(QueryEventListRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryEventListRequest request, QueryEventListResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryEventListResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepDeviceEventClient client = AepDeviceEventClient.newClient().scheme(Scheme.HTTPS).build();

		{
			QueryEventListRequest request = new QueryEventListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryEventList(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepDeviceEventClient client = AepDeviceEventClient.newClient().sandbox(true).build();

		{
			QueryEventListRequest request = new QueryEventListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryEventList(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepDeviceEventClient client = AepDeviceEventClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			QueryEventListRequest request = new QueryEventListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryEventList(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepDeviceEventClient client = AepDeviceEventClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			QueryEventListRequest request = new QueryEventListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryEventList(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepDeviceEventClient client = AepDeviceEventClient.newClient().build();

		{
			QueryEventListRequest request = new QueryEventListRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryEventList(request));
		}
		
		client.shutdown();
	}

}
