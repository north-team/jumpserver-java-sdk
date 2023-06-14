package com.jumpserver.sdk.builder;

import com.alibaba.fastjson.JSONObject;
import com.jumpserver.sdk.api.Apis;
import com.jumpserver.sdk.httpclient.build.Config;
import com.jumpserver.sdk.jumpserver.assets.v2.AssertsService;
import com.jumpserver.sdk.jumpserver.assets.v3.AssertsV3Service;
import com.jumpserver.sdk.jumpserver.luna.LunaService;
import com.jumpserver.sdk.jumpserver.org.OrgService;
import com.jumpserver.sdk.jumpserver.permissions.v2.PermissionService;
import com.jumpserver.sdk.jumpserver.permissions.v3.PermissionV3Service;
import com.jumpserver.sdk.jumpserver.users.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author yankaijun
 * @date 2018/10/16 上午9:16
 */
public class JMSClientImpl implements JMSClient {

    private ApiKey apiKey;
    private Config config;
    private String version;
    private Map<String, Object> headers;
    private static final Logger LOG = LoggerFactory.getLogger(JMSClientImpl.class);
    @SuppressWarnings("rawtypes")
    private static final ThreadLocal<JMSClientImpl> sessions = new ThreadLocal<>();

    @Override
    public UserService users() {
        return Apis.getUserServices();
    }

    @Override
    public AssertsService assets() {
        return Apis.getAssetsServices();
    }

    @Override
    public AssertsV3Service assetsV3() {
        return Apis.getAssetsV3Services();
    }

    @Override
    public OrgService orgs() {
        return Apis.getOrgServices();
    }

    @Override
    public LunaService luna() {
        return Apis.getLunaServices();
    }

    @Override
    public PermissionService permissions() {
        return Apis.getPermissionServices();
    }

    @Override
    public PermissionV3Service permissionsV3() {
        return Apis.getPermissionV3Services();
    }

    public static JMSClient createSession(ApiKey apiKey, Map<String, Object> headers, Config config) {
        return new JMSClientImpl(apiKey, headers, config);
    }

    private JMSClientImpl(ApiKey apiKey, Map<String, Object> headers, Config config) {
        this.headers = headers;
        this.config = config;
        this.apiKey = apiKey;
        if (LOG.isDebugEnabled()) {
            LOG.debug("创建client的对象：{}, header:{}", this, JSONObject.toJSONString(headers));
        }
        sessions.set(this);
    }

    public static JMSClientImpl getCurrent() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("重复使用client -->" + sessions.get());
        }
        return sessions.get();
    }

    @Override
    public ApiKey getApiKey() {
        return apiKey;
    }

    public Config getConfig() {
        if (config == null) {
            return Config.newConfig();
        }
        return this.config;
    }

    @Override
    public Map getHeaders() {
        return this.headers;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}


