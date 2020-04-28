package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepProductClient;
import com.ctg.ag.sdk.biz.aep_product.ProductGetInfoRequest;
import com.ctg.ag.sdk.biz.aep_product.ProductGetInfoResponse;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepProductDemo {

	@Test
	public void testApi() throws Exception {

		AepProductClient client = AepProductClient.newClient().build();

		{
			ProductGetInfoRequest request = new ProductGetInfoRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ProductGetInfo(request));
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		AepProductClient client = AepProductClient.newClient().build();

		{
			
			List<Future<ProductGetInfoResponse>> res = new ArrayList<Future<ProductGetInfoResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				ProductGetInfoRequest request = new ProductGetInfoRequest();
				// request.setParam..  	// set your request params here

				res.add(client.ProductGetInfo(request, new ApiCallBack<ProductGetInfoRequest, ProductGetInfoResponse>() {
					@Override
					public void onFailure(ProductGetInfoRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(ProductGetInfoRequest request, ProductGetInfoResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<ProductGetInfoResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepProductClient client = AepProductClient.newClient().scheme(Scheme.HTTPS).build();

		{
			ProductGetInfoRequest request = new ProductGetInfoRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ProductGetInfo(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepProductClient client = AepProductClient.newClient().sandbox(true).build();

		{
			ProductGetInfoRequest request = new ProductGetInfoRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ProductGetInfo(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepProductClient client = AepProductClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			ProductGetInfoRequest request = new ProductGetInfoRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ProductGetInfo(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepProductClient client = AepProductClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			ProductGetInfoRequest request = new ProductGetInfoRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.ProductGetInfo(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepProductClient client = AepProductClient.newClient().build();

		{
			ProductGetInfoRequest request = new ProductGetInfoRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.ProductGetInfo(request));
		}
		
		client.shutdown();
	}

}
