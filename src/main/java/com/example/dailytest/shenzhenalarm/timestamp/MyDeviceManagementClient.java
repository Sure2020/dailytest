package com.example.dailytest.shenzhenalarm.timestamp;/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MyDeviceManagementClient
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

/*
package com.example.shenzhenalarm.timestamp;

import com.ctg.ag.sdk.biz.aep_device_management.BindDeviceRequest;
import com.ctg.ag.sdk.biz.aep_device_management.BindDeviceResponse;
import com.ctg.ag.sdk.biz.aep_device_management.CreateDeviceRequest;
import com.ctg.ag.sdk.biz.aep_device_management.CreateDeviceResponse;
import com.ctg.ag.sdk.biz.aep_device_management.DeleteDeviceRequest;
import com.ctg.ag.sdk.biz.aep_device_management.DeleteDeviceResponse;
import com.ctg.ag.sdk.biz.aep_device_management.QueryDeviceListRequest;
import com.ctg.ag.sdk.biz.aep_device_management.QueryDeviceListResponse;
import com.ctg.ag.sdk.biz.aep_device_management.QueryDeviceRequest;
import com.ctg.ag.sdk.biz.aep_device_management.QueryDeviceResponse;
import com.ctg.ag.sdk.biz.aep_device_management.QueryProductInfoByImeiRequest;
import com.ctg.ag.sdk.biz.aep_device_management.QueryProductInfoByImeiResponse;
import com.ctg.ag.sdk.biz.aep_device_management.UnbindDeviceRequest;
import com.ctg.ag.sdk.biz.aep_device_management.UnbindDeviceResponse;
import com.ctg.ag.sdk.biz.aep_device_management.UpdateDeviceRequest;
import com.ctg.ag.sdk.biz.aep_device_management.UpdateDeviceResponse;
import com.ctg.ag.sdk.core.BaseApiClientBuilder;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import com.ctg.ag.sdk.core.model.BuilderParams;
import java.util.ArrayList;
import java.util.concurrent.Future;

*/
/**
 * @program: com.example.shenzhenalarm.timestamp
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-23
 **//*

public final class MyDeviceManagementClient extends MyBaseApiClient {
    public static MyBaseApiClientBuilder<MyBaseApiClientBuilder<?, ?>, MyDeviceManagementClient> newClient() {
        return new MyBaseApiClientBuilder<MyBaseApiClientBuilder<?, ?>, MyDeviceManagementClient>() {
            private String[] serverHosts;
            private String[] serverSslHosts;
            private String[] httpHosts;
            private String[] sslHosts;
            private String[] sandboxHttpHosts;
            private String[] sandboxSslHosts;

            {
                ArrayList var1 = new ArrayList();
                var1.add("ag-api.ctwing.cn");
                this.serverHosts = (String[])var1.toArray(new String[0]);
                ArrayList var2 = new ArrayList();
                var2.add("ag-api.ctwing.cn");
                this.serverSslHosts = (String[])var2.toArray(new String[0]);
                ArrayList var3 = new ArrayList();
                var3.add("ag-api.ctwing.cn/aep_device_management");
                this.httpHosts = (String[])var3.toArray(new String[0]);
                ArrayList var4 = new ArrayList();
                var4.add("ag-api.ctwing.cn/aep_device_management");
                this.sslHosts = (String[])var4.toArray(new String[0]);
                ArrayList var5 = new ArrayList();
                var5.add("ag-api.ctwing.cn/aep_device_management");
                this.sandboxHttpHosts = (String[])var5.toArray(new String[0]);
                ArrayList var6 = new ArrayList();
                var6.add("ag-api.ctwing.cn/aep_device_management");
                this.sandboxSslHosts = (String[])var6.toArray(new String[0]);
            }

            protected MyDeviceManagementClient build(BuilderParams var1) {
                return new MyDeviceManagementClient(var1);
            }

            protected String serverHost() {
                return this.nextHost(this.serverHosts);
            }

            protected String serverSslHost() {
                return this.nextHost(this.serverSslHosts);
            }

            protected String httpHost() {
                return this.nextHost(this.httpHosts);
            }

            protected String sslHost() {
                return this.nextHost(this.sslHosts);
            }

            protected String sandboxHttpHost() {
                return this.nextHost(this.sandboxHttpHosts);
            }

            protected String sandboxSslHost() {
                return this.nextHost(this.sandboxSslHosts);
            }
        };
    }

    private MyDeviceManagementClient(BuilderParams var1) {
        super(var1);
    }

    public QueryDeviceListResponse QueryDeviceList(QueryDeviceListRequest var1) throws Exception {
        String var2 = "/devices";
        var1.setPath(var2);
        return (QueryDeviceListResponse)this.syncInvoke(var1);
    }

    public Future<QueryDeviceListResponse> QueryDeviceList(QueryDeviceListRequest var1, ApiCallBack<QueryDeviceListRequest, QueryDeviceListResponse> var2) {
        String var3 = "/devices";
        var1.setPath(var3);
        return this.asyncInvoke(var1, var2);
    }

    public QueryDeviceResponse QueryDevice(QueryDeviceRequest var1) throws Exception {
        String var2 = "/device";
        var1.setPath(var2);
        return (QueryDeviceResponse)this.syncInvoke(var1);
    }

    public Future<QueryDeviceResponse> QueryDevice(QueryDeviceRequest var1, ApiCallBack<QueryDeviceRequest, QueryDeviceResponse> var2) {
        String var3 = "/device";
        var1.setPath(var3);
        return this.asyncInvoke(var1, var2);
    }

    public DeleteDeviceResponse DeleteDevice(DeleteDeviceRequest var1) throws Exception {
        String var2 = "/device";
        var1.setPath(var2);
        return (DeleteDeviceResponse)this.syncInvoke(var1);
    }

    public Future<DeleteDeviceResponse> DeleteDevice(DeleteDeviceRequest var1, ApiCallBack<DeleteDeviceRequest, DeleteDeviceResponse> var2) {
        String var3 = "/device";
        var1.setPath(var3);
        return this.asyncInvoke(var1, var2);
    }

    public UpdateDeviceResponse UpdateDevice(UpdateDeviceRequest var1) throws Exception {
        String var2 = "/device";
        var1.setPath(var2);
        return (UpdateDeviceResponse)this.syncInvoke(var1);
    }

    public Future<UpdateDeviceResponse> UpdateDevice(UpdateDeviceRequest var1, ApiCallBack<UpdateDeviceRequest, UpdateDeviceResponse> var2) {
        String var3 = "/device";
        var1.setPath(var3);
        return this.asyncInvoke(var1, var2);
    }

    public CreateDeviceResponse CreateDevice(CreateDeviceRequest var1) throws Exception {
        String var2 = "/device";
        var1.setPath(var2);
        return (CreateDeviceResponse)this.syncInvoke(var1);
    }

    public Future<CreateDeviceResponse> CreateDevice(CreateDeviceRequest var1, ApiCallBack<CreateDeviceRequest, CreateDeviceResponse> var2) {
        String var3 = "/device";
        var1.setPath(var3);
        return this.asyncInvoke(var1, var2);
    }

    public BindDeviceResponse BindDevice(BindDeviceRequest var1) throws Exception {
        String var2 = "/bindDevice";
        var1.setPath(var2);
        return (BindDeviceResponse)this.syncInvoke(var1);
    }

    public Future<BindDeviceResponse> BindDevice(BindDeviceRequest var1, ApiCallBack<BindDeviceRequest, BindDeviceResponse> var2) {
        String var3 = "/bindDevice";
        var1.setPath(var3);
        return this.asyncInvoke(var1, var2);
    }

    public UnbindDeviceResponse UnbindDevice(UnbindDeviceRequest var1) throws Exception {
        String var2 = "/unbindDevice";
        var1.setPath(var2);
        return (UnbindDeviceResponse)this.syncInvoke(var1);
    }

    public Future<UnbindDeviceResponse> UnbindDevice(UnbindDeviceRequest var1, ApiCallBack<UnbindDeviceRequest, UnbindDeviceResponse> var2) {
        String var3 = "/unbindDevice";
        var1.setPath(var3);
        return this.asyncInvoke(var1, var2);
    }

    public QueryProductInfoByImeiResponse QueryProductInfoByImei(QueryProductInfoByImeiRequest var1) throws Exception {
        String var2 = "/device/getProductInfoFormApiByImei";
        var1.setPath(var2);
        return (QueryProductInfoByImeiResponse)this.syncInvoke(var1);
    }

    public Future<QueryProductInfoByImeiResponse> QueryProductInfoByImei(QueryProductInfoByImeiRequest var1, ApiCallBack<QueryProductInfoByImeiRequest, QueryProductInfoByImeiResponse> var2) {
        String var3 = "/device/getProductInfoFormApiByImei";
        var1.setPath(var3);
        return this.asyncInvoke(var1, var2);
    }
}*/
