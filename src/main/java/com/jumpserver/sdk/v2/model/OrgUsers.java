package com.jumpserver.sdk.v2.model;

/**
 * @author yankaijun
 * @date 2018/10/31 11:34 AM
 */
public class OrgUsers {

    private String orgId;
    private String id;
    private String organization;
    private String user;
    private String[] org_roles;
    private String[] users;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String[] getOrg_roles() {
        return org_roles;
    }

    public void setOrg_roles(String[] org_roles) {
        this.org_roles = org_roles;
    }

    public String[] getUsers() {
        return users;
    }

    public void setUsers(String[] users) {
        this.users = users;
    }
}
