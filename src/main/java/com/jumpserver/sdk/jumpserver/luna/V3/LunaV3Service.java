package com.jumpserver.sdk.jumpserver.luna.V3;


/**
 * @author gaoao
 */
public interface LunaV3Service {

    String connectLunaUrl(String assetId);

    String connectLunaUrl(String assetId, String username);

    /**
     * 跳转时只打开一台机器的连接（用户无法在页面查看和连接其他机器）
     * @param assetId
     * @return
     */
    String openNewConnectLunaUrl(String assetId);
}
