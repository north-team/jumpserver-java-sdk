package com.jumpserver.sdk.jumpserver.permissions.v3;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.permission.v3.AssetsPermission;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author yankaijun
 * @date 2018/10/16 上午10:34
 */
public class PermissionV3ServiceImpl extends BaseJmsService implements PermissionV3Service {
    @Override
    public List<com.jumpserver.sdk.model.permission.AssetsPermission> list() {
        return get(com.jumpserver.sdk.model.permission.AssetsPermission.class, uri(ClientConstants.ASSET_PERMISSIONS)).executeList();
    }

    @Override
    public com.jumpserver.sdk.model.permission.AssetsPermission getAssetsPermission(String permissionId) {
        checkNotNull(permissionId);
        return get(com.jumpserver.sdk.model.permission.AssetsPermission.class, ClientConstants.ASSET_PERMISSIONS, permissionId, "/").execute();
    }

    @Override
    public com.jumpserver.sdk.model.permission.AssetsPermission updateAssetsPermission(AssetsPermission assetspermission) {
        checkNotNull(assetspermission);
        return put(com.jumpserver.sdk.model.permission.AssetsPermission.class, ClientConstants.ASSET_PERMISSIONS, assetspermission.getId(), "/").json(JSON.toJSONString(assetspermission)).execute();
    }

    @Override
    public com.jumpserver.sdk.model.permission.AssetsPermission createAssetsPermission(AssetsPermission assetspermission) {
        checkNotNull(assetspermission);
        return post(com.jumpserver.sdk.model.permission.AssetsPermission.class, uri(ClientConstants.ASSET_PERMISSIONS))
                .json(JSON.toJSONString(assetspermission))
                .execute();
    }

    @Override
    public ActionResponse deleteAssetsPermission(String permissionId) {
        checkNotNull(permissionId);
        return deleteWithResponse(ClientConstants.ASSET_PERMISSIONS, permissionId, "/").execute();
    }
}
