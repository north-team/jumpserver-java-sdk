package com.jumpserver.sdk.builder;

import com.jumpserver.sdk.jumpserver.assets.v2.AssertsService;
import com.jumpserver.sdk.jumpserver.assets.v3.AssertsV3Service;
import com.jumpserver.sdk.jumpserver.luna.LunaService;
import com.jumpserver.sdk.jumpserver.org.OrgService;
import com.jumpserver.sdk.jumpserver.permissions.v2.PermissionService;
import com.jumpserver.sdk.jumpserver.permissions.v3.PermissionV3Service;
import com.jumpserver.sdk.jumpserver.users.UserService;

import java.util.Map;

public interface JMSClient {

    /**
     * API Key 信息
     *
     * @return
     */
    ApiKey getApiKey();

    /**
     * users 用户信息
     *
     * @return
     */
    UserService users();

    /**
     * assets 资产信息
     *
     * @return
     */
    AssertsService assets();

    /**
     * assets 资产信息
     *
     * @return
     */
    AssertsV3Service assetsV3();

    /**
     * assets 资产信息
     *
     * @return
     */
    OrgService orgs();

    /**
     * luna 终端界面
     *
     * @return
     */
    LunaService luna();

    /**
     * permissions 授权规则
     *
     * @return
     */
    PermissionService permissions();

    /**
     * permissionsV3 授权规则
     *
     * @return
     */
    PermissionV3Service permissionsV3();

    /**
     * 获得请求头
     *
     * @return
     */
    Map getHeaders();

}
