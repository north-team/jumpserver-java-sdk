package com.jumpserver.sdk.model.asset.v2;

import com.jumpserver.sdk.model.common.ModelEntity;

public class Confirm implements ModelEntity {
    private String confirm_type = "password";
    private String secret_key;

    public String getConfirm_type() {
        return confirm_type;
    }

    public void setConfirm_type(String confirm_type) {
        this.confirm_type = confirm_type;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }
}
