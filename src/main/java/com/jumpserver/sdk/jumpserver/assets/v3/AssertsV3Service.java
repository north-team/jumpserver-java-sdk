package com.jumpserver.sdk.jumpserver.assets.v3;

import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.model.asset.v3.AssetRequest;
import com.jumpserver.sdk.model.asset.v3.Asset;
import com.jumpserver.sdk.model.asset.v3.DescribeAsset;

import java.util.List;

/**
 * @author : houchen
 */
public interface AssertsV3Service {

    List<Asset> getAsserts(DescribeAsset assetQuery);

    Asset update(AssetRequest asset);

    Asset create(AssetRequest asset);

    ActionResponse delete(String assetId);
}
