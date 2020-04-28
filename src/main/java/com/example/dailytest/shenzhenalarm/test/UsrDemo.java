package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.UsrClient;
import com.ctg.ag.sdk.biz.usr.SdkDownloadRequest;
import com.ctg.ag.sdk.biz.usr.SdkDownloadResponse;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class UsrDemo {

	@Test
	public void testApi() throws Exception {

		UsrClient client = UsrClient.newClient().build();

		{
			SdkDownloadRequest request = new SdkDownloadRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.SdkDownload(request));
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		UsrClient client = UsrClient.newClient().build();

		{
			
			List<Future<SdkDownloadResponse>> res = new ArrayList<Future<SdkDownloadResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				SdkDownloadRequest request = new SdkDownloadRequest();
				// request.setParam..  	// set your request params here

				res.add(client.SdkDownload(request, new ApiCallBack<SdkDownloadRequest, SdkDownloadResponse>() {
					@Override
					public void onFailure(SdkDownloadRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(SdkDownloadRequest request, SdkDownloadResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<SdkDownloadResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		UsrClient client = UsrClient.newClient().scheme(Scheme.HTTPS).build();

		{
			SdkDownloadRequest request = new SdkDownloadRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.SdkDownload(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		UsrClient client = UsrClient.newClient().sandbox(true).build();

		{
			SdkDownloadRequest request = new SdkDownloadRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.SdkDownload(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		UsrClient client = UsrClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			SdkDownloadRequest request = new SdkDownloadRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.SdkDownload(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		UsrClient client = UsrClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			SdkDownloadRequest request = new SdkDownloadRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.SdkDownload(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		UsrClient client = UsrClient.newClient().build();

		{
			SdkDownloadRequest request = new SdkDownloadRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.SdkDownload(request));
		}
		
		client.shutdown();
	}

}
