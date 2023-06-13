package com.jumpserver.sdk.model.asset.v3;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * @author : houchen
 */
public class Asset {

    private String id;
    private String name;
    private String address;
    private String comment;
    private String domain;
    private Platform platform;
    private List<AssetNode> nodes;
    private List<Protocol> protocols;
    @JSONField(name = "is_active")
    private boolean isActive;
    @JSONField(name = "date_verified")
    private String dateVerified;
    @JSONField(name = "date_created")
    private String dateCreated;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public List<AssetNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<AssetNode> nodes) {
        this.nodes = nodes;
    }

    public List<Protocol> getProtocols() {
        return protocols;
    }

    public void setProtocols(List<Protocol> protocols) {
        this.protocols = protocols;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDateVerified() {
        return dateVerified;
    }

    public void setDateVerified(String dateVerified) {
        this.dateVerified = dateVerified;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
