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

    AssetAccount create(AssetAccountRequest asset);

    AssetAccount update(AssetAccountRequest asset);

    void delete(String assetAccountId);

}
