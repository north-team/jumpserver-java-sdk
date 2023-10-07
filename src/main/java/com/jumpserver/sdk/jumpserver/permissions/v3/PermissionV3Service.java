package com.jumpserver.sdk.jumpserver.permissions.v3;

import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.jumpserver.permissions.v3.Request.AssetsPermissionRequest;
import com.jumpserver.sdk.model.permission.v3.AssetsPermission;

import java.util.List;

/**
 * @author tangyunhao
 * @date 2023-0614
 */
public interface PermissionV3Service {

    List<AssetsPermission> list();

    AssetsPermission getAssetsPermission(String permissionId);

    AssetsPermission updateAssetsPermission(AssetsPermissionRequest assetsPermissionRequest);

    AssetsPermission createAssetsPermission(AssetsPermissionRequest assetsPermissionRequest);

    ActionResponse deleteAssetsPermission(String permissionId);

    void createPermissionAsset(String permissionId, String assetId);

    void removePermissionAsset(String permissionId, String assetId);

    void createPermissionUserGroup(String permissionId, String userGroupId);

    void removePermissionUserGroup(String permissionId, String userGroupId);

    void createPermissionUser(String permissionId, String userId);

    void removePermissionUser(String permissionId, String userId);

}
