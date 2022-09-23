package com.jumpserver.sdk.v2.jumpserver.assets;

import com.jumpserver.sdk.v2.common.ActionResponse;
import com.jumpserver.sdk.v2.model.*;

import java.util.List;

/**
 * @author yankaijun
 * @date 2018/10/16 上午10:35
 */
public interface AssertsService {

    //节点
    List<AssetsNode> listAssetsNode();

    AssetsNode getAssetsNode(String nodeId);

    AssetsNode updateAssetsNode(AssetsNode node);

    AssetsNode createAssetsNode(AssetsNode node);

    ActionResponse deleteAssetsNode(String nodeId);

    ActionResponse deleteAssetsNodeWithAssetCheck(String nodeId);

    ActionResponse deleteAssetsNodeWithAssetCheckCircle(String nodeId);

    //节点下的节点
    AssetsNode createAssetsNodeChildren(AssetsNode node);

    //在节点下新建一个指定信息的节点
    AssetsNode createAssetsNodeChildren(String nodeId, AssetsNode node);

    AssetsNode updateAssetsNodeChildren(String nodeId, AssetsNode node);

    List<AssetsNode> listAssetsNodeChildren();

    List<AssetsNode> listAssetsNodeIdChildren(String nodeId);

    //资产
    List<Asset> list();

    Asset get(String assetId);

    Asset update(Asset asset);

    Asset create(Asset asset);

    ActionResponse delete(String assetId);

    //管理用户
    List<AdminUser> listAdminUser();

    AdminUser getAdminUser(String userId);

    SystemUser getSystemUserInfo(String userId);

    List<AssetAccount> getAssetAccounts(String userId);

    AssetAccount getAssetAccountPassword(String assetAccountId, String syncPassword);

    AdminUser updateAdminUser(AdminUser adminuser);

    AdminUser createAdminUser(AdminUser adminuser);

    ActionResponse deleteAdminUser(String userId);

    AdminUser updateAdminUserAuthInfo(AdminUser adminuser);

    //资产可用系统用户
    List<AssetAccount> listSystemUserByAsset(String assetId);

    //系统用户
    List<SystemUser> listSystemUser();

    SystemUser getSystemUser(String userId);

    SystemUser updateSystemUser(SystemUser systemuser);

    SystemUser createSystemUser(SystemUser systemuser);

    ActionResponse deleteSystemUser(String userId);

    SystemUser updateSystemUserAuthInfo(SystemUser systemUser);

    SystemUser updateSystemUserPush(String userId);

    //网域
    List<AssetsDomain> listAssetsDomain();

    AssetsDomain createAssetsDomain(AssetsDomain assetsDomain);

    AssetsDomain updateAssetsDomain(AssetsDomain assetsDomain);

    AssetsDomain getAssetsDomain(String assetsDomainId);

    ActionResponse deleteAssetsDomain(String assetsDomainId);

    //网域-网关
    List<AssetsGateway> listAssetsGateway();

    AssetsGateway createAssetsGateway(AssetsGateway assetsGateway);

    AssetsGateway updateAssetsGateway(AssetsGateway assetsGateway);

    AssetsGateway getAssetsGateway(String assetsGatewayId);

    ActionResponse deleteAssetsGateway(String assetsGatewayId);

}
