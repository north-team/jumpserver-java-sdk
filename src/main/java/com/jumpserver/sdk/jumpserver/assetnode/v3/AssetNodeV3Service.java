package com.jumpserver.sdk.jumpserver.assetnode.v3;

import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.model.assetgroup.AssetsNode;

/**
 * @author : houchen
 */
public interface AssetNodeV3Service {

    ActionResponse updateAssetsNode(String nodeId, AssetsNode node);
}
