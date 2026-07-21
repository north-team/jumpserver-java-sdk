package com.jumpserver.sdk.model.account;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChangeSecretAutomationRequestTest {

    @Test
    public void shouldSerializeCustomSecret() {
        ChangeSecretAutomationRequest request = new ChangeSecretAutomationRequest();
        request.setSecret("custom-secret");

        assertEquals("custom-secret", JSON.parseObject(JSON.toJSONString(request)).getString("secret"));
    }
}
