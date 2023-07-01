package com.jumpserver.sdk.model.account;

/**
 * @author : houchen
 */
public enum SecretType {
    password("密码"), ssh_key("SSH 密钥"), access_key("Access Key"), token("Token");

    private String label;

    SecretType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
