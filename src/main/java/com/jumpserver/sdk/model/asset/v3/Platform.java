package com.jumpserver.sdk.model.asset.v3;

import com.jumpserver.sdk.common.Annotation.PlatformValidator;

public class Platform {
    @PlatformValidator
    private Integer pk;

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }
}
