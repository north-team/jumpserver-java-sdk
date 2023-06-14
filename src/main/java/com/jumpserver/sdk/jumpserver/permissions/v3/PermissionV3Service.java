package com.jumpserver.sdk.jumpserver.permissions.v3;

import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.model.permission.v3.AssetsPermission;

import java.util.List;

/**
 * @author tangyunhao
 * @date 2023-0614
 */
public interface PermissionV3Service {

    List<com.jumpserver.sdk.model.permission.AssetsPermission> list();

    com.jumpserver.sdk.model.permission.AssetsPermission getAssetsPermission(String permissionId);

    com.jumpserver.sdk.model.permission.AssetsPermission updateAssetsPermission(AssetsPermission assetspermission);

    com.jumpserver.sdk.model.permission.AssetsPermission createAssetsPermission(AssetsPermission assetspermission);

    ActionResponse deleteAssetsPermission(String permissionId);

}
