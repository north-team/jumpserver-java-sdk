package com.jumpserver.sdk.jumpserver.assetnode.v3;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.assetgroup.AssetsNode;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author : houchen
 */
public class AssetNodeV3ServiceImpl extends BaseJmsService implements AssetNodeV3Service {

    @Override
    public ActionResponse updateAssetsNode(String nodeId, AssetsNode assetsNode) {
        checkNotNull(nodeId);
        return patchWithResponse(ClientConstants.NODE_UPDATE.replace("{id}", nodeId))
                .json(JSON.toJSONString(assetsNode)).execute();
    }
}
