package com.jumpserver.sdk.jumpserver.account.v3;

import com.jumpserver.sdk.model.account.AssetAccount;
import com.jumpserver.sdk.model.account.AssetAccountRequest;

/**
 * @author : houchen
 */
public interface AssetAccountService {

    AssetAccount getAccountSecret(String accountId);

    AssetAccount update(AssetAccountRequest asset);
}
