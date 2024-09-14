package com.jumpserver.sdk.common;

import com.google.common.base.Joiner;
import com.jumpserver.sdk.builder.JMSClientImpl;
import com.jumpserver.sdk.common.eunms.PermissionExecInfoEnum;
import com.jumpserver.sdk.exceptions.ClientResponseException;
import com.jumpserver.sdk.exceptions.JmsException;
import com.jumpserver.sdk.httpclient.executor.HttpExecutor;
import com.jumpserver.sdk.httpclient.request.HttpRequest;
import com.jumpserver.sdk.httpclient.response.HttpResponse;
import com.jumpserver.sdk.model.common.ModelEntity;
import org.apache.commons.lang.StringUtils;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class BaseJmsService {

    protected BaseJmsService() {
    }

    protected <R> Invocation<R> get(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.GET);
    }

    protected <R> Invocation<R> getList(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.GET);
    }

    protected <R> Invocation<R> post(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.POST);
    }

    protected <R> Invocation<ActionResponse> postWithResponse(String... path) {
        return builder(ActionResponse.class, path, HttpMethod.POST);
    }

    protected <R> Invocation<R> put(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.PUT);
    }

    protected <R> Invocation<R> patch(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.PATCH);
    }

    protected <R> Invocation<ActionResponse> patchWithResponse(String... path) {
        return builder(ActionResponse.class, path, HttpMethod.PATCH);
    }

    protected <R> Invocation<R> delete(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.DELETE);
    }

    protected <R> Invocation<ActionResponse> deleteWithResponse(String... path) {
        return builder(ActionResponse.class, path, HttpMethod.DELETE);
    }

    protected <R> Invocation<R> head(Class<R> returnType, String... path) {
        return builder(returnType, path, HttpMethod.HEAD);
    }

    protected <R> Invocation<R> request(HttpMethod method, Class<R> returnType, String path) {
        return builder(returnType, path, method);
    }

    protected String uri(String path, Object... params) {
        if (params.length == 0) {
            return path;
        }
        return String.format(path, params);
    }

    protected String replace(String path, String id) {
        if (path.length() == 0 || id.length() == 0) {
            return path;
        }
        return path.replace("{id}", id);
    }

    private <R> Invocation<R> builder(Class<R> returnType, String[] path, HttpMethod method) {
        return builder(returnType, Joiner.on("").join(path), method);
    }

    @SuppressWarnings("rawtypes")
    private <R> Invocation<R> builder(Class<R> returnType, String path, HttpMethod method) {
        JMSClientImpl ses = JMSClientImpl.getCurrent();
        if (ses == null) {
            throw new JmsException("Unable to retrieve current session. Please verify thread has a current session available.");
        }
        HttpRequest.RequestBuilder<R> req = HttpRequest.builder(returnType).config(ses.getConfig()).endpoint(ses.getApiKey().getEndpoint()).method(method).path(path);
        //取了验证那里的header信息
        Map headers = ses.getHeaders();
        // 签名后的头部
        headers.putAll(HttpsigUtil.getSignHeaders(ses.getApiKey(), method.name(), path));
        if (headers != null && headers.size() > 0) {
            return new Invocation<R>(req).headers(headers);
        } else {
            return new Invocation<R>(req);
        }
    }

    /***
     * 配置请求、执行请求
     * @param <R>
     */
    protected static class Invocation<R> {
        HttpRequest.RequestBuilder<R> req;

        protected Invocation(HttpRequest.RequestBuilder<R> req) {
            this.req = req;
        }

        public Invocation<R> param(String name, Object value) {
            req.queryParam(name, value);
            return this;
        }

        public Invocation<R> params(Map<String, ? extends Object> params) {
            if (params != null) {
                for (String name : params.keySet()) {
                    req.queryParam(name, params.get(name));
                }
            }
            return this;
        }

        public Invocation<R> entity(ModelEntity entity) {
            req.entity(entity);
            return this;
        }

        public Invocation<R> contentType(String contentType) {
            req.contentType(contentType);
            return this;
        }

        public Invocation<R> json(String json) {
            req.json(json);
            return this;
        }

        public Invocation<R> headers(Map<String, ? extends Object> headers) {
            if (headers != null) {
                req.headers(headers);
            }
            return this;
        }

        public Invocation<R> header(String name, Object value) {
            req.header(name, value);
            return this;
        }

        public R execute() {
            HttpRequest<R> request = req.build();
            HttpResponse res = HttpExecutor.create().execute(request);
            // 处理 403 异常
            handler403(request.getPath(), res);
            return res.getEntity(request.getReturnType());
        }

        public List<R> executeList() {
            HttpRequest<R> request = req.build();
            HttpResponse res = HttpExecutor.create().execute(request);
            // 处理 403 异常
            handler403(request.getPath(), res);
            if (res == null) {
                return new ArrayList<>();
            }
            return res.getEntityList(request.getReturnType());
        }

        private void handler403(String requestPath, HttpResponse res) {
            if (StringUtils.isEmpty(requestPath) || Objects.isNull(res) || HttpURLConnection.HTTP_FORBIDDEN != res.getStatus()) {
                return;
            }
            throw new ClientResponseException(PermissionExecInfoEnum.getPermissionExecInfo(requestPath));
        }

    }
}
