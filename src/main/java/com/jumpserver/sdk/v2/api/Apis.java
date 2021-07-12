package com.jumpserver.sdk.v2.api;

import com.jumpserver.sdk.v2.jumpserver.assets.AssertsService;
import com.jumpserver.sdk.v2.jumpserver.luna.LunaService;
import com.jumpserver.sdk.v2.jumpserver.org.OrgService;
import com.jumpserver.sdk.v2.jumpserver.permissions.PermissionService;
import com.jumpserver.sdk.v2.jumpserver.users.UserService;
import com.jumpserver.sdk.v2.jumpserver.xpack.CloudService;

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

    public static PermissionService getPermissionServices() {
        return get(PermissionService.class);
    }

    public static LunaService getLunaServices() {
        return get(LunaService.class);
    }

    public static CloudService getCloudServices() {
        return get(CloudService.class);
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
