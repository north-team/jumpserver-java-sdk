package com.jumpserver.sdk.jumpserver.account.v3;

import com.jumpserver.sdk.model.account.ChangeSecretAutomation;
import com.jumpserver.sdk.model.account.ChangeSecretAutomationRequest;

import java.util.List;

public interface ChangeSecretAutomationService {

    List<ChangeSecretAutomation> list();

    ChangeSecretAutomation create(ChangeSecretAutomationRequest changeSecretAutomationsRequest);

    ChangeSecretAutomation get(String changeSecretAutomationsId);

    ChangeSecretAutomation update(ChangeSecretAutomationRequest changeSecretAutomationsRequest);

    void delete(String changeSecretAutomationsId);

    void addAsset(String changeSecretAutomationsId, List<String> assetIds);

    void removeAsset(String changeSecretAutomationsId, List<String> assetIds);

}
