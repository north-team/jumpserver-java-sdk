package com.jumpserver.sdk.jumpserver.role.v3;

import com.jumpserver.sdk.model.Role;

import java.util.List;

/**
 * @author gaoao
 */
public interface RoleService {

    /**
     * 查询系统角色
     * @return
     */
    List<Role> selectSystemRoles();

    /**
     * 查询组织角色
     * @return
     */
    List<Role> selectOrgRoles();


}
