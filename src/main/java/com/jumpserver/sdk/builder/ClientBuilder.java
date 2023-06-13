package com.jumpserver.sdk.builder;

import com.jumpserver.sdk.httpclient.build.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yankaijun
 * @date 2018/10/16 上午9:10
 */
public class ClientBuilder implements IOSClientBuilder<ClientBuilder, JMSClient> {

    String endpoint;
    Config config;
    String keyId;
    String keySecret;
    Map<String, Object> headers = new HashMap<>();

    @Override
    public ClientBuilder withConfig(Config config) {
        this.config = config;
        return this;
    }

    @Override
    public ClientBuilder credentials(String keyId, String keySecret) {
        this.keyId = keyId;
        this.keySecret = keySecret;
        return this;
    }

    @Override
    public ClientBuilder endpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    @Override
    public ClientBuilder header(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    @Override
    public JMSClient authenticate() {
        return OSAuthenticator.invoke(endpoint, keyId, keySecret, headers, config);
    }

}
