package com.jumpserver.sdk.jumpserver.assetnode.v3;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.assetgroup.AssetsNode;
import com.jumpserver.sdk.model.user.User;

import java.util.List;

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

    @Override
    public List<AssetsNode> list() {
        return get(AssetsNode.class, uri(ClientConstants.NODES)).header(ClientConstants.X_JMS_ORG, "00000000-0000-0000-0000-000000000000").executeList();
    }

}
