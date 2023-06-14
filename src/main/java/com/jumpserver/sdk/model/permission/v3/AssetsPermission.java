package com.jumpserver.sdk.model.permission.v3;

import com.jumpserver.sdk.common.Annotation.ActionValidator;
import com.jumpserver.sdk.model.asset.v3.AssetNode;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class AssetsPermission {
    private String id;
    @Length(message = "资产授权名称长度需要在1-128之间")
    private String name;

    private Boolean is_active;

    private String date_expired;

    private String created_by;

    private String date_created;

    private String date_start;

    private String comment;

    private List<String> accounts;

    private List<UserGroup> user_groups;

    private List<User> users;

    private List<AssetNode> nodes;

    private List<String> assets;
    @ActionValidator
    private List<String> actions;

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

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }

    public List<UserGroup> getUser_groups() {
        return user_groups;
    }

    public void setUser_groups(List<UserGroup> user_groups) {
        this.user_groups = user_groups;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<AssetNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<AssetNode> nodes) {
        this.nodes = nodes;
    }

    public List<String> getAssets() {
        return assets;
    }

    public void setAssets(List<String> assets) {
        this.assets = assets;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }
}
