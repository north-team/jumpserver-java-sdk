package com.jumpserver.sdk.builder;

import com.jumpserver.sdk.exceptions.AuthenticationException;
import com.jumpserver.sdk.httpclient.build.Config;

public interface IOSClientBuilder<T, R> {

    T withConfig(Config config);

    T credentials(String keyId, String keySecret);

    T endpoint(String endpoint);

    T header(String key, String value);

    R authenticate() throws AuthenticationException;

}
