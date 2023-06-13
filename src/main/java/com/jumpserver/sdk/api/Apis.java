package com.jumpserver.sdk.api;

import com.jumpserver.sdk.jumpserver.assets.v2.AssertsService;
import com.jumpserver.sdk.jumpserver.assets.v3.AssertsV3Service;
import com.jumpserver.sdk.jumpserver.luna.LunaService;
import com.jumpserver.sdk.jumpserver.org.OrgService;
import com.jumpserver.sdk.jumpserver.permissions.v2.PermissionService;
import com.jumpserver.sdk.jumpserver.users.UserService;

public class Apis {

    private static final APIProvider provider = initializeProvider();

    public static <T> T get(Class<T> api) {
        return provider.get(api);
    }

    public static UserService getUserServices() {
        return get(UserService.class);
    }

    public static AssertsService getAssetsServices() {
        return get(AssertsService.class);
    }

    public static AssertsV3Service getAssetsV3Services() {
        return get(AssertsV3Service.class);
    }

    public static PermissionService getPermissionServices() {
        return get(PermissionService.class);
    }

    public static LunaService getLunaServices() {
        return get(LunaService.class);
    }

    public static OrgService getOrgServices() {
        return get(OrgService.class);
    }

    private static APIProvider initializeProvider() {
        DefaultAPIProvider p = new DefaultAPIProvider();
        p.initialize();
        return p;
    }

}
