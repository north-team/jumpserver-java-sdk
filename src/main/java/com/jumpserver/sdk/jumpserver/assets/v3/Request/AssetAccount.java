package com.jumpserver.sdk.jumpserver.assets.v3.Request;

import com.alibaba.fastjson.annotation.JSONField;
import com.jumpserver.sdk.common.Annotation.OnInvalidValidator;
import com.jumpserver.sdk.common.Annotation.SecretTypeValidator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * @author tangyunhao
 */
public class AssetAccount {
    private String id;
    @Length(message = "资产账号名称长度需在1-128位之间", min = 1, max = 128)
    private String name;
    @Length(message = "用户名长度需在1-128位之间", max = 128)
    private String username;
    @JSONField(name = "secret_type")
    @SecretTypeValidator
    private String secretType;
    @Length(message = "秘钥最大长度是40960", max = 40960)
    private String secret;
    @Length(message = "秘钥密码最大长度是512", max = 512)
    private String passphrase;
    private String comment;
    @JSONField(name = "su_from")
    private String suFrom;
    private String asset;
    @Range(message = "版本号需要在-2147483648到2147483647之间", min = -2147483648, max = 2147483647)
    private int version;
    private String template;
    @JSONField(name = "on_invalid")
    @OnInvalidValidator
    private String onInvalid;
    private boolean privileged;
    @JSONField(name = "is_active")
    private boolean isActive;

    @JSONField(name = "push_now")
    private boolean pushNow;

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

    public String getSecretType() {
        return secretType;
    }

    public void setSecretType(String secretType) {
        this.secretType = secretType;
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

    public String getSuFrom() {
        return suFrom;
    }

    public void setSuFrom(String suFrom) {
        this.suFrom = suFrom;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getOnInvalid() {
        return onInvalid;
    }

    public void setOnInvalid(String onInvalid) {
        this.onInvalid = onInvalid;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isPushNow() {
        return pushNow;
    }

    public void setPushNow(boolean pushNow) {
        this.pushNow = pushNow;
    }
}
