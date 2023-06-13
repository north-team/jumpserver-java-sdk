package com.jumpserver.sdk.api;

public interface APIProvider {

    void initialize();

    <T> T get(Class<T> api);
}
