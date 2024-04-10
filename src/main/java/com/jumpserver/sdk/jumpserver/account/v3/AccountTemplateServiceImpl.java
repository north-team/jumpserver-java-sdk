package com.jumpserver.sdk.jumpserver.account.v3;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.account.AccountTemplate;
import com.jumpserver.sdk.model.account.AccountTemplateRequest;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class AccountTemplateServiceImpl extends BaseJmsService implements AccountTemplateService{

    @Override
    public List<AccountTemplate> list() {
        return get(AccountTemplate.class, ClientConstants.ACCOUNT_TEMPLATE).executeList();
    }

    @Override
    public AccountTemplate create(AccountTemplateRequest request) {
        checkNotNull(request);
        return post(AccountTemplate.class, ClientConstants.ACCOUNT_TEMPLATE).json(JSON.toJSONString(request)).execute();
    }

    @Override
    public void delete(String accountTemplateId) {
        checkNotNull(accountTemplateId);
        delete(null, ClientConstants.ACCOUNT_TEMPLATE, accountTemplateId, "/").execute();
    }
}
