package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepGatewayPositionClient;
import com.ctg.ag.sdk.biz.aep_gateway_position.GetPositionRequest;
import com.ctg.ag.sdk.biz.aep_gateway_position.GetPositionResponse;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepGatewayPositionDemo {

	@Test
	public void testApi() throws Exception {

		AepGatewayPositionClient client = AepGatewayPositionClient.newClient().build();

		{
			GetPositionRequest request = new GetPositionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.getPosition(request));
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		AepGatewayPositionClient client = AepGatewayPositionClient.newClient().build();

		{
			
			List<Future<GetPositionResponse>> res = new ArrayList<Future<GetPositionResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				GetPositionRequest request = new GetPositionRequest();
				// request.setParam..  	// set your request params here

				res.add(client.getPosition(request, new ApiCallBack<GetPositionRequest, GetPositionResponse>() {
					@Override
					public void onFailure(GetPositionRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(GetPositionRequest request, GetPositionResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<GetPositionResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepGatewayPositionClient client = AepGatewayPositionClient.newClient().scheme(Scheme.HTTPS).build();

		{
			GetPositionRequest request = new GetPositionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.getPosition(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepGatewayPositionClient client = AepGatewayPositionClient.newClient().sandbox(true).build();

		{
			GetPositionRequest request = new GetPositionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.getPosition(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepGatewayPositionClient client = AepGatewayPositionClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			GetPositionRequest request = new GetPositionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.getPosition(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepGatewayPositionClient client = AepGatewayPositionClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			GetPositionRequest request = new GetPositionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.getPosition(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepGatewayPositionClient client = AepGatewayPositionClient.newClient().build();

		{
			GetPositionRequest request = new GetPositionRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.getPosition(request));
		}
		
		client.shutdown();
	}

}
