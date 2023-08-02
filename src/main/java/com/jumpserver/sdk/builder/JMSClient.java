package com.jumpserver.sdk.builder;

import com.jumpserver.sdk.jumpserver.account.v3.AssetAccountService;
import com.jumpserver.sdk.jumpserver.assetnode.v3.AssetNodeV3Service;
import com.jumpserver.sdk.jumpserver.assets.v2.AssertsService;
import com.jumpserver.sdk.jumpserver.assets.v3.AssertsV3Service;
import com.jumpserver.sdk.jumpserver.luna.LunaService;
import com.jumpserver.sdk.jumpserver.luna.V3.LunaV3Service;
import com.jumpserver.sdk.jumpserver.org.OrgService;
import com.jumpserver.sdk.jumpserver.permissions.v2.PermissionService;
import com.jumpserver.sdk.jumpserver.permissions.v3.PermissionV3Service;
import com.jumpserver.sdk.jumpserver.role.v3.RoleService;
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
     * assetNode 资产节点信息
     *
     * @return
     */
    AssetNodeV3Service assetNodeV3();

    /**
     * assets 资产信息
     *
     * @return
     */
    OrgService orgs();

    /**
     * assets 资产信息
     *
     * @return
     */
    AssetAccountService assetAccountV3();

    /**
     * luna 终端界面
     *
     * @return
     */
    LunaService luna();

    /**
     * luna 终端界面
     * V3 版本
     * @return
     */
    LunaV3Service lunaV3();

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

    /**
     * 系统 & 组织角色信息
     *
     * @return
     */
    RoleService roles();

}
