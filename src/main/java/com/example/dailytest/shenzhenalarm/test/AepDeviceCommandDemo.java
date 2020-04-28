package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepDeviceCommandClient;
import com.ctg.ag.sdk.biz.aep_device_command.*;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepDeviceCommandDemo {

	@Test
	public void testApi() throws Exception {

		AepDeviceCommandClient client = AepDeviceCommandClient.newClient().build();

		{
			CreateCommandRequest request = new CreateCommandRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateCommand(request));
		}
		
		{
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
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		AepDeviceCommandClient client = AepDeviceCommandClient.newClient().build();

		{
			
			List<Future<CreateCommandResponse>> res = new ArrayList<Future<CreateCommandResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				CreateCommandRequest request = new CreateCommandRequest();
				// request.setParam..  	// set your request params here

				res.add(client.CreateCommand(request, new ApiCallBack<CreateCommandRequest, CreateCommandResponse>() {
					@Override
					public void onFailure(CreateCommandRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(CreateCommandRequest request, CreateCommandResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<CreateCommandResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<QueryCommandListResponse>> res = new ArrayList<Future<QueryCommandListResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryCommandListRequest request = new QueryCommandListRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryCommandList(request, new ApiCallBack<QueryCommandListRequest, QueryCommandListResponse>() {
					@Override
					public void onFailure(QueryCommandListRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryCommandListRequest request, QueryCommandListResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryCommandListResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<QueryCommandResponse>> res = new ArrayList<Future<QueryCommandResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryCommandRequest request = new QueryCommandRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryCommand(request, new ApiCallBack<QueryCommandRequest, QueryCommandResponse>() {
					@Override
					public void onFailure(QueryCommandRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryCommandRequest request, QueryCommandResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryCommandResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<CancelCommandResponse>> res = new ArrayList<Future<CancelCommandResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				CancelCommandRequest request = new CancelCommandRequest();
				// request.setParam..  	// set your request params here

				res.add(client.CancelCommand(request, new ApiCallBack<CancelCommandRequest, CancelCommandResponse>() {
					@Override
					public void onFailure(CancelCommandRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(CancelCommandRequest request, CancelCommandResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<CancelCommandResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepDeviceCommandClient client = AepDeviceCommandClient.newClient().scheme(Scheme.HTTPS).build();

		{
			CreateCommandRequest request = new CreateCommandRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateCommand(request));
		}
		
		{
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
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepDeviceCommandClient client = AepDeviceCommandClient.newClient().sandbox(true).build();

		{
			CreateCommandRequest request = new CreateCommandRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateCommand(request));
		}
		
		{
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
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepDeviceCommandClient client = AepDeviceCommandClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			CreateCommandRequest request = new CreateCommandRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateCommand(request));
		}
		
		{
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
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepDeviceCommandClient client = AepDeviceCommandClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			CreateCommandRequest request = new CreateCommandRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateCommand(request));
		}
		
		{
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
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepDeviceCommandClient client = AepDeviceCommandClient.newClient().build();

		{
			CreateCommandRequest request = new CreateCommandRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateCommand(request));
		}
		
		{
			QueryCommandListRequest request = new QueryCommandListRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryCommandList(request));
		}
		
		{
			QueryCommandRequest request = new QueryCommandRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryCommand(request));
		}
		
		{
			CancelCommandRequest request = new CancelCommandRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.CancelCommand(request));
		}
		
		client.shutdown();
	}

}
