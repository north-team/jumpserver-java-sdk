package com.jumpserver.sdk.model.permission.v3;

import com.jumpserver.sdk.model.common.IdName;
import com.jumpserver.sdk.model.common.LabelValue;

import java.util.List;

public class AssetsPermission {
    private String id;

    private String name;

    private String org_id;

    private Boolean is_active;

    private String date_expired;

    private String created_by;

    private String date_created;

    private String date_start;

    private String comment;

    private List<IdName> user_groups;

    private List<IdName> users;

    private List<IdName> nodes;

    private List<IdName> assets;

    private List<IdName> system_users;

    private List<LabelValue> actions;

    private String[] accounts;

    public AssetsPermission() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getDate_expired() {
        return date_expired;
    }

    public void setDate_expired(String date_expired) {
        this.date_expired = date_expired;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<IdName> getUser_groups() {
        return user_groups;
    }

    public void setUser_groups(List<IdName> user_groups) {
        this.user_groups = user_groups;
    }

    public List<IdName> getUsers() {
        return users;
    }

    public void setUsers(List<IdName> users) {
        this.users = users;
    }

    public List<IdName> getNodes() {
        return nodes;
    }

    public void setNodes(List<IdName> nodes) {
        this.nodes = nodes;
    }

    public List<IdName> getAssets() {
        return assets;
    }

    public void setAssets(List<IdName> assets) {
        this.assets = assets;
    }

    public List<IdName> getSystem_users() {
        return system_users;
    }

    public void setSystem_users(List<IdName> system_users) {
        this.system_users = system_users;
    }

    public List<LabelValue> getActions() {
        return actions;
    }

    public void setActions(List<LabelValue> actions) {
        this.actions = actions;
    }

    public String[] getAccounts() {
        return accounts;
    }

    public void setAccounts(String[] accounts) {
        this.accounts = accounts;
    }
}
