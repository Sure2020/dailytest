package com.example.dailytest.shenzhenalarm.timestamp;/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : MyBaseApiClientBuilder
 * Date Created : 2020-04-24
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-04-24       w15021     xxx
 * --------------------------------------------------------------------
 */

/*
package com.example.shenzhenalarm.timestamp;

import com.ctg.ag.sdk.core.BaseApiClient;
import com.ctg.ag.sdk.core.constant.Scheme;
import com.ctg.ag.sdk.core.model.BuilderParams;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class MyBaseApiClientBuilder<Subclass extends MyBaseApiClientBuilder<?, ?>, TypeToBuild extends MyBaseApiClient> {
    private Random random = new Random();
    private BuilderParams params = new BuilderParams();

    public MyBaseApiClientBuilder() {
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> appKey(String appKey) {
        this.params.setAppKey(appKey);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> appSecret(String appSecret) {
        this.params.setAppSecret(appSecret);
        return this;
    }

    */
/** @deprecated *//*

    @Deprecated
    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> maxIdleConnections(int maxIdleConnections) {
        this.params.setMaxIdleConnections(maxIdleConnections);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> maxIdleTimeMills(long maxIdleTimeMillis) {
        this.params.setMaxIdleTimeMillis(maxIdleTimeMillis);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> keepAliveDurationMillis(long keepAliveDurationMillis) {
        this.params.setKeepAliveDurationMillis(keepAliveDurationMillis);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> connectionTimeoutMillis(long connectionTimeoutMillis) {
        this.params.setConnectionTimeoutMillis(connectionTimeoutMillis);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> readTimeoutMillis(long readTimeoutMillis) {
        this.params.setReadTimeoutMillis(readTimeoutMillis);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> writeTimeoutMillis(long writeTimeoutMillis) {
        this.params.setWriteTimeoutMillis(writeTimeoutMillis);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> executorService(ExecutorService executorService) {
        this.params.setExecutorService(executorService);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> sslSocketFactory(SSLSocketFactory sslSocketFactory) {
        this.params.setSslSocketFactory(sslSocketFactory);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> maxRequests(int maxRequests) {
        this.params.setMaxRequests(maxRequests);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> maxRequestsPerHost(int maxRequestsPerHost) {
        this.params.setMaxRequestsPerHost(maxRequestsPerHost);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> idleCallback(Runnable idleCallback) {
        this.params.setIdleCallback(idleCallback);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> x509TrustManager(X509TrustManager x509TrustManager) {
        return this.x509TrustManagers(new X509TrustManager[]{x509TrustManager});
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> x509TrustManagers(X509TrustManager[] x509TrustManagers) {
        this.params.setX509TrustManagers(x509TrustManagers);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> keyManagers(KeyManager[] keyManagers) {
        this.params.setKeyManagers(keyManagers);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> secureRandom(SecureRandom secureRandom) {
        this.params.setSecureRandom(secureRandom);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> hostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.params.setHostnameVerifier(hostnameVerifier);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> setExtParams(String key, Object value) {
        this.params.setExtParam(key, value);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> scheme(Scheme scheme) {
        this.params.setScheme(scheme);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> sandbox(boolean sandbox) {
        this.params.setSandbox(sandbox);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> host(String host) {
        this.params.setHost(host);
        return this;
    }

    public com.example.shenzhenalarm.timestamp.MyBaseApiClientBuilder<Subclass, TypeToBuild> server(String server) {
        this.params.setServer(server);
        return this;
    }

    public final TypeToBuild build() {
        if (this.params.getScheme() == null) {
            this.params.setScheme(Scheme.HTTP);
        }

        boolean sandbox;
        if (this.params.getHost() == null) {
            sandbox = this.params.isSandbox();
            boolean ssl = this.params.getScheme() == Scheme.HTTPS;
            if (!sandbox && !ssl) {
                this.params.setHost(this.httpHost());
            } else if (sandbox && ssl) {
                this.params.setHost(this.sandboxSslHost());
            } else if (!sandbox && ssl) {
                this.params.setHost(this.sslHost());
            } else if (sandbox && !ssl) {
                this.params.setHost(this.sandboxHttpHost());
            }
        }

        if (this.params.getServer() == null) {
            sandbox = this.params.getScheme() == Scheme.HTTPS;
            if (sandbox) {
                this.params.setServer(this.serverSslHost());
            } else {
                this.params.setServer(this.serverHost());
            }
        }

        TypeToBuild apiClient = this.build(this.params);
        return apiClient;
    }

    protected TypeToBuild build(BuilderParams params) {
        */
/*return new BaseApiClient(params) {
        };*//*

        return (TypeToBuild)new MyBaseApiClient(params) {
        };
        */
/*return new MyBaseApiClient(params) {
        };*//*

    }

    protected String serverHost() {
        throw new UnsupportedOperationException();
    }

    protected String serverSslHost() {
        throw new UnsupportedOperationException();
    }

    protected String httpHost() {
        throw new UnsupportedOperationException();
    }

    protected String sslHost() {
        throw new UnsupportedOperationException();
    }

    protected String sandboxHttpHost() {
        throw new UnsupportedOperationException();
    }

    protected String sandboxSslHost() {
        throw new UnsupportedOperationException();
    }

    protected String nextHost(String[] hosts) {
        if (hosts.length == 0) {
            throw new UnsupportedOperationException("No available host");
        } else {
            return hosts[this.random.nextInt(hosts.length)];
        }
    }
}
*/
