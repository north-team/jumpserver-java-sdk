package com.jumpserver.sdk.model.asset.v3;

/**
 * @author : houchen
 */
public class Protocol {

    private String name;
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
