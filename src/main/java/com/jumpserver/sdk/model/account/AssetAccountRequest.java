package com.jumpserver.sdk.model.account;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author : houchen
 */
public class AssetAccountRequest {

    @NotNull
    private String id;
    @NotNull
    @Length(message = "名称长度在1-128之间", min = 1, max = 128)
    private String name;
    @Length(message = "名称长度在1-128之间", max = 128)
    private String username;
    private String asset;
    private boolean privileged;
    private String su_from;
    private SecretType secret_type;
    private boolean push_now;
    private boolean is_active;
    private String comment;
    private String secret;
    private String template;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public String getSu_from() {
        return su_from;
    }

    public void setSu_from(String su_from) {
        this.su_from = su_from;
    }

    public SecretType getSecret_type() {
        return secret_type;
    }

    public void setSecret_type(SecretType secret_type) {
        this.secret_type = secret_type;
    }

    public boolean isPush_now() {
        return push_now;
    }

    public void setPush_now(boolean push_now) {
        this.push_now = push_now;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
