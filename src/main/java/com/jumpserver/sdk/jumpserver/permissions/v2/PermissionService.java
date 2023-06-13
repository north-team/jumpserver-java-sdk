package com.jumpserver.sdk.jumpserver.permissions.v2;

import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.model.permission.AssetsPermission;

import java.util.List;

/**
 * @author yankaijun
 * @date 2018/10/16 上午10:34
 */
public interface PermissionService {

    List<AssetsPermission> list();

    AssetsPermission getAssetsPermission(String permissionId);

    AssetsPermission updateAssetsPermission(AssetsPermission assetspermission);

    AssetsPermission createAssetsPermission(AssetsPermission assetspermission);

    ActionResponse deleteAssetsPermission(String permissionId);

}
