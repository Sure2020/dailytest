package com.example.dailytest.testmain.testSendSoapRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.*;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
public class HttpClientPoolUtils {
    //private static Logger logger = LoggerFactory.getLogger(HttpClientPoolUtils.class);
    // 池化管理
    private static PoolingHttpClientConnectionManager poolConnManager = null;

    private volatile static CloseableHttpClient httpClient;
    //请求器的配置
    private static RequestConfig requestConfig;

    private HttpClientPoolUtils() {
    }

    static {

        try {
            //创建ssl安全访问连接
//            SSLContext sslContext = getSSLContext(true,null,null);
            System.out.println("初始化HttpClientTest~~~开始");
//            SSLContextBuilder builder = new SSLContextBuilder();
//            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
//            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
//                    builder.build());
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(SSLContexts.custom().loadTrustMaterial(null,new TrustSelfSignedStrategy()).build(),NoopHostnameVerifier.INSTANCE);
            // 配置同时支持 HTTP 和 HTPPS
            Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create().register(
                    "http", PlainConnectionSocketFactory.getSocketFactory()).register(
                    "https", sslsf).build();
            // 初始化连接管理器
            poolConnManager = new PoolingHttpClientConnectionManager(
                    socketFactoryRegistry);
            // 将最大连接数增加到200，实际项目最好从配置文件中读取这个值
            poolConnManager.setMaxTotal(200);
            // 设置最大路由
            poolConnManager.setDefaultMaxPerRoute(5);
            // 根据默认超时限制初始化requestConfig（每行的注释后面是之前的配置，后来改成2分钟是为了配合宿迁有个很慢的接口）
            int socketTimeout = 120000;//19000
            int connectTimeout = 120000;//19000
            int connectionRequestTimeout = 120000;//20000
            requestConfig = RequestConfig.custom().setConnectionRequestTimeout(
                    connectionRequestTimeout).setSocketTimeout(socketTimeout).setConnectTimeout(
                    connectTimeout).build();
            // 初始化httpClient
            //httpClient = getConnection();

            System.out.println("初始化HttpClientTest~~~结束");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static SSLContext getSSLContext(boolean isDeceive,File creFile,String crePwd)
            throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, CertificateException, FileNotFoundException, IOException{
        SSLContext sslContext = null;

        if (isDeceive) {
            sslContext = SSLContext.getInstance("SSLv3");
            // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法
            X509TrustManager x509TrustManager = new X509TrustManager() {
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
            };
            sslContext.init(null, new TrustManager[] {x509TrustManager}, null);
        } else {
            if (null != creFile && creFile.length() > 0) {
                if (null != crePwd) {
                    KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                    keyStore.load(new FileInputStream(creFile), crePwd.toCharArray());
                    sslContext = SSLContexts.custom().loadTrustMaterial(keyStore, new TrustSelfSignedStrategy()).build();
                } else {
                    throw new SSLHandshakeException("整数密码为空");
                }
            }
        }

        return sslContext;
    }

    public static CloseableHttpClient getHttpClient() {

        if (httpClient == null) {
            synchronized (HttpClientPoolUtils.class) {
                if (httpClient == null) {
                    httpClient = HttpClients.custom()
                            // 设置连接池管理
                            .setConnectionManager(poolConnManager)
                            // 设置请求配置
                            .setDefaultRequestConfig(requestConfig)
                            // 设置重试次数
                            .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                            .build();
                }
            }
        }
        return httpClient;
    }

    public static HttpClientResult getPostResult(String url, String contentType, JSONObject requestBody) {
        log.info("网络请求url:" + url);
        log.info("请求参数：" + requestBody.toString());
        HttpResponse mHttpResponse = null;
        HttpPost mHttpPost;
        CloseableHttpClient mHttpClients = HttpClientPoolUtils.getHttpClient();
        int code = -1;
        String result = "返回数据为空";
        mHttpPost = new HttpPost(url);
        switch (contentType) {
            case "x-www-form-urlencoded":
                ArrayList<NameValuePair> mPostBodyValue = new ArrayList<>();
                mHttpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                //Iterator it = requestBody.keys();
                Iterator it = requestBody.keySet().iterator();
                while (it.hasNext()) {
                    String key = (String) it.next();
                    String value = requestBody.getString(key);
                    mPostBodyValue.add(new BasicNameValuePair(key, value));
                }
                try {
                    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(mPostBodyValue, "utf-8");
                    mHttpPost.setEntity(formEntity);
                    mPostBodyValue.clear();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case "application/json":
                mHttpPost.setHeader("Content-Type", "application/json");
                StringEntity s = new StringEntity(requestBody.toString(), "utf-8");
                s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                mHttpPost.setEntity(s);
                break;
            case "form-data":
                break;
        }
        //ִ执行网络请求
        try {
            System.out.println("execute");
            for (int i = 0; i <= 3; i++) {
                mHttpResponse = mHttpClients.execute(mHttpPost);
                int respons_code = mHttpResponse.getStatusLine().getStatusCode();
                String codeStr = String.valueOf(respons_code);
                log.info("reponCode:" + codeStr);
                if (null != mHttpResponse && codeStr.startsWith("4")) {
                    return HttpClientResult.build(respons_code, null);
                }
                if (null != mHttpResponse && codeStr.startsWith("2")) {
                    break;
                } else {
                    ((CloseableHttpResponse) mHttpResponse).close();
                    mHttpPost.releaseConnection();
                }
                if (i == 3) {
                    if (null == mHttpResponse || !(codeStr.startsWith("2"))) {
                        return HttpClientResult.build(respons_code, null);
                    }
                }
            }
            if (mHttpResponse != null) {
                //获取返回结果
                HttpEntity mHttpEntity = mHttpResponse.getEntity();
                code = mHttpResponse.getStatusLine().getStatusCode();
                log.info("code:" + String.valueOf(code));
                if (mHttpEntity != null) {
                    result = EntityUtils.toString(mHttpEntity, "UTF-8");
                    EntityUtils.consume(mHttpEntity);
                    log.info("获得token：" + result);
                }
            } else {
                return HttpClientResult.build(1, "网络返回数据为空！");

            }
            System.out.println("end");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (mHttpResponse != null) {
                    //关闭流
                    ((CloseableHttpResponse) mHttpResponse).close();
                }
                if (mHttpPost != null) {
                    mHttpPost.releaseConnection();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return HttpClientResult.build(code, result);
    }
    public static HttpClientResult getPostResult(String url, String contentType, JSONObject requestBody, List<HeaderMap> headerMapList) {
        log.info("网络请求url:" + url);
        log.info("请求参数：" + requestBody.toString());
        HttpResponse mHttpResponse = null;
        HttpPost mHttpPost;
        CloseableHttpClient mHttpClients = HttpClientPoolUtils.getHttpClient();
        int code = -1;
        String result = "返回数据为空";
        mHttpPost = new HttpPost(url);
        switch (contentType) {
            case "x-www-form-urlencoded":
                ArrayList<NameValuePair> mPostBodyValue = new ArrayList<>();
                mHttpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                //Iterator it = requestBody.keys();
                Iterator it = requestBody.keySet().iterator();
                while (it.hasNext()) {
                    String key = (String) it.next();
                    String value = requestBody.getString(key);
                    mPostBodyValue.add(new BasicNameValuePair(key, value));
                }
                try {
                    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(mPostBodyValue, "utf-8");
                    mHttpPost.setEntity(formEntity);
                    mPostBodyValue.clear();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case "application/json":
                mHttpPost.setHeader("Content-Type", "application/json");
                StringEntity s = new StringEntity(requestBody.toString(), "utf-8");
                s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                mHttpPost.setEntity(s);
                break;
            case "form-data":
                break;
        }
        for(HeaderMap headerMap : headerMapList) {
            mHttpPost.addHeader(headerMap.getKey(),headerMap.getValue());
        }
        //ִ执行网络请求
        try {
            System.out.println("execute");
            for (int i = 0; i <= 3; i++) {
                mHttpResponse = mHttpClients.execute(mHttpPost);
                int respons_code = mHttpResponse.getStatusLine().getStatusCode();
                String codeStr = String.valueOf(respons_code);
                log.info("reponCode:" + codeStr);
                if (null != mHttpResponse && codeStr.startsWith("4")) {
                    return HttpClientResult.build(respons_code, null);
                }
                if (null != mHttpResponse && codeStr.startsWith("2")) {
                    break;
                } else {
                    ((CloseableHttpResponse) mHttpResponse).close();
                    mHttpPost.releaseConnection();
                }
                if (i == 3) {
                    if (null == mHttpResponse || !(codeStr.startsWith("2"))) {
                        return HttpClientResult.build(respons_code, null);
                    }
                }
            }
            if (mHttpResponse != null) {
                //获取返回结果
                HttpEntity mHttpEntity = mHttpResponse.getEntity();
                code = mHttpResponse.getStatusLine().getStatusCode();
                log.info("code:" + String.valueOf(code));
                if (mHttpEntity != null) {
                    result = EntityUtils.toString(mHttpEntity, "UTF-8");
                    EntityUtils.consume(mHttpEntity);
                }
            } else {
                return HttpClientResult.build(1, "网络返回数据为空！");

            }
            System.out.println("end");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (mHttpResponse != null) {
                    //关闭流
                    ((CloseableHttpResponse) mHttpResponse).close();
                }
                if (mHttpPost != null) {
                    mHttpPost.releaseConnection();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return HttpClientResult.build(code, result);
    }

    public static HttpClientResult getPutResult(String url, String contentType, JSONObject requestBody) {
        log.info("网络请求url:" + url);
        log.info("请求参数：" + requestBody.toString());
        HttpResponse mHttpResponse = null;
        HttpPut mHttpPost;
        CloseableHttpClient mHttpClients = HttpClientPoolUtils.getHttpClient();
        int code = -1;
        String result = "返回数据为空";
        mHttpPost = new HttpPut(url);
        switch (contentType) {
            case "application/x-www-form-urlencoded":
                ArrayList<NameValuePair> mPostBodyValue = new ArrayList<>();
                mHttpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                //Iterator it = requestBody.keys();
                Iterator it = requestBody.keySet().iterator();
                while (it.hasNext()) {
                    String key = (String) it.next();
                    String value = requestBody.getString(key);
                    mPostBodyValue.add(new BasicNameValuePair(key, value));
                }
                try {
                    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(mPostBodyValue, "utf-8");
                    mHttpPost.setEntity(formEntity);
                    mPostBodyValue.clear();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case "application/json":
                mHttpPost.setHeader("Content-Type", "application/json");
                StringEntity s = new StringEntity(requestBody.toString(), "utf-8");
                s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                mHttpPost.setEntity(s);
                break;
            default:
                break;
        }
        //ִ执行网络请求
        try {
            System.out.println("execute");
            for (int i = 0; i <= 3; i++) {
                mHttpResponse = mHttpClients.execute(mHttpPost);
                int respons_code = mHttpResponse.getStatusLine().getStatusCode();
                String codeStr = String.valueOf(respons_code);
                log.info("reponCode:" + codeStr);
                if (null != mHttpResponse && codeStr.startsWith("4")) {
                    return HttpClientResult.build(respons_code, null);
                }
                if (null != mHttpResponse && codeStr.startsWith("2")) {
                    break;
                } else {
                    ((CloseableHttpResponse) mHttpResponse).close();
                    mHttpPost.releaseConnection();
                }
                if (i == 3) {
                    if (null == mHttpResponse || !(codeStr.startsWith("2"))) {
                        return HttpClientResult.build(respons_code, null);
                    }
                }
            }
            if (mHttpResponse != null) {
                //获取返回结果
                HttpEntity mHttpEntity = mHttpResponse.getEntity();
                code = mHttpResponse.getStatusLine().getStatusCode();
                log.info("code:" + String.valueOf(code));
                if (mHttpEntity != null) {
                    result = EntityUtils.toString(mHttpEntity, "UTF-8");
                    EntityUtils.consume(mHttpEntity);
                    log.info("获得token：" + result);
                }
            } else {
                return HttpClientResult.build(1, "网络返回数据为空！");

            }
            System.out.println("end");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (mHttpResponse != null) {
                    //关闭流
                    ((CloseableHttpResponse) mHttpResponse).close();
                }
                if (mHttpPost != null) {
                    mHttpPost.releaseConnection();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return HttpClientResult.build(code, result);
    }


    public static HttpClientResult getPutResult(String url, String contentType, JSONObject requestBody, List<HeaderMap> headerMapList) {
        log.info("网络请求url:" + url);
        log.info("请求参数：" + requestBody.toString());
        HttpResponse mHttpResponse = null;
        HttpPut mHttpPost;
        CloseableHttpClient mHttpClients = HttpClientPoolUtils.getHttpClient();
        int code = -1;
        String result = "返回数据为空";
        mHttpPost = new HttpPut(url);
        switch (contentType) {
            case "application/x-www-form-urlencoded":
                ArrayList<NameValuePair> mPostBodyValue = new ArrayList<>();
                mHttpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                //Iterator it = requestBody.keys();
                Iterator it = requestBody.keySet().iterator();
                while (it.hasNext()) {
                    String key = (String) it.next();
                    String value = requestBody.getString(key);
                    mPostBodyValue.add(new BasicNameValuePair(key, value));
                }
                try {
                    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(mPostBodyValue, "utf-8");
                    mHttpPost.setEntity(formEntity);
                    mPostBodyValue.clear();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case "application/json":
                mHttpPost.setHeader("Content-Type", "application/json");
                StringEntity s = new StringEntity(requestBody.toString(), "utf-8");
                s.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                mHttpPost.setEntity(s);
                break;
            default:
                break;
        }
        for(HeaderMap headerMap : headerMapList) {
            mHttpPost.addHeader(headerMap.getKey(),headerMap.getValue());
        }
        //ִ执行网络请求
        try {
            System.out.println("execute");
            for (int i = 0; i <= 3; i++) {
                mHttpResponse = mHttpClients.execute(mHttpPost);
                int respons_code = mHttpResponse.getStatusLine().getStatusCode();
                String codeStr = String.valueOf(respons_code);
                log.info("reponCode:" + codeStr);
                if (null != mHttpResponse && codeStr.startsWith("4")) {
                    return HttpClientResult.build(respons_code, null);
                }
                if (null != mHttpResponse && codeStr.startsWith("2")) {
                    break;
                } else {
                    ((CloseableHttpResponse) mHttpResponse).close();
                    mHttpPost.releaseConnection();
                }
                if (i == 3) {
                    if (null == mHttpResponse || !(codeStr.startsWith("2"))) {
                        return HttpClientResult.build(respons_code, null);
                    }
                }
            }
            if (mHttpResponse != null) {
                //获取返回结果
                HttpEntity mHttpEntity = mHttpResponse.getEntity();
                code = mHttpResponse.getStatusLine().getStatusCode();
                log.info("code:" + String.valueOf(code));
                if (mHttpEntity != null) {
                    result = EntityUtils.toString(mHttpEntity, "UTF-8");
                    EntityUtils.consume(mHttpEntity);
                    log.info("获得token：" + result);
                }
            } else {
                return HttpClientResult.build(1, "网络返回数据为空！");

            }
            System.out.println("end");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (mHttpResponse != null) {
                    //关闭流
                    ((CloseableHttpResponse) mHttpResponse).close();
                }
                if (mHttpPost != null) {
                    mHttpPost.releaseConnection();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return HttpClientResult.build(code, result);
    }


    public static HttpClientResult getGetResult(String url) {
        log.info("网络请求url:" + url);
        String httpResult = "";
        int code = -1;
        CloseableHttpClient httpclient = HttpClientPoolUtils.getHttpClient();
        // try {
        // 创建httpget.
        HttpGet httpget = new HttpGet(url);
        // 执行get请求.
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
            // 获取响应实体
            HttpEntity entity = response.getEntity();
            // 打印响应状态
            code = response.getStatusLine().getStatusCode();
            log.info("code:" + code);
            if (entity != null) {
                // 响应内容
                httpResult = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
//                log.info("result:" + httpResult);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpget != null) {
                httpget.releaseConnection();
            }
        }
        return HttpClientResult.build(code, httpResult);
    }


    public static HttpClientResult getGetResult(String url, List<HeaderMap> headerMapList) {
        log.info("网络请求url:" + url);
        String httpResult = "";
        int code = -1;
        CloseableHttpClient httpclient = HttpClientPoolUtils.getHttpClient();
        // try {
        // 创建httpget.
        HttpGet httpget = new HttpGet(url);
        for(HeaderMap headerMap : headerMapList) {
            httpget.addHeader(headerMap.getKey(),headerMap.getValue());
        }
        // 执行get请求.
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpget);
            // 获取响应实体
            HttpEntity entity = response.getEntity();
            // 打印响应状态
            code = response.getStatusLine().getStatusCode();
            log.info("code:" + code);
            if (entity != null) {
                // 响应内容
                httpResult = EntityUtils.toString(entity, "UTF-8");
                EntityUtils.consume(entity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (httpget != null) {
                httpget.releaseConnection();
            }
        }
        return HttpClientResult.build(code, httpResult);
    }


    public static HttpClientResult getDeleteResult(String url) {
        CloseableHttpClient mHttpClients = HttpClientPoolUtils.getHttpClient();
        CloseableHttpResponse deleResponse = null;
        HttpDelete mHttpDelete = new HttpDelete(url);
        HttpEntity entity;
        String resultDele = "请求成功！";
        int code = -1;
        mHttpDelete.setHeader("Content-Type", "application/x-www-form-urlencoded");
        try {
            deleResponse = mHttpClients.execute(mHttpDelete);
            if (deleResponse == null) {
                return HttpClientResult.build(1, "网络请求失败");
            }
            code = deleResponse.getStatusLine().getStatusCode();
            log.info("code" + code);
            if (String.valueOf(code).startsWith("2")) {
                entity = deleResponse.getEntity();
                if (entity != null) {
                    resultDele = EntityUtils.toString(entity, "UTF-8");
                    EntityUtils.consume(entity);
                }
                return HttpClientResult.build(code, resultDele);
            } else {
                return HttpClientResult.build(code, "网络请求异常，返回码错误");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (deleResponse != null) {
                    deleResponse.close();
                }
                if (mHttpDelete != null) {
                    mHttpDelete.releaseConnection();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return HttpClientResult.build(code, resultDele);
    }

    public static HttpClientResult getDeleteResult(String url, List<HeaderMap> headerMapList) {
        CloseableHttpClient mHttpClients = HttpClientPoolUtils.getHttpClient();
        CloseableHttpResponse deleResponse = null;
        HttpDelete mHttpDelete = new HttpDelete(url);
        HttpEntity entity;
        String resultDele = "请求成功！";
        int code = -1;
        mHttpDelete.setHeader("Content-Type", "application/x-www-form-urlencoded");
        for(HeaderMap headerMap : headerMapList) {
            mHttpDelete.addHeader(headerMap.getKey(),headerMap.getValue());
        }
        try {
            deleResponse = mHttpClients.execute(mHttpDelete);
            if (deleResponse == null) {
                return HttpClientResult.build(1, "网络请求失败");
            }
            code = deleResponse.getStatusLine().getStatusCode();
            log.info("code" + code);
            if (String.valueOf(code).startsWith("2")) {
                entity = deleResponse.getEntity();
                if (entity != null) {
                    resultDele = EntityUtils.toString(entity, "UTF-8");
                    EntityUtils.consume(entity);
                }
                return HttpClientResult.build(code, resultDele);
            } else {
                return HttpClientResult.build(code, "网络请求异常，返回码错误");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (deleResponse != null) {
                    deleResponse.close();
                }
                if (mHttpDelete != null) {
                    mHttpDelete.releaseConnection();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return HttpClientResult.build(code, resultDele);
    }

    /*public static HttpClientResult getHcr(String svcMethod, String url, String contentType, JSONObject jsonresult, ServiceParam serviceParam) {
        HttpClientResult hcr;
        if (Constant.GET.equalsIgnoreCase(svcMethod)) {
            hcr = HttpClientPoolUtils.getGetResult(url);
        } else if (Constant.POST.equalsIgnoreCase(svcMethod)) {
            hcr = HttpClientPoolUtils.getPostResult(url, contentType, jsonresult);
        } else if (Constant.PUT.equalsIgnoreCase(svcMethod)) {
            hcr = HttpClientPoolUtils.getPutResult(url, contentType, jsonresult);
        } else {
            hcr = HttpClientPoolUtils.getDeleteResult(url);
        }
        return xmlOrJson(hcr, serviceParam);
    }*/

    /*public static HttpClientResult getHcr(String svcMethod, String url, String contentType, JSONObject jsonresult, List<HeaderMap> headerMapList, ServiceParam serviceParam) {
        HttpClientResult hcr;
        if (Constant.GET.equalsIgnoreCase(svcMethod)) {
            hcr = HttpClientPoolUtils.getGetResult(url, headerMapList);
        } else if (Constant.POST.equalsIgnoreCase(svcMethod)) {
            hcr = HttpClientPoolUtils.getPostResult(url, contentType, jsonresult, headerMapList);
        } else if (Constant.PUT.equalsIgnoreCase(svcMethod)) {
            hcr = HttpClientPoolUtils.getPutResult(url, contentType, jsonresult, headerMapList);
        } else {
            hcr = HttpClientPoolUtils.getDeleteResult(url, headerMapList);
        }
        return xmlOrJson(hcr, serviceParam);
    }*/

    /*public static HttpClientResult getWebServiceResult(String url, String contentType, List<HeaderMap> headerMapList, JSONObject requestBody, ServiceParam serviceParam) {
        log.info("网络请求url:" + url);
        log.info("请求参数：" + requestBody.toString());
        WebService webService = serviceParam.getWebService();
        String operation = webService == null ? null : webService.getOperation();
        String namespace = webService == null ? null : webService.getNamespace();
        String resType = webService == null ? null : webService.getRespType();
        HttpResponse mHttpResponse = null;
        HttpPost mHttpPost;
        CloseableHttpClient mHttpClients = HttpClientPoolUtils.getHttpClient();
        int code = -1;
        String result = "返回数据为空";
        mHttpPost = new HttpPost(url);

        //这里先将Content-Type设置为"text/xml; charset=utf-8"，防止用户遗忘设置header的情况。如果用户有设置，则该项会被覆盖。
        mHttpPost.setHeader("Content-Type","text/xml; charset=utf-8");
        for(HeaderMap headerMap : headerMapList) {
            mHttpPost.setHeader(headerMap.getKey(),headerMap.getValue());
        }

        StringEntity data = new StringEntity(XmlUtil.jsonToXml(requestBody,operation, namespace), Charset.forName("UTF-8"));
        log.info("请求参数xml:" + XmlUtil.jsonToXml(requestBody,operation, namespace));
        mHttpPost.setEntity(data);
        //ִ执行网络请求
        try {
            System.out.println("execute");
            for (int i = 0; i <= 3; i++) {
                mHttpResponse = mHttpClients.execute(mHttpPost);
                int respons_code = mHttpResponse.getStatusLine().getStatusCode();
                String codeStr = String.valueOf(respons_code);
                log.info("reponCode:" + codeStr);
                if (null != mHttpResponse && codeStr.startsWith("4")) {
                    return HttpClientResult.build(respons_code, null);
                }
                if (null != mHttpResponse && codeStr.startsWith("2")) {
                    break;
                } else {
                    ((CloseableHttpResponse) mHttpResponse).close();
                    mHttpPost.releaseConnection();
                }
                if (i == 3) {
                    if (null == mHttpResponse || !(codeStr.startsWith("2"))) {
                        return HttpClientResult.build(respons_code, null);
                    }
                }
            }
            if (mHttpResponse != null) {
                //获取返回结果
                HttpEntity mHttpEntity = mHttpResponse.getEntity();
                code = mHttpResponse.getStatusLine().getStatusCode();
                log.info("code:" + String.valueOf(code));
                if (mHttpEntity != null) {
                    result = EntityUtils.toString(mHttpEntity, "UTF-8");
                    EntityUtils.consume(mHttpEntity);
                }
            } else {
                return HttpClientResult.build(1, "网络返回数据为空！");

            }
            System.out.println("end");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流
                if (mHttpResponse != null) {
                    //关闭流
                    ((CloseableHttpResponse) mHttpResponse).close();
                }
                if (mHttpPost != null) {
                    mHttpPost.releaseConnection();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        result = XmlUtil.XmlTojson(result, resType);
        JSONObject jsonObject = new JSONObject();;
        if(serviceParam.getRespParams().isHttpStatusCode()){
            if (result.startsWith("[")){
                //[{}] jsonArray
                List<JSONObject>  tmp = JSONArray.parseArray(result,JSONObject.class);
               // log.info("result:{}",result);
                jsonObject.put("null",tmp);
            } else {
                jsonObject = JSONObject.parseObject(result);
            }
            jsonObject.put("code",200);
            jsonObject.put("message","成功");
            log.info("解析后结果:" + jsonObject.toString());
            return HttpClientResult.build(code, jsonObject.toJSONString());
        }
        log.info("解析后结果:" + result.toString());
        return HttpClientResult.build(code, result.toString());
    }*/

    /**
     * @description: 当xml格式的请求体的参数是以key=value风格放在标签中，则执行此方法。背景如下：
     *      getWebServiceResultKeyValueStyle函数是为了适配辽宁高速项目的华维网关soap接口的请求体和响应体风格，
     *     考虑到不污染现有代码，避免引入问题，于是写一个新的函数实现。
     *     辽宁高速soap接口特殊之处是参数都是以key=value的形式放在标签中，如下所示：
     *     <Options
     *         ReturnItemName=true
     *         LocalID="en-US"
     *     />
     *     这种格式之前不支持，只支持以下这种风格：
     *     <Options>
     *         <ReturnItemName>true</ReturnItemName>
     *         <LocalID>"en-US"<LocalID/>
     *     </OPtions>
     * @param:
     * @return:
     * @author: w15021
     * @date: 2020/7/13
     */
    public static HttpClientResult getWebServiceResultKeyValueStyle(String endpoint, List<HeaderMap> headerMapList, JSONObject requestBody, ServiceParam serviceParam) throws SOAPException {

        WebService webService = serviceParam.getWebService();
        String operation = webService == null ? null : webService.getOperation();
        String namespace = webService == null ? null : webService.getNamespace();
        //String resType = webService == null ? null : webService.getRespType();

        //  创建消息对象
        // ===========================================
        SOAPMessage message = MessageFactory.newInstance().createMessage();
        SOAPHeader header = message.getSOAPHeader();
        header.detachNode();

        MimeHeaders mh = message.getMimeHeaders();
        for(HeaderMap headerMap : headerMapList) {
            mh.addHeader(headerMap.getKey(),headerMap.getValue());
        }
        //这里将Content-Type设置为"text/xml; charset=utf-8"，防止用户遗忘设置header的情况。如果用户有设置，则该项无效。
        mh.addHeader("Content-Type","text/xml; charset=utf-8");

        // 获取soap的信封
        SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
        //envelope.setPrefix("soap");

        // 获取消息的body
        SOAPBody body = message.getSOAPBody();
        //body.setPrefix("soap");
        QName bodyName =  new QName(namespace, operation);
        //SOAPBodyElement bodyElement = body.addBodyElement(bodyName);
        SOAPElement bodyElement = body.addBodyElement(bodyName);

        //见函数说明
        addAttributeForbodyElement(bodyElement, requestBody, operation);
        //见函数说明
        addChildElementForElement(bodyElement, requestBody);

        int httpCode = -1;
        SOAPMessage response = null;
        try {
            SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
            response = connection.call(message, endpoint);
            connection.close();
            //暂时没找到怎么从SOAPMessage 类型的response中获取http code，于是先这样处理
            httpCode = 200;
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }

        /*SOAPBody responseBody = response.getSOAPBody();
        NodeList list = responseBody.getChildNodes();
        JAXBContext jaxbContext = JAXBContext.newInstance(ReadResponse.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ReadResponse readResponse = (ReadResponse) jaxbUnmarshaller.unmarshal(list.item(1));
        List<ItemValue> replyItems = readResponse.getRItemList().getItems();

        if (replyItems.size() > 0)
        {
            int n = 0;
            OPCData opcdata = null;
            for (ItemValue v : replyItems) {
                n = Integer.parseInt(v.getClientItemHandle());
                opcdata = opcDataList.get(n);
                opcdata.setOPCValue(v.getValue().toString());
                opcdata.setOPCTime(v.getTimestamp().toString().replace('T', ' '));
            }
        }*/

        String resultString = soapMessageToString(response);
        return HttpClientResult.build(httpCode, resultString);
    }

    /**
     * @description: 将用户配置的请求参数（已json对象保存）拼装成xml格式（应该有好用的json直接转xml的工具，尚未找到合适的，故自己写了一个简陋的）
     * @param: 
     * @return: 
     * @author: w15021
     * @date: 2020/7/14
     */
    public static void addChildElementForElement (SOAPElement soapElement, JSONObject requestObj) throws SOAPException {

        for (String currentObjKey : requestObj.keySet()) {
            Object currentObj = requestObj.get(currentObjKey);
            if (currentObj instanceof JSONObject) {
                JSONObject currentJsonObj = (JSONObject)currentObj;
                SOAPElement se = soapElement.addChildElement(currentObjKey);
                //递归
                addChildElementForElement(se, currentJsonObj);
            } else if (currentObj instanceof String){
                String currentObjValue = currentObj.toString();
                soapElement.setAttribute(currentObjKey, currentObjValue);
            } else if (currentObj instanceof List) {
                List currentList = (List) currentObj;
                for(int i = 0; i < currentList.size(); i ++) {
                    Object currentListObj = currentList.get(i);
                    SOAPElement parentElement = soapElement.getParentElement();
                    String currentElementName = soapElement.getTagName();
                    System.out.println("currentElementName: " + currentElementName);
                    if (currentListObj instanceof String){
                        //这里，当第一次循环时直接setAttribute，而不是先重新取到element再setAttribute,是因为此时传入的
                        //soapElement已经是待操作element了。以后的循环是先重新取到element再setAttribute。
                        //如果没理解上面两行的解释，可以将（0==i）这个分支去掉，运行后会发现最后拼装出来的请求体会多一个空的标签。
                        if(0 == i) {
                            soapElement.setAttribute(currentObjKey, (String) currentListObj);
                        } else {
                            SOAPElement tempElement = parentElement.addChildElement(currentElementName);
                            tempElement.setAttribute(currentObjKey, (String) currentListObj);
                        }
                    } else {
                        log.error("目前仅支持数组元素为String类型，当前元素内容为：{}", currentListObj.toString());
                    }
                }
            } else {
                log.error("不支持的类型，object内容为：{}", currentObj);
                return;
            }
        }
    }

    /**
     * @description: 假设operation="Read"。有的请求参数在名为<Read></>标签的attribute中。而Read标签已在addBodyElement步骤中
     * 添加，这个函数的作用就是判断用户在页面上有没有配置key为"Read"的json对象，若有，则直接在已存在的Read标签中添加attribute，
     * 而不再新建名为Read的标签
     * @param:
     * @return:
     * @author: w15021
     * @date: 2020/7/14
     */
    public static void addAttributeForbodyElement(SOAPElement soapElement, JSONObject requestObj, String operation){
        if(requestObj.keySet().contains(operation)){
            JSONObject jsonObjectNamedOperation = requestObj.getJSONObject(operation);
            if(jsonObjectNamedOperation != null && jsonObjectNamedOperation.size() > 0) {
                for(String currentObjKey : jsonObjectNamedOperation.keySet()){
                    String currentObjValue = jsonObjectNamedOperation.getString(currentObjKey);
                    soapElement.setAttribute(currentObjKey, currentObjValue);
                }
            }

            requestObj.remove(operation);
        }
        return;
    }

    /**
     * @description: 官网找到的一个很好很规范的soapMessage转为String的函数，其实关键代码就try中的3行
     * @param: 
     * @return: 
     * @author: w15021
     * @date: 2020/7/14
     */
    public static String soapMessageToString(SOAPMessage message)
    {
        String result = null;

        if (message != null)
        {
            ByteArrayOutputStream baos = null;
            try
            {
                baos = new ByteArrayOutputStream();
                message.writeTo(baos);
                result = baos.toString();
            }
            catch (Exception e)
            {
            }
            finally
            {
                if (baos != null)
                {
                    try
                    {
                        baos.close();
                    }
                    catch (IOException ioe)
                    {
                    }
                }
            }
        }
        System.out.println("soapMessageToString: " + result);
        return result;
    }

    /*private static HttpClientResult xmlOrJson(HttpClientResult httpClientResult, ServiceParam serviceParam) {
        WebService webService = serviceParam.getWebService();
        String resType = webService == null ? null : webService.getRespType();
        String result = (String) httpClientResult.getEntity();
        Integer code = httpClientResult.getCode();
        log.info("code:{},result:{}",code,result);
        result = XmlUtil.XmlTojson(result, resType);
        log.info("result-afterxml:{}",result);
        JSONObject jsonObject = new JSONObject();
        if(serviceParam.getRespParams().isHttpStatusCode()){
            if (result.startsWith("[")){
                //jsonArray
                List<JSONObject>  tmp = JSONArray.parseArray(result,JSONObject.class);
                jsonObject.put("null",tmp);
            } else {
                jsonObject = JSONObject.parseObject(result);
            }
            jsonObject.put("code",200);
            jsonObject.put("message","成功");
            log.info("解析后结果:" + jsonObject.toString());
            return HttpClientResult.build(code, jsonObject.toJSONString());
        }
        log.info("解析后结果:" + result);
        return HttpClientResult.build(code, result);
    }*/
}
