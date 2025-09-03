package com.jumpserver.sdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;


public class ChangeSecretAutomation extends BaseChangeSecretAutomation {


    @JSONField(name = "created_by")
    public String createdBy;

    @JSONField(name = "periodic_display")
    public String periodicDisplay;

    @JSONField(name = "executed_amount")
    public Integer executedAmount;

    @JSONField(name = "type")
    public String type;

    @JSONField(name = "org_id")
    public String orgId;

    @JSONField(name = "org_name")
    public String orgName;

    @JSONField(name = "date_created")
    public String dateCreated;

    @JSONField(name = "date_updated")
    public String dateUpdated;


    @JSONField(name = "nodes")
    public List<?> nodes;

    @JSONField(name = "assets")
    public List<?> assets;


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getPeriodicDisplay() {
        return periodicDisplay;
    }

    public void setPeriodicDisplay(String periodicDisplay) {
        this.periodicDisplay = periodicDisplay;
    }

    public Integer getExecutedAmount() {
        return executedAmount;
    }

    public void setExecutedAmount(Integer executedAmount) {
        this.executedAmount = executedAmount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }


    public List<?> getNodes() {
        return nodes;
    }

    public void setNodes(List<?> nodes) {
        this.nodes = nodes;
    }

    public List<?> getAssets() {
        return assets;
    }

    public void setAssets(List<?> assets) {
        this.assets = assets;
    }

}