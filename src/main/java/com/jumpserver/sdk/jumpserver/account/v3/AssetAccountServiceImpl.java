package com.jumpserver.sdk.jumpserver.account.v3;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.account.AssetAccount;
import com.jumpserver.sdk.model.account.AssetAccountRequest;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author : houchen
 */
public class AssetAccountServiceImpl extends BaseJmsService implements AssetAccountService {
    @Override
    public AssetAccount getAccountSecret(String accountId) {
        checkNotNull(accountId);
        return get(AssetAccount.class, ClientConstants.ASSET_ACCOUNT_SECRET, accountId, "/").execute();
    }

    @Override
    public List<AssetAccount> list() {
        return get(AssetAccount.class, ClientConstants.ASSET_ACCOUNT).executeList();
    }

    @Override
    public AssetAccount create(AssetAccountRequest asset) {
        checkNotNull(asset);
        checkNotNull(asset.getAsset());
        return post(AssetAccount.class, ClientConstants.ASSET_ACCOUNT).json(JSON.toJSONString(asset)).execute();
    }

    @Override
    public AssetAccount update(AssetAccountRequest assetAccount) {
        checkNotNull(assetAccount);
        return patch(AssetAccount.class, ClientConstants.ASSET_ACCOUNT, assetAccount.getId(), "/").json(JSON.toJSONString(assetAccount)).execute();
    }

    @Override
    public void delete(String assetAccountId) {
        checkNotNull(assetAccountId);
        delete(null, ClientConstants.ASSET_ACCOUNT, assetAccountId, "/").execute();
    }
}
