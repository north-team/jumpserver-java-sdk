package com.jumpserver.sdk.v2.model;

import java.util.List;

public class SyncInstanceTask {
    private String account;
    private String account_display;
    private String admin_user;
    private String admin_user_display;
    private String comment;
    private String created_by;
    private String crontab;
    private String date_created;
    private String date_last_sync;
    private List<String> domains;
    private Long history_count;
    private String hostname_strategy;
    private String id;
    private Long instance_count;
    private Long interval;
    private boolean is_always_update;
    private boolean is_periodic;
    private String name;
    private String node;
    private String node_display;
    private String org_id;
    private String org_name;
    private String periodic_display;
    private List<String> regions;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount_display() {
        return account_display;
    }

    public void setAccount_display(String account_display) {
        this.account_display = account_display;
    }

    public String getAdmin_user() {
        return admin_user;
    }

    public void setAdmin_user(String admin_user) {
        this.admin_user = admin_user;
    }

    public String getAdmin_user_display() {
        return admin_user_display;
    }

    public void setAdmin_user_display(String admin_user_display) {
        this.admin_user_display = admin_user_display;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getCrontab() {
        return crontab;
    }

    public void setCrontab(String crontab) {
        this.crontab = crontab;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getDate_last_sync() {
        return date_last_sync;
    }

    public void setDate_last_sync(String date_last_sync) {
        this.date_last_sync = date_last_sync;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public Long getHistory_count() {
        return history_count;
    }

    public void setHistory_count(Long history_count) {
        this.history_count = history_count;
    }

    public String getHostname_strategy() {
        return hostname_strategy;
    }

    public void setHostname_strategy(String hostname_strategy) {
        this.hostname_strategy = hostname_strategy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getInstance_count() {
        return instance_count;
    }

    public void setInstance_count(Long instance_count) {
        this.instance_count = instance_count;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public boolean isIs_always_update() {
        return is_always_update;
    }

    public void setIs_always_update(boolean is_always_update) {
        this.is_always_update = is_always_update;
    }

    public boolean isIs_periodic() {
        return is_periodic;
    }

    public void setIs_periodic(boolean is_periodic) {
        this.is_periodic = is_periodic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getNode_display() {
        return node_display;
    }

    public void setNode_display(String node_display) {
        this.node_display = node_display;
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

    public String getPeriodic_display() {
        return periodic_display;
    }

    public void setPeriodic_display(String periodic_display) {
        this.periodic_display = periodic_display;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }
}
