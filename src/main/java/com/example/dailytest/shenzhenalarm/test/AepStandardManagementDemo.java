package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepStandardManagementClient;
import com.ctg.ag.sdk.biz.aep_standard_management.QueryStandardModelRequest;
import com.ctg.ag.sdk.biz.aep_standard_management.QueryStandardModelResponse;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepStandardManagementDemo {

	@Test
	public void testApi() throws Exception {

		AepStandardManagementClient client = AepStandardManagementClient.newClient().build();

		{
			QueryStandardModelRequest request = new QueryStandardModelRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryStandardModel(request));
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		AepStandardManagementClient client = AepStandardManagementClient.newClient().build();

		{
			
			List<Future<QueryStandardModelResponse>> res = new ArrayList<Future<QueryStandardModelResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				QueryStandardModelRequest request = new QueryStandardModelRequest();
				// request.setParam..  	// set your request params here

				res.add(client.QueryStandardModel(request, new ApiCallBack<QueryStandardModelRequest, QueryStandardModelResponse>() {
					@Override
					public void onFailure(QueryStandardModelRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(QueryStandardModelRequest request, QueryStandardModelResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<QueryStandardModelResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepStandardManagementClient client = AepStandardManagementClient.newClient().scheme(Scheme.HTTPS).build();

		{
			QueryStandardModelRequest request = new QueryStandardModelRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryStandardModel(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepStandardManagementClient client = AepStandardManagementClient.newClient().sandbox(true).build();

		{
			QueryStandardModelRequest request = new QueryStandardModelRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryStandardModel(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepStandardManagementClient client = AepStandardManagementClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			QueryStandardModelRequest request = new QueryStandardModelRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryStandardModel(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepStandardManagementClient client = AepStandardManagementClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			QueryStandardModelRequest request = new QueryStandardModelRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryStandardModel(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepStandardManagementClient client = AepStandardManagementClient.newClient().build();

		{
			QueryStandardModelRequest request = new QueryStandardModelRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.QueryStandardModel(request));
		}
		
		client.shutdown();
	}

}
