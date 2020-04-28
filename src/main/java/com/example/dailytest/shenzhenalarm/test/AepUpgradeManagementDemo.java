package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepUpgradeManagementClient;
import com.ctg.ag.sdk.biz.aep_upgrade_management.*;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepUpgradeManagementDemo {

	@Test
	public void testApi() throws Exception {

		AepUpgradeManagementClient client = AepUpgradeManagementClient.newClient().build();

		{
			QueryRemoteUpgradeDetailRequest request = new QueryRemoteUpgradeDetailRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeDetail(request));
		}
		
		{
			QueryRemoteUpgradeTaskRequest request = new QueryRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeTask(request));
		}
		
		{
			ControlRemoteUpgradeTaskRequest request = new ControlRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ControlRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpradeDeviceListRequest request = new QueryRemoteUpradeDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpradeDeviceList(request));
		}
		
		{
			DeleteRemoteUpgradeTaskRequest request = new DeleteRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpgradeTaskListRequest request = new QueryRemoteUpgradeTaskListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeTaskList(request));
		}
		
		{
			ModifyRemoteUpgradeTaskRequest request = new ModifyRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ModifyRemoteUpgradeTask(request));
		}
		
		{
			CreateRemoteUpgradeTaskRequest request = new CreateRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateRemoteUpgradeTask(request));
		}
		
		{
			OperationalRemoteUpgradeTaskRequest request = new OperationalRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.OperationalRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpgradeSubtasksRequest request = new QueryRemoteUpgradeSubtasksRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeSubtasks(request));
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		AepUpgradeManagementClient client = AepUpgradeManagementClient.newClient().build();

		{
			
			List<Future<QueryRemoteUpgradeDetailResponse>> res = new ArrayList<Future<QueryRemoteUpgradeDetailResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryRemoteUpgradeDetailRequest request = new QueryRemoteUpgradeDetailRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryRemoteUpgradeDetail(request, new ApiCallBack<QueryRemoteUpgradeDetailRequest, QueryRemoteUpgradeDetailResponse>() {
					@Override
					public void onFailure(QueryRemoteUpgradeDetailRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryRemoteUpgradeDetailRequest request, QueryRemoteUpgradeDetailResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryRemoteUpgradeDetailResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<QueryRemoteUpgradeTaskResponse>> res = new ArrayList<Future<QueryRemoteUpgradeTaskResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryRemoteUpgradeTaskRequest request = new QueryRemoteUpgradeTaskRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryRemoteUpgradeTask(request, new ApiCallBack<QueryRemoteUpgradeTaskRequest, QueryRemoteUpgradeTaskResponse>() {
					@Override
					public void onFailure(QueryRemoteUpgradeTaskRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryRemoteUpgradeTaskRequest request, QueryRemoteUpgradeTaskResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryRemoteUpgradeTaskResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<ControlRemoteUpgradeTaskResponse>> res = new ArrayList<Future<ControlRemoteUpgradeTaskResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				ControlRemoteUpgradeTaskRequest request = new ControlRemoteUpgradeTaskRequest();
				// request.setParam..  	// set your request params here

				res.add(client.ControlRemoteUpgradeTask(request, new ApiCallBack<ControlRemoteUpgradeTaskRequest, ControlRemoteUpgradeTaskResponse>() {
					@Override
					public void onFailure(ControlRemoteUpgradeTaskRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(ControlRemoteUpgradeTaskRequest request, ControlRemoteUpgradeTaskResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<ControlRemoteUpgradeTaskResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<QueryRemoteUpradeDeviceListResponse>> res = new ArrayList<Future<QueryRemoteUpradeDeviceListResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryRemoteUpradeDeviceListRequest request = new QueryRemoteUpradeDeviceListRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryRemoteUpradeDeviceList(request, new ApiCallBack<QueryRemoteUpradeDeviceListRequest, QueryRemoteUpradeDeviceListResponse>() {
					@Override
					public void onFailure(QueryRemoteUpradeDeviceListRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryRemoteUpradeDeviceListRequest request, QueryRemoteUpradeDeviceListResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryRemoteUpradeDeviceListResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<DeleteRemoteUpgradeTaskResponse>> res = new ArrayList<Future<DeleteRemoteUpgradeTaskResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				DeleteRemoteUpgradeTaskRequest request = new DeleteRemoteUpgradeTaskRequest();
				// request.setParam..  	// set your request params here

				res.add(client.DeleteRemoteUpgradeTask(request, new ApiCallBack<DeleteRemoteUpgradeTaskRequest, DeleteRemoteUpgradeTaskResponse>() {
					@Override
					public void onFailure(DeleteRemoteUpgradeTaskRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(DeleteRemoteUpgradeTaskRequest request, DeleteRemoteUpgradeTaskResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<DeleteRemoteUpgradeTaskResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<QueryRemoteUpgradeTaskListResponse>> res = new ArrayList<Future<QueryRemoteUpgradeTaskListResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryRemoteUpgradeTaskListRequest request = new QueryRemoteUpgradeTaskListRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryRemoteUpgradeTaskList(request, new ApiCallBack<QueryRemoteUpgradeTaskListRequest, QueryRemoteUpgradeTaskListResponse>() {
					@Override
					public void onFailure(QueryRemoteUpgradeTaskListRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryRemoteUpgradeTaskListRequest request, QueryRemoteUpgradeTaskListResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryRemoteUpgradeTaskListResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<ModifyRemoteUpgradeTaskResponse>> res = new ArrayList<Future<ModifyRemoteUpgradeTaskResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				ModifyRemoteUpgradeTaskRequest request = new ModifyRemoteUpgradeTaskRequest();
				// request.setParam..  	// set your request params here

				res.add(client.ModifyRemoteUpgradeTask(request, new ApiCallBack<ModifyRemoteUpgradeTaskRequest, ModifyRemoteUpgradeTaskResponse>() {
					@Override
					public void onFailure(ModifyRemoteUpgradeTaskRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(ModifyRemoteUpgradeTaskRequest request, ModifyRemoteUpgradeTaskResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<ModifyRemoteUpgradeTaskResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<CreateRemoteUpgradeTaskResponse>> res = new ArrayList<Future<CreateRemoteUpgradeTaskResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				CreateRemoteUpgradeTaskRequest request = new CreateRemoteUpgradeTaskRequest();
				// request.setParam..  	// set your request params here

				res.add(client.CreateRemoteUpgradeTask(request, new ApiCallBack<CreateRemoteUpgradeTaskRequest, CreateRemoteUpgradeTaskResponse>() {
					@Override
					public void onFailure(CreateRemoteUpgradeTaskRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(CreateRemoteUpgradeTaskRequest request, CreateRemoteUpgradeTaskResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<CreateRemoteUpgradeTaskResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<OperationalRemoteUpgradeTaskResponse>> res = new ArrayList<Future<OperationalRemoteUpgradeTaskResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				OperationalRemoteUpgradeTaskRequest request = new OperationalRemoteUpgradeTaskRequest();
				// request.setParam..  	// set your request params here

				res.add(client.OperationalRemoteUpgradeTask(request, new ApiCallBack<OperationalRemoteUpgradeTaskRequest, OperationalRemoteUpgradeTaskResponse>() {
					@Override
					public void onFailure(OperationalRemoteUpgradeTaskRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(OperationalRemoteUpgradeTaskRequest request, OperationalRemoteUpgradeTaskResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<OperationalRemoteUpgradeTaskResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<QueryRemoteUpgradeSubtasksResponse>> res = new ArrayList<Future<QueryRemoteUpgradeSubtasksResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryRemoteUpgradeSubtasksRequest request = new QueryRemoteUpgradeSubtasksRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryRemoteUpgradeSubtasks(request, new ApiCallBack<QueryRemoteUpgradeSubtasksRequest, QueryRemoteUpgradeSubtasksResponse>() {
					@Override
					public void onFailure(QueryRemoteUpgradeSubtasksRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryRemoteUpgradeSubtasksRequest request, QueryRemoteUpgradeSubtasksResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryRemoteUpgradeSubtasksResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepUpgradeManagementClient client = AepUpgradeManagementClient.newClient().scheme(Scheme.HTTPS).build();

		{
			QueryRemoteUpgradeDetailRequest request = new QueryRemoteUpgradeDetailRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeDetail(request));
		}
		
		{
			QueryRemoteUpgradeTaskRequest request = new QueryRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeTask(request));
		}
		
		{
			ControlRemoteUpgradeTaskRequest request = new ControlRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ControlRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpradeDeviceListRequest request = new QueryRemoteUpradeDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpradeDeviceList(request));
		}
		
		{
			DeleteRemoteUpgradeTaskRequest request = new DeleteRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpgradeTaskListRequest request = new QueryRemoteUpgradeTaskListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeTaskList(request));
		}
		
		{
			ModifyRemoteUpgradeTaskRequest request = new ModifyRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ModifyRemoteUpgradeTask(request));
		}
		
		{
			CreateRemoteUpgradeTaskRequest request = new CreateRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateRemoteUpgradeTask(request));
		}
		
		{
			OperationalRemoteUpgradeTaskRequest request = new OperationalRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.OperationalRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpgradeSubtasksRequest request = new QueryRemoteUpgradeSubtasksRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeSubtasks(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepUpgradeManagementClient client = AepUpgradeManagementClient.newClient().sandbox(true).build();

		{
			QueryRemoteUpgradeDetailRequest request = new QueryRemoteUpgradeDetailRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeDetail(request));
		}
		
		{
			QueryRemoteUpgradeTaskRequest request = new QueryRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeTask(request));
		}
		
		{
			ControlRemoteUpgradeTaskRequest request = new ControlRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ControlRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpradeDeviceListRequest request = new QueryRemoteUpradeDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpradeDeviceList(request));
		}
		
		{
			DeleteRemoteUpgradeTaskRequest request = new DeleteRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpgradeTaskListRequest request = new QueryRemoteUpgradeTaskListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeTaskList(request));
		}
		
		{
			ModifyRemoteUpgradeTaskRequest request = new ModifyRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ModifyRemoteUpgradeTask(request));
		}
		
		{
			CreateRemoteUpgradeTaskRequest request = new CreateRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateRemoteUpgradeTask(request));
		}
		
		{
			OperationalRemoteUpgradeTaskRequest request = new OperationalRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.OperationalRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpgradeSubtasksRequest request = new QueryRemoteUpgradeSubtasksRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeSubtasks(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepUpgradeManagementClient client = AepUpgradeManagementClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			QueryRemoteUpgradeDetailRequest request = new QueryRemoteUpgradeDetailRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeDetail(request));
		}
		
		{
			QueryRemoteUpgradeTaskRequest request = new QueryRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeTask(request));
		}
		
		{
			ControlRemoteUpgradeTaskRequest request = new ControlRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ControlRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpradeDeviceListRequest request = new QueryRemoteUpradeDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpradeDeviceList(request));
		}
		
		{
			DeleteRemoteUpgradeTaskRequest request = new DeleteRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpgradeTaskListRequest request = new QueryRemoteUpgradeTaskListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeTaskList(request));
		}
		
		{
			ModifyRemoteUpgradeTaskRequest request = new ModifyRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ModifyRemoteUpgradeTask(request));
		}
		
		{
			CreateRemoteUpgradeTaskRequest request = new CreateRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateRemoteUpgradeTask(request));
		}
		
		{
			OperationalRemoteUpgradeTaskRequest request = new OperationalRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.OperationalRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpgradeSubtasksRequest request = new QueryRemoteUpgradeSubtasksRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeSubtasks(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepUpgradeManagementClient client = AepUpgradeManagementClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			QueryRemoteUpgradeDetailRequest request = new QueryRemoteUpgradeDetailRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeDetail(request));
		}
		
		{
			QueryRemoteUpgradeTaskRequest request = new QueryRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeTask(request));
		}
		
		{
			ControlRemoteUpgradeTaskRequest request = new ControlRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ControlRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpradeDeviceListRequest request = new QueryRemoteUpradeDeviceListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpradeDeviceList(request));
		}
		
		{
			DeleteRemoteUpgradeTaskRequest request = new DeleteRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpgradeTaskListRequest request = new QueryRemoteUpgradeTaskListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeTaskList(request));
		}
		
		{
			ModifyRemoteUpgradeTaskRequest request = new ModifyRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ModifyRemoteUpgradeTask(request));
		}
		
		{
			CreateRemoteUpgradeTaskRequest request = new CreateRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateRemoteUpgradeTask(request));
		}
		
		{
			OperationalRemoteUpgradeTaskRequest request = new OperationalRemoteUpgradeTaskRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.OperationalRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpgradeSubtasksRequest request = new QueryRemoteUpgradeSubtasksRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeSubtasks(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepUpgradeManagementClient client = AepUpgradeManagementClient.newClient().build();

		{
			QueryRemoteUpgradeDetailRequest request = new QueryRemoteUpgradeDetailRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeDetail(request));
		}
		
		{
			QueryRemoteUpgradeTaskRequest request = new QueryRemoteUpgradeTaskRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeTask(request));
		}
		
		{
			ControlRemoteUpgradeTaskRequest request = new ControlRemoteUpgradeTaskRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.ControlRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpradeDeviceListRequest request = new QueryRemoteUpradeDeviceListRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpradeDeviceList(request));
		}
		
		{
			DeleteRemoteUpgradeTaskRequest request = new DeleteRemoteUpgradeTaskRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpgradeTaskListRequest request = new QueryRemoteUpgradeTaskListRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeTaskList(request));
		}
		
		{
			ModifyRemoteUpgradeTaskRequest request = new ModifyRemoteUpgradeTaskRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.ModifyRemoteUpgradeTask(request));
		}
		
		{
			CreateRemoteUpgradeTaskRequest request = new CreateRemoteUpgradeTaskRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateRemoteUpgradeTask(request));
		}
		
		{
			OperationalRemoteUpgradeTaskRequest request = new OperationalRemoteUpgradeTaskRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.OperationalRemoteUpgradeTask(request));
		}
		
		{
			QueryRemoteUpgradeSubtasksRequest request = new QueryRemoteUpgradeSubtasksRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRemoteUpgradeSubtasks(request));
		}
		
		client.shutdown();
	}

}
