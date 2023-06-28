package com.jumpserver.sdk.jumpserver.role.v3;

import com.jumpserver.sdk.common.BaseJmsService;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.Role;

import java.util.List;

/**
 * @author gaoao
 */
public class RoleServiceImpl extends BaseJmsService implements RoleService{

    @Override
    public List<Role> selectSystemRoles() {
        return get(Role.class, uri(ClientConstants.RBAC_SYSTEM_ROLES)).executeList();
    }

    @Override
    public List<Role> selectOrgRoles() {
        return get(Role.class, uri(ClientConstants.RBAC_ORG_ROLES)).executeList();
    }
}
