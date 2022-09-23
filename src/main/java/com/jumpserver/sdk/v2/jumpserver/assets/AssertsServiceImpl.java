package com.jumpserver.sdk.v2.jumpserver.assets;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.v2.common.ActionResponse;
import com.jumpserver.sdk.v2.common.BaseJmsService;
import com.jumpserver.sdk.v2.common.ClientConstants;
import com.jumpserver.sdk.v2.model.*;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author yankaijun
 * @date 2018/10/16 上午10:35
 */
public class AssertsServiceImpl extends BaseJmsService implements AssertsService {

    //资产节点
    @Override
    public List<AssetsNode> listAssetsNode() {
        List<AssetsNode> assetsNodes = get(AssetsNode.class, uri(ClientConstants.NODES)).executeList();
        //增加获取parent_id 信息
        Map<String, String> nodeKeyIdInfo = Optional.ofNullable(assetsNodes).orElse(new ArrayList<>())
                .stream().collect(Collectors.toMap(AssetsNode::getKey, AssetsNode::getId));
        assetsNodes.stream().filter(assetsNode -> assetsNode.getKey().indexOf(":") > -1).forEach(assetsNode -> {
            String parentKey = assetsNode.getKey().substring(0, assetsNode.getKey().lastIndexOf(":"));
            assetsNode.setParent_id(parentKey.indexOf(":") > -1 ? nodeKeyIdInfo.get(parentKey) : "root");
        });
        return assetsNodes;
    }

    //资产节点
    @Override
    public List<AssetsNode> listAssetsNodeIdChildren(String nodeId) {
        String url = ClientConstants.NODES_ID_CHILDREN.replace("{id}", nodeId);
        return get(AssetsNode.class, url).executeList();
    }

    @Override
    public AssetsNode getAssetsNode(String nodeId) {
        checkNotNull(nodeId);
        return get(AssetsNode.class, ClientConstants.NODES, nodeId, "/").execute();
    }

    @Override
    public ActionResponse deleteAssetsNode(String nodeId) {
        checkNotNull(nodeId);
        return deleteWithResponse(ClientConstants.NODES, nodeId, "/").execute();
    }

    @Override
    public ActionResponse deleteAssetsNodeWithAssetCheck(String nodeId) {
        checkNotNull(nodeId);
        //patch node assets to empty
        String url = ClientConstants.NODES_ASSETS.replace("{id}", nodeId);
        String removeUrl = ClientConstants.NODES_ASSETS_REMOVE.replace("{id}", nodeId);
        try {
            List<Asset> assetList = get(Asset.class, url).executeList();
            if (assetList.size() > 0) {
                List<String> idList = assetList.stream().map(Asset::getId).collect(Collectors.toList());
                String[] objects = idList.stream().toArray(String[]::new);
                Map<String, String[]> map = new HashMap<>(1);
                map.put("assets", objects);
                patch(JSON.class, removeUrl).json(JSON.toJSONString(map)).execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteWithResponse(ClientConstants.NODES, nodeId, "/").execute();
    }

    @Override
    public ActionResponse deleteAssetsNodeWithAssetCheckCircle(String nodeId) {
        List<AssetsNode> children = listAssetsNodeIdChildren(nodeId);
        if (CollectionUtils.isNotEmpty(children)) {
            children.stream().forEach(assetsNodeChild -> {
                deleteAssetsNodeWithAssetCheckCircle(assetsNodeChild.getId());
            });
        }
        return deleteAssetsNodeWithAssetCheck(nodeId);
    }

    @Override
    public AssetsNode updateAssetsNode(AssetsNode assetsnode) {
        checkNotNull(assetsnode);
        return patch(AssetsNode.class, ClientConstants.NODES, assetsnode.getId(), "/").json(JSON.toJSONString(assetsnode)).execute();
    }

    @Override
    public AssetsNode createAssetsNode(AssetsNode assetsnode) {
        checkNotNull(assetsnode);
        return post(AssetsNode.class, ClientConstants.NODES)
                .json(JSON.toJSONString(assetsnode))
                .execute();
    }

    //节点下的子节点
    @Override
    public AssetsNode createAssetsNodeChildren(AssetsNode node) {
        checkNotNull(node);
        return post(AssetsNode.class, ClientConstants.NODES_CHILDREN)
                .json(JSON.toJSONString(node))
                .execute();
    }

    @Override
    public AssetsNode createAssetsNodeChildren(String nodeId, AssetsNode node) {
        checkNotNull(nodeId);
        checkNotNull(node);
        String url = ClientConstants.NODES_ID_CHILDREN.replace("{id}", nodeId);
        return post(AssetsNode.class, url)
                .json(JSON.toJSONString(node))
                .execute();
    }

    @Override
    public AssetsNode updateAssetsNodeChildren(String nodeId, AssetsNode node) {
        checkNotNull(nodeId);
        checkNotNull(node);
        String url = ClientConstants.NODES_CHILDREN_ADD.replace("{id}", nodeId);
        return patch(AssetsNode.class, url)
                .json(JSON.toJSONString(node)).execute();
    }

    @Override
    public List<AssetsNode> listAssetsNodeChildren() {
        return get(AssetsNode.class, ClientConstants.NODES_CHILDREN).executeList();
    }

    //资产
    @Override
    public List<Asset> list() {
        return get(Asset.class, ClientConstants.ASSETS).executeList();
    }

    @Override
    public Asset get(String assetId) {
        checkNotNull(assetId);
        return get(Asset.class, ClientConstants.ASSETS, assetId, "/").execute();
    }

    @Override
    public ActionResponse delete(String assetId) {
        checkNotNull(assetId);
        return deleteWithResponse(ClientConstants.ASSETS, assetId, "/").execute();
    }

    @Override
    public Asset update(Asset asset) {
        checkNotNull(asset);
        return patch(Asset.class, ClientConstants.ASSETS, asset.getId(), "/").json(JSON.toJSONString(asset)).execute();
    }

    @Override
    public Asset create(Asset asset) {
        checkNotNull(asset);
        return post(Asset.class, uri(ClientConstants.ASSETS))
                .json(JSON.toJSONString(asset))
                .execute();
    }

    //管理用户
    @Override
    public List<AdminUser> listAdminUser() {
        return get(AdminUser.class, uri(ClientConstants.ADMIN_USERS)).executeList();
    }

    @Override
    public AdminUser getAdminUser(String userId) {
        checkNotNull(userId);
        return get(AdminUser.class, ClientConstants.ADMIN_USERS, userId, "/").execute();
    }

    @Override
    public SystemUser getSystemUserInfo(String userId) {
        checkNotNull(userId);
        String url = ClientConstants.SYSTEM_USERS_AUTHINFO.replace("{userId}", userId);
        return get(SystemUser.class, url).execute();
    }

    @Override
    public List<AssetAccount> getAssetAccounts(String userId) {
        checkNotNull(userId);
        String url = ClientConstants.SYSTEM_USER_ACCOUNT.replace("{userId}", userId);
        List<AssetAccount> systemUsers = get(AssetAccount.class, url).executeList();
        return systemUsers;
    }

    @Override
    public AssetAccount getAssetAccountPassword(String assetAccountId, String syncPassword) {
        checkNotNull(assetAccountId);
        Confirm confirm = new Confirm();
        confirm.setSecret_key(syncPassword);
        String str = ClientConstants.MFA_CONFIRM;
        post(String.class, str).entity(confirm).execute();
        String url = ClientConstants.ASSET_ACCOUNT_PASSWORD.replace("{assetAccountId}", assetAccountId);
        return get(AssetAccount.class, url).execute();
    }

    @Override
    public ActionResponse deleteAdminUser(String userId) {
        checkNotNull(userId);
        return deleteWithResponse(ClientConstants.ADMIN_USERS, userId, "/").execute();
    }

    @Override
    public AdminUser updateAdminUser(AdminUser adminuser) {
        checkNotNull(adminuser);
        return patch(AdminUser.class, ClientConstants.ADMIN_USERS, adminuser.getId(), "/").json(JSON.toJSONString(adminuser)).execute();
    }

    @Override
    public AdminUser createAdminUser(AdminUser adminuser) {
        checkNotNull(adminuser);
        return post(AdminUser.class, uri(ClientConstants.ADMIN_USERS))
                .json(JSON.toJSONString(adminuser))
                .execute();
    }

    @Override
    public AdminUser updateAdminUserAuthInfo(AdminUser adminUser) {
        String url = ClientConstants.ADMIN_USERS_AUTH.replace("{id}", adminUser.getId());
        return patch(AdminUser.class, url).json(JSON.toJSONString(adminUser)).execute();
    }

    @Override
    public List<AssetAccount> listSystemUserByAsset(String assetId) {
        return get(AssetAccount.class, uri(ClientConstants.ASSET_SYSTEM_USERS) + "?display=1&draw=1&asset=" + assetId).executeList();
    }

    //系统用户
    @Override
    public List<SystemUser> listSystemUser() {
        return get(SystemUser.class, uri(ClientConstants.SYSTEM_USERS)).executeList();
    }

    @Override
    public SystemUser getSystemUser(String userId) {
        checkNotNull(userId);
        return get(SystemUser.class, ClientConstants.SYSTEM_USERS, userId, "/").execute();
    }

    @Override
    public ActionResponse deleteSystemUser(String userId) {
        checkNotNull(userId);
        return deleteWithResponse(ClientConstants.SYSTEM_USERS, userId, "/").execute();
    }

    @Override
    public SystemUser updateSystemUserAuthInfo(SystemUser systemUser) {
        String url = ClientConstants.SYSTEM_USERS_AUTHINFO.replace("{id}", systemUser.getId());
        return patch(SystemUser.class, url).json(JSON.toJSONString(systemUser)).execute();
    }

    @Override
    public SystemUser updateSystemUserPush(String userId) {
        checkNotNull(userId);
        return get(SystemUser.class, ClientConstants.SYSTEM_USERS_PUSH, userId, "/").execute();
    }

    @Override
    public SystemUser updateSystemUser(SystemUser systemuser) {
        checkNotNull(systemuser);
        return patch(SystemUser.class, ClientConstants.SYSTEM_USERS, systemuser.getId(), "/").json(JSON.toJSONString(systemuser)).execute();
    }

    @Override
    public SystemUser createSystemUser(SystemUser systemuser) {
        checkNotNull(systemuser);
        return post(SystemUser.class, uri(ClientConstants.SYSTEM_USERS))
                .json(JSON.toJSONString(systemuser))
                .execute();
    }

    @Override
    public List<AssetsDomain> listAssetsDomain() {
        return get(AssetsDomain.class, uri(ClientConstants.DOMAINS)).executeList();
    }

    @Override
    public AssetsDomain createAssetsDomain(AssetsDomain assetsDomain) {
        checkNotNull(assetsDomain);
        return post(AssetsDomain.class, uri(ClientConstants.DOMAINS))
                .json(JSON.toJSONString(assetsDomain))
                .execute();
    }

    @Override
    public AssetsDomain updateAssetsDomain(AssetsDomain assetsDomain) {
        checkNotNull(assetsDomain);
        return patch(AssetsDomain.class, ClientConstants.DOMAINS, assetsDomain.getId(), "/").json(JSON.toJSONString(assetsDomain)).execute();
    }

    @Override
    public AssetsDomain getAssetsDomain(String assetsDomainId) {
        checkNotNull(assetsDomainId);
        return get(AssetsDomain.class, ClientConstants.DOMAINS, assetsDomainId, "/").execute();
    }

    @Override
    public ActionResponse deleteAssetsDomain(String assetsDomainId) {
        checkNotNull(assetsDomainId);
        return deleteWithResponse(ClientConstants.DOMAINS, assetsDomainId, "/").execute();
    }

    @Override
    public List<AssetsGateway> listAssetsGateway() {
        return get(AssetsGateway.class, uri(ClientConstants.GATEWAYS)).executeList();
    }

    @Override
    public AssetsGateway createAssetsGateway(AssetsGateway assetsGateway) {
        checkNotNull(assetsGateway);
        return post(AssetsGateway.class, uri(ClientConstants.GATEWAYS))
                .json(JSON.toJSONString(assetsGateway))
                .execute();
    }

    @Override
    public AssetsGateway updateAssetsGateway(AssetsGateway assetsGateway) {
        checkNotNull(assetsGateway);
        return patch(AssetsGateway.class, ClientConstants.GATEWAYS, assetsGateway.getId(), "/").json(JSON.toJSONString(assetsGateway)).execute();
    }

    @Override
    public AssetsGateway getAssetsGateway(String assetsGatewayId) {
        checkNotNull(assetsGatewayId);
        return get(AssetsGateway.class, ClientConstants.GATEWAYS, assetsGatewayId, "/").execute();
    }

    @Override
    public ActionResponse deleteAssetsGateway(String assetsGatewayId) {
        checkNotNull(assetsGatewayId);
        return deleteWithResponse(ClientConstants.GATEWAYS, assetsGatewayId, "/").execute();
    }


}
