package com.jumpserver.sdk.jumpserver.account.v3;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.account.ChangeSecretAutomation;
import com.jumpserver.sdk.model.account.ChangeSecretAutomationRequest;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class ChangeSecretAutomationServiceImpl extends BaseJmsService  implements ChangeSecretAutomationService {

    @Override
    public List<ChangeSecretAutomation> list() {
        return get(ChangeSecretAutomation.class, ClientConstants.CHANGE_SECRET_AUTOMATIONS).executeList();
    }

    @Override
    public ChangeSecretAutomation create(ChangeSecretAutomationRequest changeSecretAutomationsRequest) {
        checkNotNull(changeSecretAutomationsRequest);
        return post(ChangeSecretAutomation.class, ClientConstants.CHANGE_SECRET_AUTOMATIONS).json(JSON.toJSONString(changeSecretAutomationsRequest)).execute();
    }

    @Override
    public ChangeSecretAutomation update(ChangeSecretAutomationRequest changeSecretAutomationsRequest) {
        checkNotNull(changeSecretAutomationsRequest);
        return patch(ChangeSecretAutomation.class, ClientConstants.CHANGE_SECRET_AUTOMATIONS).json(JSON.toJSONString(changeSecretAutomationsRequest)).execute();

    }

    @Override
    public void delete(String changeSecretAutomationsId) {
        checkNotNull(changeSecretAutomationsId);
        delete(null, ClientConstants.CHANGE_SECRET_AUTOMATIONS, changeSecretAutomationsId, "/").execute();
    }
}
