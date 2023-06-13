package com.jumpserver.sdk.jumpserver.users;

import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.model.usergroup.UserGroup;
import com.jumpserver.sdk.model.user.User;

import java.util.List;

public interface UserService {

    List<User> list();

    User get(String userId);

    User getUserInfo();

    List<User> search(String userName);

    User update(User user);

    User create(User user);

    ActionResponse delete(String userId);

    ActionResponse changePassword(String userId, String password);

    List<UserGroup> userGroups();

    UserGroup updateUserGroup(UserGroup usergroup);

    UserGroup createUserGroup(UserGroup usergroup);

    ActionResponse deleteUserGroup(String groupId);

}
