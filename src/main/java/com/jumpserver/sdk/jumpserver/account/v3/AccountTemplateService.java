package com.jumpserver.sdk.jumpserver.account.v3;

import com.jumpserver.sdk.model.account.AccountTemplate;
import com.jumpserver.sdk.model.account.AccountTemplateRequest;

import java.util.List;

public interface AccountTemplateService {
    List<AccountTemplate> list();
    AccountTemplate create(AccountTemplateRequest request);
    void delete(String accountTemplateId);
}
