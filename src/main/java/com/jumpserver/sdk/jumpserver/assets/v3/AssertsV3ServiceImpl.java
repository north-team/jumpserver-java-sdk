package com.jumpserver.sdk.jumpserver.assets.v3;

import com.alibaba.fastjson.JSON;
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
        return get(Asset.class, ClientConstants.ASSETS).executeList();
    }

    @Override
    public Asset update(Asset asset) {
        return null;
    }

    @Override
    public Asset create(Asset asset) {
        checkNotNull(asset);
        return post(Asset.class, uri(ClientConstants.ASSETS))
                .json(JSON.toJSONString(asset))
                .execute();
    }
}
