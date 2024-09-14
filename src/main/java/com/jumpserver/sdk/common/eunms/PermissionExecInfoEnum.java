package com.jumpserver.sdk.common.eunms;

import com.jumpserver.sdk.common.ClientConstants;

/**
 * @author gaoao
 */
public enum PermissionExecInfoEnum {
    /**
     * 异常信息
     */
    QUERY_ORG(ClientConstants.ORG, "查询组织列表"),
    QUERY_USERS(ClientConstants.USERS, "查询用户列表"),
    USER_GROUPS(ClientConstants.USERGROUPS, "查询用户组列表"),
    CURRENT_USER(ClientConstants.CURRENT_USER, "获取用户信息"),
    USER_CONNECTION_TOKEN(ClientConstants.USER_CONNECTION_TOKEN, "用户连接资产"),
    USERS_INTO_ORG(ClientConstants.USERS_INTO_ORG, "用户邀请到组织"),
    USERS_INTO_USER_GROUP(ClientConstants.USERS_INTO_USER_GROUP, "用户组添加、移除用户"),

    NODES(ClientConstants.NODES, "获取资产节点列表"),
    NODE_UPDATE(ClientConstants.NODE_UPDATE, "操作单个资产节点"),
    NODES_ASSETS(ClientConstants.NODES_ASSETS, "资产添加到资产节点"),
    ASSET_ACCOUNT(ClientConstants.ASSET_ACCOUNT, "获取资产账号"),
    ASSET_ACCOUNT_PAGE(ClientConstants.ASSET_ACCOUNT_PAGE, "分页获取资产账号"),
    ASSETS(ClientConstants.ASSETS, "获取资产列表"),
    ASSETSV3(ClientConstants.ASSETSV3, "操作资产"),
    PLATFORM(ClientConstants.PLATFORM, "获取资产平台类型"),
    DOMAINS(ClientConstants.DOMAINS, "获取资产网域"),
    GATEWAYS(ClientConstants.GATEWAYS, "获取资产网关"),
    INVITE_USERS(ClientConstants.INVITE_USERS, "添加组织用户"),
    REMOVE_USERS(ClientConstants.INVITE_USERS, "删除组织用户"),
    RBAC_ORG_ROLES(ClientConstants.RBAC_ORG_ROLES, "查询组织角色"),
    RBAC_SYSTEM_ROLES(ClientConstants.RBAC_SYSTEM_ROLES, "查询系统角色"),
    LUNA_URL(ClientConstants.LUNA_URL, "没有连接权限"),
    LUNA_SSO_URL(ClientConstants.LUNA_SSO_URL, "没有连接权限"),
    LUNA_CONNECT_URL(ClientConstants.LUNA_CONNECT_URL, "没有连接权限"),
    LUNA_CONNECT_V3_URL(ClientConstants.LUNA_CONNECT_V3_URL, "没有连接权限");


    private final String url;

    private final String errorMsg;

    PermissionExecInfoEnum(String url, String errorMsg) {
        this.url = url;
        this.errorMsg = errorMsg;
    }

    public String getUrl() {
        return url;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public static String getPermissionExecInfo(String url) {
        String errorMsg = url;
        for (PermissionExecInfoEnum permissionExecInfoEnum : PermissionExecInfoEnum.values()) {
            if (permissionExecInfoEnum.getUrl().equals(url)) {
                errorMsg = permissionExecInfoEnum.getErrorMsg();
                break;
            }
        }
        return  "当前账号没有「" + errorMsg + "」的权限，请联系管理员授权";
    }
}
