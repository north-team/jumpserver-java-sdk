package com.jumpserver.sdk.httpclient.build;

import com.google.common.base.Function;
import com.jumpserver.sdk.httpclient.request.HttpRequest;

import static com.jumpserver.sdk.common.ClientConstants.URI_SEP;

public class EndpointURIFunction implements Function<HttpRequest<?>, String> {
    @Override
    public String apply(HttpRequest<?> request) {
        if (request.getEndpoint().endsWith(URI_SEP) || request.getPath().startsWith(URI_SEP)) {
            return escape(request.getEndpoint() + request.getPath());
        }

        return escape(request.getEndpoint() + URI_SEP + request.getPath());
    }

    private String escape(String uri) {
        return uri.replaceAll(" ", "%20");
    }

}
