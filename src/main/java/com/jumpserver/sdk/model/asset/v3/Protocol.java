package com.jumpserver.sdk.model.asset.v3;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 * @author : houchen
 */
public class Protocol {
    @NotBlank(message = "协议名称不能为空")
    @Length(message = "协议名称长度需在1-32之间", min = 1, max = 32)
    private String name;
    @Range(message = "协议端口需在1-65535之间", min = 1, max = 65535)
    private int port;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPort(int port) {
        this.port = port;
    }
    public int getPort() {
        return port;
    }

}
