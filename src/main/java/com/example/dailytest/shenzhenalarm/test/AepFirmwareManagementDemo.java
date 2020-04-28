package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepFirmwareManagementClient;
import com.ctg.ag.sdk.biz.aep_firmware_management.*;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepFirmwareManagementDemo {

	@Test
	public void testApi() throws Exception {

		AepFirmwareManagementClient client = AepFirmwareManagementClient.newClient().build();

		{
			UpdateFirmwareRequest request = new UpdateFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateFirmware(request));
		}
		
		{
			QueryFirmwareListRequest request = new QueryFirmwareListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryFirmwareList(request));
		}
		
		{
			QueryFirmwareRequest request = new QueryFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryFirmware(request));
		}
		
		{
			DeleteFirmwareRequest request = new DeleteFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteFirmware(request));
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		AepFirmwareManagementClient client = AepFirmwareManagementClient.newClient().build();

		{
			
			List<Future<UpdateFirmwareResponse>> res = new ArrayList<Future<UpdateFirmwareResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				UpdateFirmwareRequest request = new UpdateFirmwareRequest();
				// request.setParam..  	// set your request params here

				res.add(client.UpdateFirmware(request, new ApiCallBack<UpdateFirmwareRequest, UpdateFirmwareResponse>() {
					@Override
					public void onFailure(UpdateFirmwareRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(UpdateFirmwareRequest request, UpdateFirmwareResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<UpdateFirmwareResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<QueryFirmwareListResponse>> res = new ArrayList<Future<QueryFirmwareListResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryFirmwareListRequest request = new QueryFirmwareListRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryFirmwareList(request, new ApiCallBack<QueryFirmwareListRequest, QueryFirmwareListResponse>() {
					@Override
					public void onFailure(QueryFirmwareListRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryFirmwareListRequest request, QueryFirmwareListResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryFirmwareListResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<QueryFirmwareResponse>> res = new ArrayList<Future<QueryFirmwareResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryFirmwareRequest request = new QueryFirmwareRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryFirmware(request, new ApiCallBack<QueryFirmwareRequest, QueryFirmwareResponse>() {
					@Override
					public void onFailure(QueryFirmwareRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryFirmwareRequest request, QueryFirmwareResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryFirmwareResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<DeleteFirmwareResponse>> res = new ArrayList<Future<DeleteFirmwareResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				DeleteFirmwareRequest request = new DeleteFirmwareRequest();
				// request.setParam..  	// set your request params here

				res.add(client.DeleteFirmware(request, new ApiCallBack<DeleteFirmwareRequest, DeleteFirmwareResponse>() {
					@Override
					public void onFailure(DeleteFirmwareRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(DeleteFirmwareRequest request, DeleteFirmwareResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<DeleteFirmwareResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepFirmwareManagementClient client = AepFirmwareManagementClient.newClient().scheme(Scheme.HTTPS).build();

		{
			UpdateFirmwareRequest request = new UpdateFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateFirmware(request));
		}
		
		{
			QueryFirmwareListRequest request = new QueryFirmwareListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryFirmwareList(request));
		}
		
		{
			QueryFirmwareRequest request = new QueryFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryFirmware(request));
		}
		
		{
			DeleteFirmwareRequest request = new DeleteFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteFirmware(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepFirmwareManagementClient client = AepFirmwareManagementClient.newClient().sandbox(true).build();

		{
			UpdateFirmwareRequest request = new UpdateFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateFirmware(request));
		}
		
		{
			QueryFirmwareListRequest request = new QueryFirmwareListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryFirmwareList(request));
		}
		
		{
			QueryFirmwareRequest request = new QueryFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryFirmware(request));
		}
		
		{
			DeleteFirmwareRequest request = new DeleteFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteFirmware(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepFirmwareManagementClient client = AepFirmwareManagementClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			UpdateFirmwareRequest request = new UpdateFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateFirmware(request));
		}
		
		{
			QueryFirmwareListRequest request = new QueryFirmwareListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryFirmwareList(request));
		}
		
		{
			QueryFirmwareRequest request = new QueryFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryFirmware(request));
		}
		
		{
			DeleteFirmwareRequest request = new DeleteFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteFirmware(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepFirmwareManagementClient client = AepFirmwareManagementClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			UpdateFirmwareRequest request = new UpdateFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateFirmware(request));
		}
		
		{
			QueryFirmwareListRequest request = new QueryFirmwareListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryFirmwareList(request));
		}
		
		{
			QueryFirmwareRequest request = new QueryFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryFirmware(request));
		}
		
		{
			DeleteFirmwareRequest request = new DeleteFirmwareRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteFirmware(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepFirmwareManagementClient client = AepFirmwareManagementClient.newClient().build();

		{
			UpdateFirmwareRequest request = new UpdateFirmwareRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateFirmware(request));
		}
		
		{
			QueryFirmwareListRequest request = new QueryFirmwareListRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryFirmwareList(request));
		}
		
		{
			QueryFirmwareRequest request = new QueryFirmwareRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryFirmware(request));
		}
		
		{
			DeleteFirmwareRequest request = new DeleteFirmwareRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteFirmware(request));
		}
		
		client.shutdown();
	}

}
