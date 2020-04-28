package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepPublicProductManagementClient;
import com.ctg.ag.sdk.biz.aep_public_product_management.QueryPublicByProductIdRequest;
import com.ctg.ag.sdk.biz.aep_public_product_management.QueryPublicByProductIdResponse;
import com.ctg.ag.sdk.biz.aep_public_product_management.QueryPublicByPublicProductIdRequest;
import com.ctg.ag.sdk.biz.aep_public_product_management.QueryPublicByPublicProductIdResponse;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepPublicProductManagementDemo {

	@Test
	public void testApi() throws Exception {

		AepPublicProductManagementClient client = AepPublicProductManagementClient.newClient().build();

		{
			QueryPublicByPublicProductIdRequest request = new QueryPublicByPublicProductIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryPublicByPublicProductId(request));
		}
		
		{
			QueryPublicByProductIdRequest request = new QueryPublicByProductIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryPublicByProductId(request));
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		AepPublicProductManagementClient client = AepPublicProductManagementClient.newClient().build();

		{
			
			List<Future<QueryPublicByPublicProductIdResponse>> res = new ArrayList<Future<QueryPublicByPublicProductIdResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryPublicByPublicProductIdRequest request = new QueryPublicByPublicProductIdRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryPublicByPublicProductId(request, new ApiCallBack<QueryPublicByPublicProductIdRequest, QueryPublicByPublicProductIdResponse>() {
					@Override
					public void onFailure(QueryPublicByPublicProductIdRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryPublicByPublicProductIdRequest request, QueryPublicByPublicProductIdResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryPublicByPublicProductIdResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<QueryPublicByProductIdResponse>> res = new ArrayList<Future<QueryPublicByProductIdResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryPublicByProductIdRequest request = new QueryPublicByProductIdRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryPublicByProductId(request, new ApiCallBack<QueryPublicByProductIdRequest, QueryPublicByProductIdResponse>() {
					@Override
					public void onFailure(QueryPublicByProductIdRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryPublicByProductIdRequest request, QueryPublicByProductIdResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryPublicByProductIdResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepPublicProductManagementClient client = AepPublicProductManagementClient.newClient().scheme(Scheme.HTTPS).build();

		{
			QueryPublicByPublicProductIdRequest request = new QueryPublicByPublicProductIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryPublicByPublicProductId(request));
		}
		
		{
			QueryPublicByProductIdRequest request = new QueryPublicByProductIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryPublicByProductId(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepPublicProductManagementClient client = AepPublicProductManagementClient.newClient().sandbox(true).build();

		{
			QueryPublicByPublicProductIdRequest request = new QueryPublicByPublicProductIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryPublicByPublicProductId(request));
		}
		
		{
			QueryPublicByProductIdRequest request = new QueryPublicByProductIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryPublicByProductId(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepPublicProductManagementClient client = AepPublicProductManagementClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			QueryPublicByPublicProductIdRequest request = new QueryPublicByPublicProductIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryPublicByPublicProductId(request));
		}
		
		{
			QueryPublicByProductIdRequest request = new QueryPublicByProductIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryPublicByProductId(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepPublicProductManagementClient client = AepPublicProductManagementClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			QueryPublicByPublicProductIdRequest request = new QueryPublicByPublicProductIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryPublicByPublicProductId(request));
		}
		
		{
			QueryPublicByProductIdRequest request = new QueryPublicByProductIdRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryPublicByProductId(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepPublicProductManagementClient client = AepPublicProductManagementClient.newClient().build();

		{
			QueryPublicByPublicProductIdRequest request = new QueryPublicByPublicProductIdRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryPublicByPublicProductId(request));
		}
		
		{
			QueryPublicByProductIdRequest request = new QueryPublicByProductIdRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryPublicByProductId(request));
		}
		
		client.shutdown();
	}

}
