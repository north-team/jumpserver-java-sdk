package com.jumpserver.sdk.jumpserver.account.v3;

import com.jumpserver.sdk.model.account.ChangeSecretAutomationsRequest;

import java.util.List;

public interface ChangeSecretAutomationsService {

    List<ChangeSecretAutomationsService> list();

    ChangeSecretAutomationsService create(ChangeSecretAutomationsRequest changeSecretAutomationsRequest);

    ChangeSecretAutomationsService update(ChangeSecretAutomationsRequest changeSecretAutomationsRequest);

    void delete(String changeSecretAutomationsId);

}
