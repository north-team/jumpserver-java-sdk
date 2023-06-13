package com.jumpserver.sdk.jumpserver.org;

import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.model.organization.Org;
import com.jumpserver.sdk.model.organization.OrgUsers;

import java.util.List;

public interface OrgService {

    List<Org> listOrg();

    Org getOrg(String orgId);

    Org updateOrg(Org org);

    Org createOrg(Org org);

    ActionResponse deleteOrg(String orgId);

    List<OrgUsers> getOrgUsers(String orgId);

    OrgUsers createOrgUsers(OrgUsers orgusers);

    OrgUsers inviteUsers(OrgUsers orgusers);

    OrgUsers removeUsers(OrgUsers orgusers);

    ActionResponse deleteOrgUsers(String orgId,String userId);

    List<OrgUsers> getOrgAdmins(String orgId);

    OrgUsers createOrgAdmins(OrgUsers orgusers);

    ActionResponse deleteOrgAdmins(String orgId,String userId);

}
