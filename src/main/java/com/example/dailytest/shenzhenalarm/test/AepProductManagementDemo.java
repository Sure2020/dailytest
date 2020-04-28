/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : AepProductManagementDemo
 * Date Created : 2020-04-23
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-04-23       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.shenzhenalarm.test;


import com.ctg.ag.sdk.biz.AepProductManagementClient;
import com.ctg.ag.sdk.biz.aep_product_management.*;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;


public class AepProductManagementDemo {

    @Test
    public void testApi() throws Exception {

        //AepProductManagementClient client = AepProductManagementClient.newClient().build();
        AepProductManagementClient client = AepProductManagementClient.newClient().appKey("eke3uNOLPfd").appSecret("wq0xibKkv1 ").build();

        /*{
            QueryProductRequest request = new QueryProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryProduct(request));
        }*/

        {
            QueryProductListRequest request = new QueryProductListRequest();
            // request.setParam..  	// set your request params here
            System.out.println("##############################");
            System.out.println(client.QueryProductList(request));
            System.out.println("##############################");
        }

        /*{
            DeleteProductRequest request = new DeleteProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.DeleteProduct(request));
        }

        {
            CreateProductRequest request = new CreateProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.CreateProduct(request));
        }

        {
            UpdateProductRequest request = new UpdateProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.UpdateProduct(request));
        }*/

        client.shutdown();

    }

    @Test
    public void testApiAsync() throws Exception {

        AepProductManagementClient client = AepProductManagementClient.newClient().build();

        {

            List<Future<QueryProductResponse>> res = new ArrayList<Future<QueryProductResponse>>();

            // multi request
            for (int i = 0; i < 5; i++) {

                QueryProductRequest request = new QueryProductRequest();
                // request.setParam..  	// set your request params here

                res.add(client.QueryProduct(request, new ApiCallBack<QueryProductRequest, QueryProductResponse>() {
                    @Override
                    public void onFailure(QueryProductRequest request, Exception e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(QueryProductRequest request, QueryProductResponse response) {
                        System.out.println("Receive data and handle it");
                    }
                }));

            }

            // wait and collect all data
            for (Future<QueryProductResponse> future : res)
                System.out.println(future.get());

        }

        {

            List<Future<QueryProductListResponse>> res = new ArrayList<Future<QueryProductListResponse>>();

            // multi request
            for (int i = 0; i < 5; i++) {

                QueryProductListRequest request = new QueryProductListRequest();
                // request.setParam..  	// set your request params here

                res.add(client.QueryProductList(request, new ApiCallBack<QueryProductListRequest, QueryProductListResponse>() {
                    @Override
                    public void onFailure(QueryProductListRequest request, Exception e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(QueryProductListRequest request, QueryProductListResponse response) {
                        System.out.println("Receive data and handle it");
                    }
                }));

            }

            // wait and collect all data
            for (Future<QueryProductListResponse> future : res)
                System.out.println(future.get());

        }

        {

            List<Future<DeleteProductResponse>> res = new ArrayList<Future<DeleteProductResponse>>();

            // multi request
            for (int i = 0; i < 5; i++) {

                DeleteProductRequest request = new DeleteProductRequest();
                // request.setParam..  	// set your request params here

                res.add(client.DeleteProduct(request, new ApiCallBack<DeleteProductRequest, DeleteProductResponse>() {
                    @Override
                    public void onFailure(DeleteProductRequest request, Exception e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(DeleteProductRequest request, DeleteProductResponse response) {
                        System.out.println("Receive data and handle it");
                    }
                }));

            }

            // wait and collect all data
            for (Future<DeleteProductResponse> future : res)
                System.out.println(future.get());

        }

        {

            List<Future<CreateProductResponse>> res = new ArrayList<Future<CreateProductResponse>>();

            // multi request
            for (int i = 0; i < 5; i++) {

                CreateProductRequest request = new CreateProductRequest();
                // request.setParam..  	// set your request params here

                res.add(client.CreateProduct(request, new ApiCallBack<CreateProductRequest, CreateProductResponse>() {
                    @Override
                    public void onFailure(CreateProductRequest request, Exception e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(CreateProductRequest request, CreateProductResponse response) {
                        System.out.println("Receive data and handle it");
                    }
                }));

            }

            // wait and collect all data
            for (Future<CreateProductResponse> future : res)
                System.out.println(future.get());

        }

        {

            List<Future<UpdateProductResponse>> res = new ArrayList<Future<UpdateProductResponse>>();

            // multi request
            for (int i = 0; i < 5; i++) {

                UpdateProductRequest request = new UpdateProductRequest();
                // request.setParam..  	// set your request params here

                res.add(client.UpdateProduct(request, new ApiCallBack<UpdateProductRequest, UpdateProductResponse>() {
                    @Override
                    public void onFailure(UpdateProductRequest request, Exception e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(UpdateProductRequest request, UpdateProductResponse response) {
                        System.out.println("Receive data and handle it");
                    }
                }));

            }

            // wait and collect all data
            for (Future<UpdateProductResponse> future : res)
                System.out.println(future.get());

        }

        client.shutdown();
    }

    @Test
    public void testApiWithSsl() throws Exception {

        AepProductManagementClient client = AepProductManagementClient.newClient().scheme(Scheme.HTTPS).build();

        {
            QueryProductRequest request = new QueryProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryProduct(request));
        }

        {
            QueryProductListRequest request = new QueryProductListRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryProductList(request));
        }

        {
            DeleteProductRequest request = new DeleteProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.DeleteProduct(request));
        }

        {
            CreateProductRequest request = new CreateProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.CreateProduct(request));
        }

        {
            UpdateProductRequest request = new UpdateProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.UpdateProduct(request));
        }

        client.shutdown();
    }

    @Test
    public void testApiInSandbox() throws Exception {

        AepProductManagementClient client = AepProductManagementClient.newClient().sandbox(true).build();

        {
            QueryProductRequest request = new QueryProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryProduct(request));
        }

        {
            QueryProductListRequest request = new QueryProductListRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryProductList(request));
        }

        {
            DeleteProductRequest request = new DeleteProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.DeleteProduct(request));
        }

        {
            CreateProductRequest request = new CreateProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.CreateProduct(request));
        }

        {
            UpdateProductRequest request = new UpdateProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.UpdateProduct(request));
        }

        client.shutdown();
    }

    @Test
    public void testApiWithSslInSandbox() throws Exception {

        AepProductManagementClient client = AepProductManagementClient.newClient().scheme(Scheme.HTTPS).sandbox(true).build();

        {
            QueryProductRequest request = new QueryProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryProduct(request));
        }

        {
            QueryProductListRequest request = new QueryProductListRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryProductList(request));
        }

        {
            DeleteProductRequest request = new DeleteProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.DeleteProduct(request));
        }

        {
            CreateProductRequest request = new CreateProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.CreateProduct(request));
        }

        {
            UpdateProductRequest request = new UpdateProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.UpdateProduct(request));
        }

        client.shutdown();
    }

    @Test
    public void testApiWithSignature() throws Exception {

        AepProductManagementClient client = AepProductManagementClient.newClient().appKey("Your app key here").appSecret("Your app secret here").build();

        {
            QueryProductRequest request = new QueryProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryProduct(request));
        }

        {
            QueryProductListRequest request = new QueryProductListRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryProductList(request));
        }

        {
            DeleteProductRequest request = new DeleteProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.DeleteProduct(request));
        }

        {
            CreateProductRequest request = new CreateProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.CreateProduct(request));
        }

        {
            UpdateProductRequest request = new UpdateProductRequest();
            // request.setParam..  	// set your request params here
            System.out.println(client.UpdateProduct(request));
        }

        client.shutdown();
    }

    @Test
    public void testApiWithSession() throws Exception {

        AepProductManagementClient client = AepProductManagementClient.newClient().build();

        {
            QueryProductRequest request = new QueryProductRequest();
            request.setSession("Your session here");
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryProduct(request));
        }

        {
            QueryProductListRequest request = new QueryProductListRequest();
            request.setSession("Your session here");
            // request.setParam..  	// set your request params here
            System.out.println(client.QueryProductList(request));
        }

        {
            DeleteProductRequest request = new DeleteProductRequest();
            request.setSession("Your session here");
            // request.setParam..  	// set your request params here
            System.out.println(client.DeleteProduct(request));
        }

        {
            CreateProductRequest request = new CreateProductRequest();
            request.setSession("Your session here");
            // request.setParam..  	// set your request params here
            System.out.println(client.CreateProduct(request));
        }

        {
            UpdateProductRequest request = new UpdateProductRequest();
            request.setSession("Your session here");
            // request.setParam..  	// set your request params here
            System.out.println(client.UpdateProduct(request));
        }

        client.shutdown();
    }

}