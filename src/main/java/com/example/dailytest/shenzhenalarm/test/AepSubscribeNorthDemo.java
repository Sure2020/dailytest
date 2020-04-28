package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepSubscribeNorthClient;
import com.ctg.ag.sdk.biz.aep_subscribe_north.*;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepSubscribeNorthDemo {

	@Test
	public void testApi() throws Exception {

		AepSubscribeNorthClient client = AepSubscribeNorthClient.newClient().build();

		{
			GetSubscriptionRequest request = new GetSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetSubscription(request));
		}
		
		{
			GetSubscriptionsListRequest request = new GetSubscriptionsListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetSubscriptionsList(request));
		}
		
		{
			DeleteSubscriptionRequest request = new DeleteSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteSubscription(request));
		}
		
		{
			CreateSubscriptionRequest request = new CreateSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateSubscription(request));
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		AepSubscribeNorthClient client = AepSubscribeNorthClient.newClient().build();

		{
			
			List<Future<GetSubscriptionResponse>> res = new ArrayList<Future<GetSubscriptionResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				GetSubscriptionRequest request = new GetSubscriptionRequest();
				// request.setParam..  	// set your request params here

				res.add(client.GetSubscription(request, new ApiCallBack<GetSubscriptionRequest, GetSubscriptionResponse>() {
					@Override
					public void onFailure(GetSubscriptionRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(GetSubscriptionRequest request, GetSubscriptionResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<GetSubscriptionResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<GetSubscriptionsListResponse>> res = new ArrayList<Future<GetSubscriptionsListResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				GetSubscriptionsListRequest request = new GetSubscriptionsListRequest();
				// request.setParam..  	// set your request params here

				res.add(client.GetSubscriptionsList(request, new ApiCallBack<GetSubscriptionsListRequest, GetSubscriptionsListResponse>() {
					@Override
					public void onFailure(GetSubscriptionsListRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(GetSubscriptionsListRequest request, GetSubscriptionsListResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<GetSubscriptionsListResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<DeleteSubscriptionResponse>> res = new ArrayList<Future<DeleteSubscriptionResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				DeleteSubscriptionRequest request = new DeleteSubscriptionRequest();
				// request.setParam..  	// set your request params here

				res.add(client.DeleteSubscription(request, new ApiCallBack<DeleteSubscriptionRequest, DeleteSubscriptionResponse>() {
					@Override
					public void onFailure(DeleteSubscriptionRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(DeleteSubscriptionRequest request, DeleteSubscriptionResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<DeleteSubscriptionResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<CreateSubscriptionResponse>> res = new ArrayList<Future<CreateSubscriptionResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				CreateSubscriptionRequest request = new CreateSubscriptionRequest();
				// request.setParam..  	// set your request params here

				res.add(client.CreateSubscription(request, new ApiCallBack<CreateSubscriptionRequest, CreateSubscriptionResponse>() {
					@Override
					public void onFailure(CreateSubscriptionRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(CreateSubscriptionRequest request, CreateSubscriptionResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<CreateSubscriptionResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepSubscribeNorthClient client = AepSubscribeNorthClient.newClient().scheme(Scheme.HTTPS).build();

		{
			GetSubscriptionRequest request = new GetSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetSubscription(request));
		}
		
		{
			GetSubscriptionsListRequest request = new GetSubscriptionsListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetSubscriptionsList(request));
		}
		
		{
			DeleteSubscriptionRequest request = new DeleteSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteSubscription(request));
		}
		
		{
			CreateSubscriptionRequest request = new CreateSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateSubscription(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepSubscribeNorthClient client = AepSubscribeNorthClient.newClient().sandbox(true).build();

		{
			GetSubscriptionRequest request = new GetSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetSubscription(request));
		}
		
		{
			GetSubscriptionsListRequest request = new GetSubscriptionsListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetSubscriptionsList(request));
		}
		
		{
			DeleteSubscriptionRequest request = new DeleteSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteSubscription(request));
		}
		
		{
			CreateSubscriptionRequest request = new CreateSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateSubscription(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepSubscribeNorthClient client = AepSubscribeNorthClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			GetSubscriptionRequest request = new GetSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetSubscription(request));
		}
		
		{
			GetSubscriptionsListRequest request = new GetSubscriptionsListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetSubscriptionsList(request));
		}
		
		{
			DeleteSubscriptionRequest request = new DeleteSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteSubscription(request));
		}
		
		{
			CreateSubscriptionRequest request = new CreateSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateSubscription(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepSubscribeNorthClient client = AepSubscribeNorthClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			GetSubscriptionRequest request = new GetSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetSubscription(request));
		}
		
		{
			GetSubscriptionsListRequest request = new GetSubscriptionsListRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.GetSubscriptionsList(request));
		}
		
		{
			DeleteSubscriptionRequest request = new DeleteSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteSubscription(request));
		}
		
		{
			CreateSubscriptionRequest request = new CreateSubscriptionRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateSubscription(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepSubscribeNorthClient client = AepSubscribeNorthClient.newClient().build();

		{
			GetSubscriptionRequest request = new GetSubscriptionRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.GetSubscription(request));
		}
		
		{
			GetSubscriptionsListRequest request = new GetSubscriptionsListRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.GetSubscriptionsList(request));
		}
		
		{
			DeleteSubscriptionRequest request = new DeleteSubscriptionRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.DeleteSubscription(request));
		}
		
		{
			CreateSubscriptionRequest request = new CreateSubscriptionRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.CreateSubscription(request));
		}
		
		client.shutdown();
	}

}
