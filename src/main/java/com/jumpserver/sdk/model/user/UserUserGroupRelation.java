package com.jumpserver.sdk.model.user;


/**
 * @author gaoao
 */
public class UserUserGroupRelation {

    private String id;

    private String user_display;

    private String user;

    private String usergroup;

    private String usergroup_display;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_display() {
        return user_display;
    }

    public void setUser_display(String user_display) {
        this.user_display = user_display;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(String usergroup) {
        this.usergroup = usergroup;
    }

    public String getUsergroup_display() {
        return usergroup_display;
    }

    public void setUsergroup_display(String usergroup_display) {
        this.usergroup_display = usergroup_display;
    }
}
