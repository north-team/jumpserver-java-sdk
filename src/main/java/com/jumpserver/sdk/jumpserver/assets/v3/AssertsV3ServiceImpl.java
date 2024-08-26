package com.jumpserver.sdk.jumpserver.assets.v3;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.asset.v3.AssetRequest;
import com.jumpserver.sdk.model.asset.v3.Asset;
import com.jumpserver.sdk.model.asset.v3.DescribeAsset;
import com.jumpserver.sdk.model.asset.v3.Platform;
import com.jumpserver.sdk.model.permission.v3.AssetsPermission;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author : houchen
 */
public class AssertsV3ServiceImpl extends BaseJmsService implements AssertsV3Service {
    @Override
    public List<com.jumpserver.sdk.model.asset.v3.Asset> getAsserts(DescribeAsset assetQuery) {
        return get(Asset.class, ClientConstants.ASSETSV3).executeList();
    }

    @Override
    public Asset update(AssetRequest assetRequest) {
        checkNotNull(assetRequest);
        return put(Asset.class, ClientConstants.ASSETSV3, assetRequest.getId(), "/").json(JSON.toJSONString(assetRequest)).execute();
    }

    @Override
    public Asset create(AssetRequest assetRequest) {
        checkNotNull(assetRequest);
        return post(Asset.class, uri(ClientConstants.ASSETSV3, "?platform=", assetRequest.getPlatform()))
                .json(JSON.toJSONString(assetRequest))
                .execute();
    }

    @Override
    public ActionResponse delete(String assetId) {
        checkNotNull(assetId);
        return deleteWithResponse(ClientConstants.ASSETSV3, assetId, "/").execute();
    }

    @Override
    public List<Platform> listPlatforms() {
        return get(Platform.class, ClientConstants.PLATFORM).executeList();
    }

    @Override
    public List<AssetsPermission> getPermissionsWithAssets(String assetId,String orgId) {
        checkNotNull(assetId);
        return get(AssetsPermission.class, uri(ClientConstants.PERMISSION_WITH_ASSET, assetId))
                .header(ClientConstants.X_JMS_ORG, orgId)
                .executeList();
    }
}
