package com.jumpserver.sdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/**
 * 创建 / 更新改密自动化请求
 */
public class ChangeSecretAutomationRequest extends BaseChangeSecretAutomation {

    /* 请求体独有字段 */
    @JSONField(name = "accounts")
    public AccountsDTO accounts;

    @JSONField(name = "secret")
    public String secret;

    @JSONField(name = "passphrase")
    public String passphrase;

    @JSONField(name = "nodes")
    public List<String> nodes;

    @JSONField(name = "assets")
    public List<String> assets;

    public AccountsDTO getAccounts() {
        return accounts;
    }

    public void setAccounts(AccountsDTO accounts) {
        this.accounts = accounts;
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

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public List<String> getAssets() {
        return assets;
    }

    public void setAssets(List<String> assets) {
        this.assets = assets;
    }
}