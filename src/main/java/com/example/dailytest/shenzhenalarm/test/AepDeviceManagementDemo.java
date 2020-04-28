package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepDeviceManagementClient;
import com.ctg.ag.sdk.biz.aep_device_management.*;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepDeviceManagementDemo {

	@Test
	public void testApi() throws Exception {

		//AepDeviceManagementClient client = AepDeviceManagementClient.newClient().build();
		AepDeviceManagementClient client = AepDeviceManagementClient.newClient().appKey("eke3uNOLPfd").appSecret("wq0xibKkv1 ").build();

		{
			QueryDeviceListRequest request = new QueryDeviceListRequest();
			// request.setParam..  	// set your request params here
			request.setParamMasterKey("4dd773bb798b4c39857b10b8d84c787e");
			request.setParamProductId("10035159");
			System.out.println("#############################");
			System.out.println(client.QueryDeviceList(request));
			System.out.println("#############################");
		}
		
		/*{
			QueryDeviceRequest request = new QueryDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDevice(request));
		}
		
		{
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

	@Test
	public void testApiAsync() throws Exception {

		AepDeviceManagementClient client = AepDeviceManagementClient.newClient().build();

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
			
			List<Future<BindDeviceResponse>> res = new ArrayList<Future<BindDeviceResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				BindDeviceRequest request = new BindDeviceRequest();
				// request.setParam..  	// set your request params here

				res.add(client.BindDevice(request, new ApiCallBack<BindDeviceRequest, BindDeviceResponse>() {
					@Override
					public void onFailure(BindDeviceRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(BindDeviceRequest request, BindDeviceResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<BindDeviceResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<UnbindDeviceResponse>> res = new ArrayList<Future<UnbindDeviceResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				UnbindDeviceRequest request = new UnbindDeviceRequest();
				// request.setParam..  	// set your request params here

				res.add(client.UnbindDevice(request, new ApiCallBack<UnbindDeviceRequest, UnbindDeviceResponse>() {
					@Override
					public void onFailure(UnbindDeviceRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(UnbindDeviceRequest request, UnbindDeviceResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<UnbindDeviceResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<QueryProductInfoByImeiResponse>> res = new ArrayList<Future<QueryProductInfoByImeiResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryProductInfoByImeiRequest request = new QueryProductInfoByImeiRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryProductInfoByImei(request, new ApiCallBack<QueryProductInfoByImeiRequest, QueryProductInfoByImeiResponse>() {
					@Override
					public void onFailure(QueryProductInfoByImeiRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryProductInfoByImeiRequest request, QueryProductInfoByImeiResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryProductInfoByImeiResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepDeviceManagementClient client = AepDeviceManagementClient.newClient().scheme(Scheme.HTTPS).build();

		{
			QueryDeviceListRequest request = new QueryDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDeviceList(request));
		}
		
		{
			QueryDeviceRequest request = new QueryDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDevice(request));
		}
		
		{
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
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepDeviceManagementClient client = AepDeviceManagementClient.newClient().sandbox(true).build();

		{
			QueryDeviceListRequest request = new QueryDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDeviceList(request));
		}
		
		{
			QueryDeviceRequest request = new QueryDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDevice(request));
		}
		
		{
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
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepDeviceManagementClient client = AepDeviceManagementClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			QueryDeviceListRequest request = new QueryDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDeviceList(request));
		}
		
		{
			QueryDeviceRequest request = new QueryDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDevice(request));
		}
		
		{
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
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepDeviceManagementClient client = AepDeviceManagementClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			QueryDeviceListRequest request = new QueryDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDeviceList(request));
		}
		
		{
			QueryDeviceRequest request = new QueryDeviceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDevice(request));
		}
		
		{
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
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepDeviceManagementClient client = AepDeviceManagementClient.newClient().build();

		{
			QueryDeviceListRequest request = new QueryDeviceListRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDeviceList(request));
		}
		
		{
			QueryDeviceRequest request = new QueryDeviceRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryDevice(request));
		}
		
		{
			DeleteDeviceRequest request = new DeleteDeviceRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteDevice(request));
		}
		
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
			BindDeviceRequest request = new BindDeviceRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.BindDevice(request));
		}
		
		{
			UnbindDeviceRequest request = new UnbindDeviceRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.UnbindDevice(request));
		}
		
		{
			QueryProductInfoByImeiRequest request = new QueryProductInfoByImeiRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryProductInfoByImei(request));
		}
		
		client.shutdown();
	}

}
