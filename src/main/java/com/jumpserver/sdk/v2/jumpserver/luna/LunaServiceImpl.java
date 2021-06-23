package com.jumpserver.sdk.v2.jumpserver.luna;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jumpserver.sdk.v2.builder.JMSClientImpl;
import com.jumpserver.sdk.v2.common.BaseJmsService;
import com.jumpserver.sdk.v2.common.ClientConstants;
import com.jumpserver.sdk.v2.exceptions.JmsException;
import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.Optional;

/**
 * @author yankaijun
 * @date 2018/10/16 上午10:34
 */
public class LunaServiceImpl extends BaseJmsService implements LunaService {

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

    public String connectLunaUrl(String assetId, String systemUserId, String userId, String system) {
        JSONObject p = new JSONObject();
        p.put("user", userId);
        p.put("system_user", systemUserId);
        p.put("asset", assetId);

        Map tokenResult = post(Map.class, uri(ClientConstants.USER_CONNECTION_TOKEN))
                .json(p.toJSONString())
                .execute();

        String token = Optional.ofNullable(tokenResult.get("token")).orElse(StringUtils.EMPTY).toString();
        if (StringUtils.isBlank(token)) {
            throw new JmsException("Failed to get token " + Optional.ofNullable(tokenResult.get("detail")).orElse(JSON.toJSONString(tokenResult)));
        }

        JMSClientImpl current = JMSClientImpl.getCurrent();
        if (current == null) {
            throw new JmsException("Unable to retrieve current session. Please verify thread has a current session available.");
        }
        StringBuffer result = new StringBuffer();
        result.append(current.getApiKey().getEndpoint())
                .append(ClientConstants.LUNA_CONNECT_URL.replace("{system}", system).replace("{token}", token));
        return result.toString();
    }
}
