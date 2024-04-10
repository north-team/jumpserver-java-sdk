package com.jumpserver.sdk.model.account;

import org.hibernate.validator.constraints.Length;

public class AccountTemplateRequest {
    private String id;
    @Length(message = "资产账号名称长度需在1-128位之间", min = 1, max = 128)
    private String name;
    @Length(message = "用户名长度需在1-128位之间", max = 128)
    private String username;
    private SecretType secret_type;
    @Length(message = "秘钥最大长度是40960", max = 40960)
    private String secret;
    @Length(message = "秘钥密码最大长度是512", max = 512)
    private String passphrase;
    private String comment;
    private String su_from;
    private boolean privileged;
    private boolean is_active;
    private boolean is_sync_account;

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

    public SecretType getSecret_type() {
        return secret_type;
    }

    public void setSecret_type(SecretType secret_type) {
        this.secret_type = secret_type;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getSu_from() {
        return su_from;
    }

    public void setSu_from(String su_from) {
        this.su_from = su_from;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public boolean isIs_sync_account() {
        return is_sync_account;
    }

    public void setIs_sync_account(boolean is_sync_account) {
        this.is_sync_account = is_sync_account;
    }
}
