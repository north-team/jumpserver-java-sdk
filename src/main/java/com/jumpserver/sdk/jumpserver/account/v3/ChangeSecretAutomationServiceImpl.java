package com.jumpserver.sdk.jumpserver.account.v3;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.account.ChangeSecretAutomation;
import com.jumpserver.sdk.model.account.ChangeSecretAutomationRequest;

import java.util.*;
import java.util.stream.Collectors;

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
    public ChangeSecretAutomation get(String changeSecretAutomationsId) {
        String url = ClientConstants.CHANGE_SECRET_AUTOMATIONS_DETAIL.replace("{id}", changeSecretAutomationsId);
        return get(ChangeSecretAutomation.class, url).execute();
    }

    @Override
    public ChangeSecretAutomation update(ChangeSecretAutomationRequest changeSecretAutomationsRequest) {
        checkNotNull(changeSecretAutomationsRequest);
        String url = ClientConstants.CHANGE_SECRET_AUTOMATIONS_DETAIL.replace("{id}", changeSecretAutomationsRequest.getId());
        return patch(ChangeSecretAutomation.class, url).json(JSON.toJSONString(changeSecretAutomationsRequest)).execute();
    }

    @Override
    public void delete(String changeSecretAutomationsId) {
        checkNotNull(changeSecretAutomationsId);
        delete(null, ClientConstants.CHANGE_SECRET_AUTOMATIONS, changeSecretAutomationsId, "/").execute();
    }

    @Override
    public void addAsset(String changeSecretAutomationsId, List<String> assetIds) {
        ChangeSecretAutomation changeSecretAutomation = get(changeSecretAutomationsId);
        if (Objects.isNull(changeSecretAutomation)) {
            return;
        }
        Set<String> assetIdSet = Optional.ofNullable(changeSecretAutomation.getAssets())
                .map(e -> e.stream().map(ChangeSecretAutomation.AssetDTO::getId).collect(Collectors.toSet()))
                .orElseGet(HashSet::new);

        assetIdSet.addAll(assetIds);

        String url = ClientConstants.CHANGE_SECRET_AUTOMATIONS_DETAIL.replace("{id}", changeSecretAutomationsId);
        HashMap<String, Object> req = new HashMap<>();
        req.put("assets", assetIdSet);
        patch(ChangeSecretAutomation.class, url).json(JSON.toJSONString(req)).execute();
    }

    @Override
    public void removeAsset(String changeSecretAutomationsId, List<String> assetIds) {
        ChangeSecretAutomation changeSecretAutomation = get(changeSecretAutomationsId);
        if (Objects.isNull(changeSecretAutomation)) {
            return;
        }

        List<String> assetIdSet = Optional.ofNullable(changeSecretAutomation.getAssets())
                .map(e -> e.stream().map(ChangeSecretAutomation.AssetDTO::getId).collect(Collectors.toList()))
                .orElseGet(ArrayList::new);

        assetIdSet.removeIf(assetIds::contains);

        String url = ClientConstants.CHANGE_SECRET_AUTOMATIONS_DETAIL.replace("{id}", changeSecretAutomationsId);
        HashMap<String, Object> req = new HashMap<>();
        req.put("assets", assetIdSet);
        patch(ChangeSecretAutomation.class, url).json(JSON.toJSONString(req)).execute();
    }
}
