package com.jumpserver.sdk.common;

public final class ClientConstants {

    private static final String BASE_URL = "/api/v1";

    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String X_JMS_ORG = "x-jms-org";

    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_TYPE_JSON = "application/json";

    // Paths
    public static final String URI_SEP = "/";

    // user
    public static final String USERS = BASE_URL + "/users/users/";
    public static final String CURRENT_USER = BASE_URL + "/users/profile/";
    public static final String USERGROUPS = BASE_URL + "/users/groups/";
    public static final String USER_PASSWORD_RESET = BASE_URL + "/users/users/{id}/password/";
    public static final String USER_CONNECTION_TOKEN = BASE_URL + "/users/connection-token/";

    // assets
    public static final String NODES = BASE_URL + "/assets/nodes/";
    public static final String NODES_ASSETS = BASE_URL + "/assets/nodes/{id}/assets/";

    // nodes
    public static final String ASSETS = BASE_URL + "/assets/assets/";
    public static final String ASSETSV3 = BASE_URL + "/assets/hosts/";

    //网域
    public static final String DOMAINS = BASE_URL + "/assets/domains/";
    public static final String GATEWAYS = BASE_URL + "/assets/gateways/";


    public static final String ORG = BASE_URL + "/orgs/orgs/";
    public static final String ORGADMINS = BASE_URL + "/orgs/orgs/{org_id}/membership/admins/";
    public static final String ORGUSERS = BASE_URL + "/orgs/orgs/{org_id}/membership/users/";
    public static final String INVITE_USERS = BASE_URL + "/users/users/invite/";
    public static final String REMOVE_USERS = BASE_URL + "/users/users/{user_id}/remove/";

    // nodes children
    public static final String NODES_ID_CHILDREN = BASE_URL + "/assets/nodes/{id}/children/";
    public static final String NODES_CHILDREN = BASE_URL + "/assets/nodes/children/";
    public static final String NODES_CHILDREN_ADD = BASE_URL + "/assets/nodes/{id}/children/add/";
    public static final String NODES_ASSETS_ADD = BASE_URL + "/assets/nodes/{id}/assets/add/";
    public static final String NODES_ASSETS_REMOVE = BASE_URL + "/assets/nodes/{id}/assets/remove/";

    // label
    public static final String LABELS = BASE_URL + "/assets/labels/";

    // system_user
    public static final String ADMIN_USERS = BASE_URL + "/assets/admin-users/";
    public static final String ADMIN_USERS_CLUSTER = BASE_URL + "/assets/admin-users/{id}/clusters/";
    public static final String ADMIN_USERS_AUTH = BASE_URL + "/assets/admin-users/{id}/auth/";
    public static final String SYSTEM_USER_ACCOUNT = BASE_URL + "/assets/accounts/?systemuser={userId}";
    public static final String ASSET_ACCOUNT_PASSWORD = BASE_URL + "/assets/account-secrets/{assetAccountId}/";
    public static final String MFA_CONFIRM = BASE_URL + "/authentication/confirm/";
    public static final String ASSET_SYSTEM_USERS = BASE_URL + "/assets/system-users-assets-relations/";
    public static final String SYSTEM_USERS = BASE_URL + "/assets/system-users/";
    public static final String SYSTEM_USERS_AUTHINFO = BASE_URL + "/assets/system-users/{id}/auth-info/";
    public static final String SYSTEM_USERS_PUSH = "/assets/system-users/{id}/push/";

    // permission
    public static final String ASSET_PERMISSIONS = BASE_URL + "/perms/asset-permissions/";

    // luna
    public static final String LUNA_URL = "/luna/?login_to=";
    public static final String LUNA_SSO_URL = BASE_URL + "/authentication/sso/login-url/";
    public static final String LUNA_CONNECT_URL = "/luna/connect/?system={system}&token={token}";

}