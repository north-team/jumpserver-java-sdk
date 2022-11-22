package com.jumpserver.sdk.v2.model;

import com.jumpserver.sdk.v2.model.entity.ModelEntity;

/**
 * @author houchen
 */
public class AssetAccount implements ModelEntity {
    private String asset;
    private String asset_display;
    private String id;
    private String hostname;
    private String ip;
    private String org_id;
    private String org_name;
    private String systemuser;
    private String systemuser_display;
    private String username;
    private String public_key;
    private String password;
    private String protocols;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getAsset_display() {
        return asset_display;
    }

    public void setAsset_display(String asset_display) {
        this.asset_display = asset_display;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getSystemuser() {
        return systemuser;
    }

    public void setSystemuser(String systemuser) {
        this.systemuser = systemuser;
    }

    public String getSystemuser_display() {
        return systemuser_display;
    }

    public void setSystemuser_display(String systemuser_display) {
        this.systemuser_display = systemuser_display;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPublic_key() {
        return public_key;
    }

    public void setPublic_key(String public_key) {
        this.public_key = public_key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProtocols() {
        return protocols;
    }

    public void setProtocols(String protocols) {
        this.protocols = protocols;
    }
}
