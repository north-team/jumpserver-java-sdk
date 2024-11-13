package com.jumpserver.sdk.jumpserver.account.v3;

import com.jumpserver.sdk.model.account.AssetAccount;
import com.jumpserver.sdk.model.account.AssetAccountRequest;

import java.util.List;

/**
 * @author : houchen
 */
public interface AssetAccountService {

    AssetAccount getAccountSecret(String accountId);

    List<AssetAccount> list();

    List<AssetAccount> list(String assetId);

    List<AssetAccount> listPage();

    AssetAccount create(AssetAccountRequest asset);

    List<AssetAccount> createByAccountTemplate(List<AssetAccountRequest> assets);

    AssetAccount update(AssetAccountRequest asset);

    void delete(String assetAccountId);

}
