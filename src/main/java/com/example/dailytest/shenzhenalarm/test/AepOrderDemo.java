package com.example.dailytest.shenzhenalarm.test;

import com.ctg.ag.sdk.biz.AepOrderClient;
import com.ctg.ag.sdk.biz.aep_order.*;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepOrderDemo {

	@Test
	public void testApi() throws Exception {

		AepOrderClient client = AepOrderClient.newClient().build();

		{
			CreateOrderRequest request = new CreateOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createOrder(request));
		}
		
		{
			CreateRenewOrderRequest request = new CreateRenewOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createRenewOrder(request));
		}
		
		{
			RenewPriceRequest request = new RenewPriceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.renewPrice(request));
		}
		
		{
			OrderCanceApplyRequest request = new OrderCanceApplyRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.orderCanceApply(request));
		}
		
		{
			PayRequest request = new PayRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.pay(request));
		}
		
		{
			RefundInfoRequest request = new RefundInfoRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.refundInfo(request));
		}
		
		{
			CreateRefundOrderRequest request = new CreateRefundOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createRefundOrder(request));
		}
		
		{
			PriceRequest request = new PriceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.price(request));
		}
		
		client.shutdown();

	}

	@Test
	public void testApiAsync() throws Exception {

		AepOrderClient client = AepOrderClient.newClient().build();

		{
			
			List<Future<CreateOrderResponse>> res = new ArrayList<Future<CreateOrderResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				CreateOrderRequest request = new CreateOrderRequest();
				// request.setParam..  	// set your request params here

				res.add(client.createOrder(request, new ApiCallBack<CreateOrderRequest, CreateOrderResponse>() {
					@Override
					public void onFailure(CreateOrderRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(CreateOrderRequest request, CreateOrderResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<CreateOrderResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<CreateRenewOrderResponse>> res = new ArrayList<Future<CreateRenewOrderResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				CreateRenewOrderRequest request = new CreateRenewOrderRequest();
				// request.setParam..  	// set your request params here

				res.add(client.createRenewOrder(request, new ApiCallBack<CreateRenewOrderRequest, CreateRenewOrderResponse>() {
					@Override
					public void onFailure(CreateRenewOrderRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(CreateRenewOrderRequest request, CreateRenewOrderResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<CreateRenewOrderResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<RenewPriceResponse>> res = new ArrayList<Future<RenewPriceResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				RenewPriceRequest request = new RenewPriceRequest();
				// request.setParam..  	// set your request params here

				res.add(client.renewPrice(request, new ApiCallBack<RenewPriceRequest, RenewPriceResponse>() {
					@Override
					public void onFailure(RenewPriceRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(RenewPriceRequest request, RenewPriceResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<RenewPriceResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<OrderCanceApplyResponse>> res = new ArrayList<Future<OrderCanceApplyResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				OrderCanceApplyRequest request = new OrderCanceApplyRequest();
				// request.setParam..  	// set your request params here

				res.add(client.orderCanceApply(request, new ApiCallBack<OrderCanceApplyRequest, OrderCanceApplyResponse>() {
					@Override
					public void onFailure(OrderCanceApplyRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(OrderCanceApplyRequest request, OrderCanceApplyResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<OrderCanceApplyResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<PayResponse>> res = new ArrayList<Future<PayResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				PayRequest request = new PayRequest();
				// request.setParam..  	// set your request params here

				res.add(client.pay(request, new ApiCallBack<PayRequest, PayResponse>() {
					@Override
					public void onFailure(PayRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(PayRequest request, PayResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<PayResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<RefundInfoResponse>> res = new ArrayList<Future<RefundInfoResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				RefundInfoRequest request = new RefundInfoRequest();
				// request.setParam..  	// set your request params here

				res.add(client.refundInfo(request, new ApiCallBack<RefundInfoRequest, RefundInfoResponse>() {
					@Override
					public void onFailure(RefundInfoRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(RefundInfoRequest request, RefundInfoResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<RefundInfoResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<CreateRefundOrderResponse>> res = new ArrayList<Future<CreateRefundOrderResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				CreateRefundOrderRequest request = new CreateRefundOrderRequest();
				// request.setParam..  	// set your request params here

				res.add(client.createRefundOrder(request, new ApiCallBack<CreateRefundOrderRequest, CreateRefundOrderResponse>() {
					@Override
					public void onFailure(CreateRefundOrderRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(CreateRefundOrderRequest request, CreateRefundOrderResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<CreateRefundOrderResponse> future : res)
				System.out.println(future.get());

		}
		
		{
			
			List<Future<PriceResponse>> res = new ArrayList<Future<PriceResponse>>();
			
			// multi request
			for (int i = 0; i < 5; i++) {
			
				PriceRequest request = new PriceRequest();
				// request.setParam..  	// set your request params here

				res.add(client.price(request, new ApiCallBack<PriceRequest, PriceResponse>() {
					@Override
					public void onFailure(PriceRequest request, Exception e) {
						e.printStackTrace();
					}
		
					@Override
					public void onResponse(PriceRequest request, PriceResponse response) {
						System.out.println("Receive data and handle it");
					}
				}));
			
			}
			
			// wait and collect all data
			for (Future<PriceResponse> future : res)
				System.out.println(future.get());

		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSsl() throws Exception {

		AepOrderClient client = AepOrderClient.newClient().scheme(Scheme.HTTPS).build();

		{
			CreateOrderRequest request = new CreateOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createOrder(request));
		}
		
		{
			CreateRenewOrderRequest request = new CreateRenewOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createRenewOrder(request));
		}
		
		{
			RenewPriceRequest request = new RenewPriceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.renewPrice(request));
		}
		
		{
			OrderCanceApplyRequest request = new OrderCanceApplyRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.orderCanceApply(request));
		}
		
		{
			PayRequest request = new PayRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.pay(request));
		}
		
		{
			RefundInfoRequest request = new RefundInfoRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.refundInfo(request));
		}
		
		{
			CreateRefundOrderRequest request = new CreateRefundOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createRefundOrder(request));
		}
		
		{
			PriceRequest request = new PriceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.price(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiInSandbox() throws Exception {
	
		AepOrderClient client = AepOrderClient.newClient().sandbox(true).build();

		{
			CreateOrderRequest request = new CreateOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createOrder(request));
		}
		
		{
			CreateRenewOrderRequest request = new CreateRenewOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createRenewOrder(request));
		}
		
		{
			RenewPriceRequest request = new RenewPriceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.renewPrice(request));
		}
		
		{
			OrderCanceApplyRequest request = new OrderCanceApplyRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.orderCanceApply(request));
		}
		
		{
			PayRequest request = new PayRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.pay(request));
		}
		
		{
			RefundInfoRequest request = new RefundInfoRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.refundInfo(request));
		}
		
		{
			CreateRefundOrderRequest request = new CreateRefundOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createRefundOrder(request));
		}
		
		{
			PriceRequest request = new PriceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.price(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSslInSandbox() throws Exception {

		AepOrderClient client = AepOrderClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

		{
			CreateOrderRequest request = new CreateOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createOrder(request));
		}
		
		{
			CreateRenewOrderRequest request = new CreateRenewOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createRenewOrder(request));
		}
		
		{
			RenewPriceRequest request = new RenewPriceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.renewPrice(request));
		}
		
		{
			OrderCanceApplyRequest request = new OrderCanceApplyRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.orderCanceApply(request));
		}
		
		{
			PayRequest request = new PayRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.pay(request));
		}
		
		{
			RefundInfoRequest request = new RefundInfoRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.refundInfo(request));
		}
		
		{
			CreateRefundOrderRequest request = new CreateRefundOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createRefundOrder(request));
		}
		
		{
			PriceRequest request = new PriceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.price(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSignature() throws Exception {

		AepOrderClient client = AepOrderClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

		{
			CreateOrderRequest request = new CreateOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createOrder(request));
		}
		
		{
			CreateRenewOrderRequest request = new CreateRenewOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createRenewOrder(request));
		}
		
		{
			RenewPriceRequest request = new RenewPriceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.renewPrice(request));
		}
		
		{
			OrderCanceApplyRequest request = new OrderCanceApplyRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.orderCanceApply(request));
		}
		
		{
			PayRequest request = new PayRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.pay(request));
		}
		
		{
			RefundInfoRequest request = new RefundInfoRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.refundInfo(request));
		}
		
		{
			CreateRefundOrderRequest request = new CreateRefundOrderRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.createRefundOrder(request));
		}
		
		{
			PriceRequest request = new PriceRequest();
			// request.setParam..  	// set your request params here
			System.out.println(client.price(request));
		}
		
		client.shutdown();
	}

	@Test
	public void testApiWithSession() throws Exception {

		AepOrderClient client = AepOrderClient.newClient().build();

		{
			CreateOrderRequest request = new CreateOrderRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.createOrder(request));
		}
		
		{
			CreateRenewOrderRequest request = new CreateRenewOrderRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.createRenewOrder(request));
		}
		
		{
			RenewPriceRequest request = new RenewPriceRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.renewPrice(request));
		}
		
		{
			OrderCanceApplyRequest request = new OrderCanceApplyRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.orderCanceApply(request));
		}
		
		{
			PayRequest request = new PayRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.pay(request));
		}
		
		{
			RefundInfoRequest request = new RefundInfoRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.refundInfo(request));
		}
		
		{
			CreateRefundOrderRequest request = new CreateRefundOrderRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.createRefundOrder(request));
		}
		
		{
			PriceRequest request = new PriceRequest();
			request.setSession("Your session here");
			// request.setParam..  	// set your request params here
			System.out.println(client.price(request));
		}
		
		client.shutdown();
	}

}
