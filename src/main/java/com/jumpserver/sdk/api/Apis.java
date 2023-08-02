package com.jumpserver.sdk.api;

import com.jumpserver.sdk.jumpserver.account.v3.AssetAccountService;
import com.jumpserver.sdk.jumpserver.assetnode.v3.AssetNodeV3Service;
import com.jumpserver.sdk.jumpserver.assets.v2.AssertsService;
import com.jumpserver.sdk.jumpserver.assets.v3.AssertsV3Service;
import com.jumpserver.sdk.jumpserver.luna.LunaService;
import com.jumpserver.sdk.jumpserver.luna.V3.LunaV3Service;
import com.jumpserver.sdk.jumpserver.org.OrgService;
import com.jumpserver.sdk.jumpserver.permissions.v2.PermissionService;
import com.jumpserver.sdk.jumpserver.permissions.v3.PermissionV3Service;
import com.jumpserver.sdk.jumpserver.role.v3.RoleService;
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

    public static AssetNodeV3Service getAssetNodeV3Services() {
        return get(AssetNodeV3Service.class);
    }

    public static PermissionService getPermissionServices() {
        return get(PermissionService.class);
    }

    public static PermissionV3Service getPermissionV3Services() {
        return get(PermissionV3Service.class);
    }

    public static LunaService getLunaServices() {
        return get(LunaService.class);
    }

    public static LunaV3Service getLunaV3Services() {
        return get(LunaV3Service.class);
    }

    public static OrgService getOrgServices() {
        return get(OrgService.class);
    }

    public static AssetAccountService getAssetAccountServices() {
        return get(AssetAccountService.class);
    }

    private static APIProvider initializeProvider() {
        DefaultAPIProvider p = new DefaultAPIProvider();
        p.initialize();
        return p;
    }

    public static RoleService getRoleServices() {
        return get(RoleService.class);
    }
}
