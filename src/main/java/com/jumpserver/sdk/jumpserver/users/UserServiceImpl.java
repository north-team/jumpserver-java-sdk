package com.jumpserver.sdk.jumpserver.users;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.user.User;
import com.jumpserver.sdk.model.user.UserUserGroupRelation;
import com.jumpserver.sdk.model.usergroup.UserGroup;
import com.jumpserver.sdk.model.common.MapEntity;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class UserServiceImpl extends BaseJmsService implements UserService {

    @Override
    public List<User> list() {
        return get(User.class, uri(ClientConstants.USERS)).executeList();
    }

    @Override
    public User get(String userId) {
        checkNotNull(userId);
        return get(User.class, ClientConstants.USERS, userId, "/").execute();
    }

    @Override
    public User getUserInfo() {
        return get(User.class, ClientConstants.CURRENT_USER).execute();
    }

    @Override
    public List<User> search(String searchName) {
        checkNotNull(searchName);
        String url = ClientConstants.USERS + "?search=" + searchName;
        return get(User.class, uri(url)).executeList();
    }

    @Override
    public ActionResponse delete(String userId) {
        checkNotNull(userId);
        return deleteWithResponse(ClientConstants.USERS, userId, "/").execute();
    }

    @Override
    public User update(User user) {
        checkNotNull(user);
        return patch(User.class, ClientConstants.USERS, user.getId(), "/").json(JSON.toJSONString(user)).execute();
    }

    @Override
    public User create(User user) {
        checkNotNull(user);
        return post(User.class, uri(ClientConstants.USERS))
                .json(JSON.toJSONString(user))  // .entity(user)
                .execute();
    }

    @Override
    public ActionResponse changePassword(String userId, String password) {
        checkNotNull(userId);
        checkNotNull(password);
        MapEntity mapEntity = MapEntity.create("password", password);
        String url = ClientConstants.USER_PASSWORD_RESET.replace("{id}", userId);
        return put(ActionResponse.class, url).entity(mapEntity).execute();
    }

    @Override
    public List<UserGroup> userGroups() {
        // TODO ...
        return get(UserGroup.class, uri(ClientConstants.USERGROUPS)).header(ClientConstants.X_JMS_ORG, "00000000-0000-0000-0000-000000000000").executeList();
    }

    @Override
    public UserGroup createUserGroup(UserGroup usergroup) {
        checkNotNull(usergroup);
        return post(UserGroup.class, uri(ClientConstants.USERGROUPS))
                .json(JSON.toJSONString(usergroup))
                .execute();
    }

    @Override
    public ActionResponse deleteUserGroup(String groupId) {
        checkNotNull(groupId);
        return deleteWithResponse(ClientConstants.USERGROUPS, groupId, "/").execute();
    }

    @Override
    public void invite(List<String> userIds, List<String> orgRoles) {
        checkNotNull(userIds);
        checkNotNull(orgRoles);
        JSONObject param = new JSONObject();
        param.put("users", userIds);
        param.put("org_roles", orgRoles);
        ActionResponse response = post(ActionResponse.class, uri(ClientConstants.USERS_INTO_ORG))
                .json(JSON.toJSONString(param))
                .execute();
    }

    @Override
    public List<UserUserGroupRelation> intoUserGroup(List<UserUserGroupRelation> userUserGroupRelations) {
        checkNotNull(userUserGroupRelations);
        return (List<UserUserGroupRelation>)post(List.class, uri(ClientConstants.USERS_INTO_USER_GROUP))
                .json(JSON.toJSONString(userUserGroupRelations))
                .execute();
    }

    @Override
    public UserGroup updateUserGroup(UserGroup usergroup) {
        checkNotNull(usergroup);
        return patch(UserGroup.class, uri(ClientConstants.USERGROUPS), usergroup.getId(), "/")
                .json(JSON.toJSONString(usergroup))
                .execute();
    }

    @Override
    public ActionResponse removeUserGroupByUserId(String userId, String userGroupId) {
        checkNotNull(userId);
        checkNotNull(userGroupId);
        String usersIntoUserGroupDelete =
                ClientConstants.USERS_INTO_USER_GROUP + "?user=" + userId + "&usergroup=" + userGroupId;
        return deleteWithResponse(usersIntoUserGroupDelete).execute();
    }

}
