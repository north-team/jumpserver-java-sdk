package com.jumpserver.sdk.jumpserver.permissions.v3;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.jumpserver.permissions.v3.Request.AssetsPermissionRequest;
import com.jumpserver.sdk.model.permission.v3.AssetsPermission;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author yankaijun
 * @date 2018/10/16 上午10:34
 */
public class PermissionV3ServiceImpl extends BaseJmsService implements PermissionV3Service {
    @Override
    public List<AssetsPermission> list() {
        return get(AssetsPermission.class, uri(ClientConstants.ASSET_PERMISSIONS)).executeList();
    }

    @Override
    public AssetsPermission getAssetsPermission(String permissionId) {
        checkNotNull(permissionId);
        return get(AssetsPermission.class, ClientConstants.ASSET_PERMISSIONS, permissionId, "/").execute();
    }

    @Override
    public AssetsPermission updateAssetsPermission(AssetsPermissionRequest assetspermission) {
        checkNotNull(assetspermission);
        return put(AssetsPermission.class, ClientConstants.ASSET_PERMISSIONS, assetspermission.getId(), "/").json(JSON.toJSONString(assetspermission)).execute();
    }

    @Override
    public AssetsPermission createAssetsPermission(AssetsPermissionRequest assetspermission) {
        checkNotNull(assetspermission);
        return post(AssetsPermission.class, uri(ClientConstants.ASSET_PERMISSIONS))
                .json(JSON.toJSONString(assetspermission))
                .execute();
    }

    @Override
    public ActionResponse deleteAssetsPermission(String permissionId) {
        checkNotNull(permissionId);
        return deleteWithResponse(ClientConstants.ASSET_PERMISSIONS, permissionId, "/").execute();
    }

    @Override
    public void createPermissionAsset(String permissionId, String assetId) {
        checkNotNull(permissionId);
        checkNotNull(assetId);
        JSONObject param = new JSONObject();
        param.put("assetpermission", permissionId);
        param.put("asset", assetId);
        delete(AssetsPermission.class, uri(ClientConstants.PERMISSION_ASSET_RELATION))
                .param("assetpermission", permissionId)
                .param("asset", assetId)
                .execute();
    }

    @Override
    public void removePermissionAsset(String permissionId, String assetId) {
        checkNotNull(permissionId);
        checkNotNull(assetId);
        delete(AssetsPermission.class, uri(ClientConstants.PERMISSION_ASSET_RELATION))
                .param("assetpermission", permissionId)
                .param("asset", assetId)
                .execute();
    }

    @Override
    public void createPermissionUserGroup(String permissionId, String userGroupId) {
        checkNotNull(permissionId);
        checkNotNull(userGroupId);
        JSONObject permission = new JSONObject();
        permission.put("assetpermission", permissionId);
        permission.put("usergroup", userGroupId);
        JSONArray param = new JSONArray();
        param.add(permission);
        post(AssetsPermission.class, uri(ClientConstants.PERMISSION_USER_GROUP_RELATION))
                .json(JSON.toJSONString(param))
                .executeList();
    }

    @Override
    public void removePermissionUserGroup(String permissionId, String userGroupId) {
        checkNotNull(permissionId);
        checkNotNull(userGroupId);
        delete(AssetsPermission.class, ClientConstants.PERMISSION_USER_GROUP_RELATION, "?assetpermission=", permissionId,
                "&usergroup=", userGroupId)
                .execute();
    }

    @Override
    public void createPermissionUser(String permissionId, String userId) {
        checkNotNull(permissionId);
        checkNotNull(userId);
        JSONObject permission = new JSONObject();
        permission.put("assetpermission", permissionId);
        permission.put("user", userId);
        JSONArray param = new JSONArray();
        param.add(permission);
        post(AssetsPermission.class, ClientConstants.PERMISSION_USER_RELATION)
                .json(JSON.toJSONString(param))
                .executeList();
    }

    @Override
    public void removePermissionUser(String permissionId, String userId) {
        checkNotNull(permissionId);
        checkNotNull(userId);
        delete(AssetsPermission.class, ClientConstants.PERMISSION_USER_RELATION, "?assetpermission=", permissionId,
                "&usergroup=", userId)
                .execute();
    }
}
