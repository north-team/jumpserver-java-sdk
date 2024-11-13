package com.jumpserver.sdk.jumpserver.account.v3;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.account.AssetAccount;
import com.jumpserver.sdk.model.account.AssetAccountRequest;
import com.jumpserver.sdk.model.account.PageResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author : houchen
 */
public class AssetAccountServiceImpl extends BaseJmsService implements AssetAccountService {

    private static Logger logger = LoggerFactory.getLogger(AssetAccountServiceImpl.class);

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
    public List<AssetAccount> list(String assetId) {
        return get(AssetAccount.class, ClientConstants.ASSET_ACCOUNT+ "?asset_id=" + assetId).executeList();
    }

    @Override
    public List<AssetAccount> listPage(){
        List<AssetAccount> allAccounts = new ArrayList<>();
        String requestUrl = ClientConstants.ASSET_ACCOUNT_PAGE;
        while (StringUtils.isNotBlank(requestUrl)) {
            PageResponse pageResponse = get(PageResponse.class, requestUrl).execute();
            allAccounts.addAll(pageResponse.getResults());
            requestUrl = pageResponse.getNext();
            if (StringUtils.isNotBlank(requestUrl) && requestUrl.contains(ClientConstants.BASE_URL)){
               // next =  http://XX.XX.XXX/api/v1/users/groups/?limit=15&offset=30
                requestUrl = requestUrl.substring(requestUrl.indexOf(ClientConstants.BASE_URL), requestUrl.length());
            }else {
                logger.warn("异常的 JumpServer 返回地址：{}", requestUrl);
                requestUrl = null;
            }
        }
        return allAccounts;
    }

    @Override
    public AssetAccount create(AssetAccountRequest asset) {
        checkNotNull(asset);
        checkNotNull(asset.getAsset());
        return post(AssetAccount.class, ClientConstants.ASSET_ACCOUNT).json(JSON.toJSONString(asset)).execute();
    }

    @Override
    public List<AssetAccount> createByAccountTemplate(List<AssetAccountRequest> assets) {
        checkNotNull(assets);
        return post(AssetAccount.class, ClientConstants.ASSET_ACCOUNT).json(JSON.toJSONString(assets)).executeList();
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
