/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MyBaseApiClient
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

package com.example.dailytest.shenzhenalarm.timestamp;

import com.ctg.ag.sdk.core.HttpClient;
import com.ctg.ag.sdk.core.constant.ParamPosition;
import com.ctg.ag.sdk.core.exception.SdkClientException;
import com.ctg.ag.sdk.core.http.HttpClientFactory;
import com.ctg.ag.sdk.core.http.RequestFormat;
import com.ctg.ag.sdk.core.model.ApiCallBack;
import com.ctg.ag.sdk.core.model.BaseApiRequest;
import com.ctg.ag.sdk.core.model.BaseApiRequest.Meta;
import com.ctg.ag.sdk.core.model.BaseApiResponse;
import com.ctg.ag.sdk.core.model.BuilderParams;
import com.ctg.ag.sdk.core.util.Signature;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Future;

/**
 * @program: com.example.shenzhenalarm.timestamp
 * @description: xxx
 * @author: w15021
 * @create: 2020-04-23
 **/
public abstract class MyBaseApiClient {
    protected final String appKey;
    protected final String appSecret;
    protected final HttpClient httpClient;
    protected final long offset;
    protected final String host;
    protected final String scheme;

    public MyBaseApiClient(BuilderParams builderParams) {
        this.appKey = builderParams.getAppKey();
        this.appSecret = builderParams.getAppSecret();
        this.httpClient = HttpClientFactory.buildClient(builderParams);
        this.offset = this.timeSync(builderParams);
        this.host = builderParams.getHost();
        this.scheme = builderParams.getScheme().getValue();
    }
    public MyBaseApiClient() {
        this.appKey = "";
        this.appSecret = "";
        this.httpClient = null;
        this.offset = 0;
        this.host = "";
        this.scheme = "";
    }

    private long timeSync(BuilderParams builderParams) {
        BaseApiRequest syncRequet = new BaseApiRequest(RequestFormat.GET(), (String)null, new Meta[0]) {
            public BaseApiResponse newResponse() {
                return new BaseApiResponse() {
                };
            }
        };
        syncRequet.setHost(builderParams.getServer());
        syncRequet.setPath("/echo");

        try {
            long start = System.currentTimeMillis();
            BaseApiResponse response = this.httpClient.syncInvoke(syncRequet);
            long end = System.currentTimeMillis();
            Map<String, String> headers = response.getHeaders();
            long serviceTime = Double.valueOf((String)headers.get("x-ag-timestamp")).longValue();
            System.out.println("############offset" + (serviceTime - (end + start) / 2L));
            return serviceTime - (end + start) / 2L;
        } catch (Exception var11) {
            throw new RuntimeException("Unable to synchronize time from server: " + syncRequet, var11);
        }
    }

    private <REQ extends BaseApiRequest> REQ buildSDKRequest(REQ apiReq) throws Exception {
        String pathWithPathParameter = this.combinePathParam(apiReq.getPath(), apiReq.getParam(new ParamPosition[]{ParamPosition.PATH}));
        apiReq.setPath(pathWithPathParameter);
        System.out.println("############this.offset" + this.offset);
        Date current = new Date(System.currentTimeMillis() + this.offset);

        String clientCurrentTime = String.valueOf(current.getTime());
        System.out.println("######## true client time" + System.currentTimeMillis());
        //System.out.println("############clientCurrentTime"+ clientCurrentTime);
        //String s
        String timestamp = String.valueOf(System.currentTimeMillis() + 700);

        System.out.println("######timestamp" + timestamp);

        //apiReq.getGlobalParam().put("timestamp", String.valueOf(current.getTime()));
        apiReq.getGlobalParam().put("timestamp", timestamp);
        apiReq.getGlobalParam().put("application", this.appKey);
        if (this.appSecret != null && !this.appSecret.isEmpty()) {
            Map<String, List<String>> input = new TreeMap();
            Iterator var5 = apiReq.getMeta().keySet().iterator();

            while(var5.hasNext()) {
                String s = (String)var5.next();
                List<String> value = apiReq.getParams(s);
                input.put(s, value);
            }

            apiReq.getGlobalParam().put("signature", Signature.sign(this.appSecret, (String)apiReq.getGlobalParam().get("application"), (String)apiReq.getGlobalParam().get("timestamp"), input, apiReq.getBody()));
        }

        apiReq.getGlobalParam().put("Date", this.getHttpDateHeaderValue(current));
        apiReq.getGlobalParam().put("User-Agent", "Telecom API Gateway Java SDK");
        apiReq.getGlobalParam().put("version", apiReq.getGlobalParam().get("version"));
        apiReq.getGlobalParam().put("sdk", "GIT: a4fb7fca");
        apiReq.getGlobalParam().put("Content-Type", apiReq.getMethod().getContentType().toString());
        if (apiReq.getGlobalParam().get("version") == null || ((String)apiReq.getGlobalParam().get("version")).trim().isEmpty()) {
            apiReq.getGlobalParam().remove("version");
        }

        return apiReq;
    }

    private String combinePathParam(String path, Map<String, List<String>> pathParams) {
        if (pathParams == null) {
            return path;
        } else {
            String key;
            for(Iterator var3 = pathParams.keySet().iterator(); var3.hasNext(); path = path.replace("[" + key + "]", (CharSequence)((List)pathParams.get(key)).iterator().next())) {
                key = (String)var3.next();
            }

            return path;
        }
    }

    private String getHttpDateHeaderValue(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(date);
    }

    public final <R extends BaseApiResponse> R syncInvoke(BaseApiRequest apiRequest) throws Exception {
        try {
            apiRequest = this.buildSDKRequest(apiRequest);
            return (R) this.httpClient.syncInvoke(apiRequest);
        } catch (IOException var3) {
            throw new SdkClientException(var3);
        }
    }

    public final <REQ extends BaseApiRequest, RESP extends BaseApiResponse> Future<RESP> asyncInvoke(REQ apiRequest, ApiCallBack<REQ, RESP> callback) {
        try {
            apiRequest = this.buildSDKRequest(apiRequest);
            return this.httpClient.asyncInvoke(apiRequest, callback);
        } catch (Exception var4) {
            throw new SdkClientException(var4);
        }
    }

    public void shutdown() {
        try {
            if (this.httpClient != null) {
                this.httpClient.close();
            }
        } catch (Exception var2) {
        }

    }
}

