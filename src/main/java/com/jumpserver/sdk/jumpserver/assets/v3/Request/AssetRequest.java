package com.jumpserver.sdk.jumpserver.assets.v3.Request;


import com.alibaba.fastjson.annotation.JSONField;
import com.jumpserver.sdk.common.Annotation.PlatformValidator;
import com.jumpserver.sdk.model.asset.v3.Protocol;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import java.util.List;

/**
 * @author : houchen
 */
public class AssetRequest {

    private String id;
    @NotBlank(message = "资产名称不能为空")
    @Length(message = "资产名称长度需在1-128位之间", min = 1, max = 128)
    private String name;
    @NotBlank(message = "地址不能为空")
    @Length(message = "地址长度需在1-767位之间", min = 1, max = 767)
    private String address;
    private String comment;
    private String domain;
    @PlatformValidator
    private Integer platform;
    /**
     * node的id
     */
    private List<String> nodes;
    @Valid
    private List<Protocol> protocols;
    @Valid
    private List<AssetAccount> accounts;
    @JSONField(name = "is_active")
    private boolean isActive;

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

    public Integer getPlatform() {
        return platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public List<Protocol> getProtocols() {
        return protocols;
    }

    public void setProtocols(List<Protocol> protocols) {
        this.protocols = protocols;
    }

    public List<AssetAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AssetAccount> accounts) {
        this.accounts = accounts;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

