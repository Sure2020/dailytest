package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepModbusDeviceManagementClient;
import com.ctg.ag.sdk.biz.aep_modbus_device_management.*;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepModbusDeviceManagementDemo {

	@Test
	public void testApi() throws Exception {

		AepModbusDeviceManagementClient client = AepModbusDeviceManagementClient.newClient().build();

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
			QueryDeviceRequest request = new QueryDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDevice(request));
		}
		
		{
			QueryDeviceListRequest request = new QueryDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDeviceList(request));
		}
		
		{
			DeleteDeviceRequest request = new DeleteDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteDevice(request));
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		AepModbusDeviceManagementClient client = AepModbusDeviceManagementClient.newClient().build();

		{
			
			List<Future<UpdateDeviceResponse>> res = new ArrayList<Future<UpdateDeviceResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				UpdateDeviceRequest request = new UpdateDeviceRequest();
				// request.setParam..  	// set your request params here

				res.add(client.UpdateDevice(request, new ApiCallBack<UpdateDeviceRequest, UpdateDeviceResponse>() {
					@Override
					public void onFailure(UpdateDeviceRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(UpdateDeviceRequest request, UpdateDeviceResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<UpdateDeviceResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<CreateDeviceResponse>> res = new ArrayList<Future<CreateDeviceResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				CreateDeviceRequest request = new CreateDeviceRequest();
				// request.setParam..  	// set your request params here

				res.add(client.CreateDevice(request, new ApiCallBack<CreateDeviceRequest, CreateDeviceResponse>() {
					@Override
					public void onFailure(CreateDeviceRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(CreateDeviceRequest request, CreateDeviceResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<CreateDeviceResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<QueryDeviceResponse>> res = new ArrayList<Future<QueryDeviceResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryDeviceRequest request = new QueryDeviceRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryDevice(request, new ApiCallBack<QueryDeviceRequest, QueryDeviceResponse>() {
					@Override
					public void onFailure(QueryDeviceRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryDeviceRequest request, QueryDeviceResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryDeviceResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<QueryDeviceListResponse>> res = new ArrayList<Future<QueryDeviceListResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryDeviceListRequest request = new QueryDeviceListRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryDeviceList(request, new ApiCallBack<QueryDeviceListRequest, QueryDeviceListResponse>() {
					@Override
					public void onFailure(QueryDeviceListRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryDeviceListRequest request, QueryDeviceListResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryDeviceListResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<DeleteDeviceResponse>> res = new ArrayList<Future<DeleteDeviceResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				DeleteDeviceRequest request = new DeleteDeviceRequest();
				// request.setParam..  	// set your request params here

				res.add(client.DeleteDevice(request, new ApiCallBack<DeleteDeviceRequest, DeleteDeviceResponse>() {
					@Override
					public void onFailure(DeleteDeviceRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(DeleteDeviceRequest request, DeleteDeviceResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<DeleteDeviceResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepModbusDeviceManagementClient client = AepModbusDeviceManagementClient.newClient().scheme(Scheme.HTTPS).build();

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
			QueryDeviceRequest request = new QueryDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDevice(request));
		}
		
		{
			QueryDeviceListRequest request = new QueryDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDeviceList(request));
		}
		
		{
			DeleteDeviceRequest request = new DeleteDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteDevice(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepModbusDeviceManagementClient client = AepModbusDeviceManagementClient.newClient().sandbox(true).build();

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
			QueryDeviceRequest request = new QueryDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDevice(request));
		}
		
		{
			QueryDeviceListRequest request = new QueryDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDeviceList(request));
		}
		
		{
			DeleteDeviceRequest request = new DeleteDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteDevice(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepModbusDeviceManagementClient client = AepModbusDeviceManagementClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

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
			QueryDeviceRequest request = new QueryDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDevice(request));
		}
		
		{
			QueryDeviceListRequest request = new QueryDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDeviceList(request));
		}
		
		{
			DeleteDeviceRequest request = new DeleteDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteDevice(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepModbusDeviceManagementClient client = AepModbusDeviceManagementClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

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
			QueryDeviceRequest request = new QueryDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDevice(request));
		}
		
		{
			QueryDeviceListRequest request = new QueryDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDeviceList(request));
		}
		
		{
			DeleteDeviceRequest request = new DeleteDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteDevice(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepModbusDeviceManagementClient client = AepModbusDeviceManagementClient.newClient().build();

		{
			UpdateDeviceRequest request = new UpdateDeviceRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.UpdateDevice(request));
		}
		
		{
			CreateDeviceRequest request = new CreateDeviceRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateDevice(request));
		}
		
		{
			QueryDeviceRequest request = new QueryDeviceRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDevice(request));
		}
		
		{
			QueryDeviceListRequest request = new QueryDeviceListRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDeviceList(request));
		}
		
		{
			DeleteDeviceRequest request = new DeleteDeviceRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteDevice(request));
		}
		
		client.shutdown();
	}

}
