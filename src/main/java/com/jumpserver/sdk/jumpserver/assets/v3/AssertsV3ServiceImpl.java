package com.jumpserver.sdk.jumpserver.assets.v3;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.asset.v3.Asset;
import com.jumpserver.sdk.model.asset.v3.DescribeAsset;

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
    public Asset update(Asset asset) {
        checkNotNull(asset);
        return put(Asset.class, ClientConstants.ASSETSV3, asset.getId(), "/").json(JSON.toJSONString(asset)).execute();
    }

    @Override
    public Asset create(Asset asset) {
        checkNotNull(asset);
        return post(Asset.class, uri(ClientConstants.ASSETSV3, "?platform=", asset.getPlatform().getPk()))
                .json(JSON.toJSONString(asset))
                .execute();
    }

    @Override
    public ActionResponse delete(String assetId) {
        checkNotNull(assetId);
        return deleteWithResponse(ClientConstants.ASSETSV3, assetId, "/").execute();
    }
}
