package com.jumpserver.sdk.jumpserver.luna.V3;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jumpserver.sdk.builder.JMSClientImpl;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.exceptions.JmsException;
import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.Optional;

/**
 * @author yankaijun
 * @date 2018/10/16 上午10:34
 */
public class LunaV3ServiceImpl extends BaseJmsService implements LunaV3Service {

    @Override
    public String connectLunaUrl(String assetId) {
        JMSClientImpl current = JMSClientImpl.getCurrent();
        if (current == null) {
            throw new JmsException("Unable to retrieve current session. Please verify thread has a current session available.");
        }
        StringBuffer result = new StringBuffer();
        result.append(current.getApiKey().getEndpoint())
                .append(ClientConstants.LUNA_URL)
                .append(assetId);
        return result.toString();
    }

    @Override
    public String connectLunaUrl(String assetId, String username) {
        JSONObject p = new JSONObject();
        p.put("username", username);
        p.put("next", "/luna/?login_to=" + assetId);
        Map tokenResult = post(Map.class, uri(ClientConstants.LUNA_SSO_URL))
                .json(p.toJSONString())
                .execute();
        return tokenResult.get("login_url").toString();
    }

    @Override
    public String openNewConnectLunaUrl(String assetId) {
        JMSClientImpl current = JMSClientImpl.getCurrent();
        if (current == null) {
            throw new JmsException("Unable to retrieve current session. Please verify thread has a current session available.");
        }
        return current.getApiKey().getEndpoint() +
                ClientConstants.LUNA_CONNECT_V3_URL +
                assetId;
    }
}
