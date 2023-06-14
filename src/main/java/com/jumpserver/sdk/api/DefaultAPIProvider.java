package com.jumpserver.sdk.api;

import com.google.common.collect.Maps;
import com.jumpserver.sdk.jumpserver.assets.v2.AssertsService;
import com.jumpserver.sdk.jumpserver.assets.v2.AssertsServiceImpl;
import com.jumpserver.sdk.jumpserver.assets.v3.AssertsV3Service;
import com.jumpserver.sdk.jumpserver.assets.v3.AssertsV3ServiceImpl;
import com.jumpserver.sdk.jumpserver.luna.LunaService;
import com.jumpserver.sdk.jumpserver.luna.LunaServiceImpl;
import com.jumpserver.sdk.jumpserver.org.OrgService;
import com.jumpserver.sdk.jumpserver.org.OrgServiceImpl;
import com.jumpserver.sdk.jumpserver.permissions.v2.PermissionService;
import com.jumpserver.sdk.jumpserver.permissions.v2.PermissionServiceImpl;
import com.jumpserver.sdk.jumpserver.permissions.v3.PermissionV3Service;
import com.jumpserver.sdk.jumpserver.permissions.v3.PermissionV3ServiceImpl;
import com.jumpserver.sdk.jumpserver.users.UserService;
import com.jumpserver.sdk.jumpserver.users.UserServiceImpl;

import java.util.Map;

public class DefaultAPIProvider implements APIProvider {

    private static final Map<Class<?>, Class<?>> bindings = Maps.newHashMap();
    private static final Map<Class<?>, Object> instances = Maps.newConcurrentMap();

    @Override
    public void initialize() {
        bind(UserService.class, UserServiceImpl.class);
        bind(PermissionService.class, PermissionServiceImpl.class);
        bind(PermissionV3Service.class, PermissionV3ServiceImpl.class);
        bind(LunaService.class, LunaServiceImpl.class);
        bind(OrgService.class, OrgServiceImpl.class);
        bind(AssertsService.class, AssertsServiceImpl.class);
        bind(AssertsV3Service.class, AssertsV3ServiceImpl.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(Class<T> api) {
        if (instances.containsKey(api)) {
            return (T) instances.get(api);
        }

        if (bindings.containsKey(api)) {
            try {
                T impl = (T) bindings.get(api).newInstance();
                instances.put(api, impl);
                return impl;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void bind(Class<?> api, Class<?> impl) {
        bindings.put(api, impl);
    }
}
