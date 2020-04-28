package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepRuleClient;
import com.ctg.ag.sdk.biz.aep_rule.*;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepRuleDemo {

	@Test
	public void testApi() throws Exception {

		AepRuleClient client = AepRuleClient.newClient().build();

		{
			QueryRuleByRuleIdRequest request = new QueryRuleByRuleIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRuleByRuleId(request));
		}
		
		{
			SaasUpdateRuleRequest request = new SaasUpdateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasUpdateRule(request));
		}
		
		{
			SaasDeleteRuleEngineRequest request = new SaasDeleteRuleEngineRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasDeleteRuleEngine(request));
		}
		
		{
			SaasQueryRuleRequest request = new SaasQueryRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasQueryRule(request));
		}
		
		{
			SaasCreateRuleRequest request = new SaasCreateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasCreateRule(request));
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		AepRuleClient client = AepRuleClient.newClient().build();

		{
			
			List<Future<QueryRuleByRuleIdResponse>> res = new ArrayList<Future<QueryRuleByRuleIdResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryRuleByRuleIdRequest request = new QueryRuleByRuleIdRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryRuleByRuleId(request, new ApiCallBack<QueryRuleByRuleIdRequest, QueryRuleByRuleIdResponse>() {
					@Override
					public void onFailure(QueryRuleByRuleIdRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryRuleByRuleIdRequest request, QueryRuleByRuleIdResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryRuleByRuleIdResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<SaasUpdateRuleResponse>> res = new ArrayList<Future<SaasUpdateRuleResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				SaasUpdateRuleRequest request = new SaasUpdateRuleRequest();
				// request.setParam..  	// set your request params here

				res.add(client.saasUpdateRule(request, new ApiCallBack<SaasUpdateRuleRequest, SaasUpdateRuleResponse>() {
					@Override
					public void onFailure(SaasUpdateRuleRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(SaasUpdateRuleRequest request, SaasUpdateRuleResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<SaasUpdateRuleResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<SaasDeleteRuleEngineResponse>> res = new ArrayList<Future<SaasDeleteRuleEngineResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				SaasDeleteRuleEngineRequest request = new SaasDeleteRuleEngineRequest();
				// request.setParam..  	// set your request params here

				res.add(client.saasDeleteRuleEngine(request, new ApiCallBack<SaasDeleteRuleEngineRequest, SaasDeleteRuleEngineResponse>() {
					@Override
					public void onFailure(SaasDeleteRuleEngineRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(SaasDeleteRuleEngineRequest request, SaasDeleteRuleEngineResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<SaasDeleteRuleEngineResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<SaasQueryRuleResponse>> res = new ArrayList<Future<SaasQueryRuleResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				SaasQueryRuleRequest request = new SaasQueryRuleRequest();
				// request.setParam..  	// set your request params here

				res.add(client.saasQueryRule(request, new ApiCallBack<SaasQueryRuleRequest, SaasQueryRuleResponse>() {
					@Override
					public void onFailure(SaasQueryRuleRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(SaasQueryRuleRequest request, SaasQueryRuleResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<SaasQueryRuleResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<SaasCreateRuleResponse>> res = new ArrayList<Future<SaasCreateRuleResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				SaasCreateRuleRequest request = new SaasCreateRuleRequest();
				// request.setParam..  	// set your request params here

				res.add(client.saasCreateRule(request, new ApiCallBack<SaasCreateRuleRequest, SaasCreateRuleResponse>() {
					@Override
					public void onFailure(SaasCreateRuleRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(SaasCreateRuleRequest request, SaasCreateRuleResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<SaasCreateRuleResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepRuleClient client = AepRuleClient.newClient().scheme(Scheme.HTTPS).build();

		{
			QueryRuleByRuleIdRequest request = new QueryRuleByRuleIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRuleByRuleId(request));
		}
		
		{
			SaasUpdateRuleRequest request = new SaasUpdateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasUpdateRule(request));
		}
		
		{
			SaasDeleteRuleEngineRequest request = new SaasDeleteRuleEngineRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasDeleteRuleEngine(request));
		}
		
		{
			SaasQueryRuleRequest request = new SaasQueryRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasQueryRule(request));
		}
		
		{
			SaasCreateRuleRequest request = new SaasCreateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasCreateRule(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepRuleClient client = AepRuleClient.newClient().sandbox(true).build();

		{
			QueryRuleByRuleIdRequest request = new QueryRuleByRuleIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRuleByRuleId(request));
		}
		
		{
			SaasUpdateRuleRequest request = new SaasUpdateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasUpdateRule(request));
		}
		
		{
			SaasDeleteRuleEngineRequest request = new SaasDeleteRuleEngineRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasDeleteRuleEngine(request));
		}
		
		{
			SaasQueryRuleRequest request = new SaasQueryRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasQueryRule(request));
		}
		
		{
			SaasCreateRuleRequest request = new SaasCreateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasCreateRule(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepRuleClient client = AepRuleClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			QueryRuleByRuleIdRequest request = new QueryRuleByRuleIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRuleByRuleId(request));
		}
		
		{
			SaasUpdateRuleRequest request = new SaasUpdateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasUpdateRule(request));
		}
		
		{
			SaasDeleteRuleEngineRequest request = new SaasDeleteRuleEngineRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasDeleteRuleEngine(request));
		}
		
		{
			SaasQueryRuleRequest request = new SaasQueryRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasQueryRule(request));
		}
		
		{
			SaasCreateRuleRequest request = new SaasCreateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasCreateRule(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepRuleClient client = AepRuleClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			QueryRuleByRuleIdRequest request = new QueryRuleByRuleIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRuleByRuleId(request));
		}
		
		{
			SaasUpdateRuleRequest request = new SaasUpdateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasUpdateRule(request));
		}
		
		{
			SaasDeleteRuleEngineRequest request = new SaasDeleteRuleEngineRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasDeleteRuleEngine(request));
		}
		
		{
			SaasQueryRuleRequest request = new SaasQueryRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasQueryRule(request));
		}
		
		{
			SaasCreateRuleRequest request = new SaasCreateRuleRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.saasCreateRule(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepRuleClient client = AepRuleClient.newClient().build();

		{
			QueryRuleByRuleIdRequest request = new QueryRuleByRuleIdRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryRuleByRuleId(request));
		}
		
		{
			SaasUpdateRuleRequest request = new SaasUpdateRuleRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.saasUpdateRule(request));
		}
		
		{
			SaasDeleteRuleEngineRequest request = new SaasDeleteRuleEngineRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.saasDeleteRuleEngine(request));
		}
		
		{
			SaasQueryRuleRequest request = new SaasQueryRuleRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.saasQueryRule(request));
		}
		
		{
			SaasCreateRuleRequest request = new SaasCreateRuleRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.saasCreateRule(request));
		}
		
		client.shutdown();
	}

}
