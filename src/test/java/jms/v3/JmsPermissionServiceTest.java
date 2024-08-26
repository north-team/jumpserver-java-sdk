package jms.v3;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.jumpserver.permissions.v3.Request.AssetsPermissionRequest;
import com.jumpserver.sdk.model.permission.v3.AssetsPermission;
import jms.v2.CommonBeforeTest;
import org.junit.Test;

import java.util.List;

/**
 * 授权API调用相关测试用例
 */
public class JmsPermissionServiceTest extends CommonBeforeTest {

    private String permissionId = "41864956-6d00-4e96-b7fd-33ae4adf2643";

    @Test
    public void addAssetsPermission() {
        String paramStr = "{\n" +
                "    \"assets\": [\n" +
                "        \"0520beb5-7e2e-458e-9795-1a46e467466b\"\n" +
                "    ],\n" +
                "    \"nodes\": [\n" +
                "    ],\n" +
                "    \"accounts\": [\n" +
                "        \"@ALL\"\n" +
                "    ],\n" +
                "    \"actions\": [\n" +
                "        \"connect\",\n" +
                "        \"upload\",\n" +
                "        \"download\",\n" +
                "        \"copy\",\n" +
                "        \"paste\"\n" +
                "    ],\n" +
                "    \"is_active\": true,\n" +
                "    \"date_start\": \"2023-06-14T09:58:43.320Z\",\n" +
                "    \"date_expired\": \"2123-05-21T09:58:43.320Z\",\n" +
                "    \"name\": \"tyhtestAuth6\",\n" +
                "    \"users\": [\n" +
                "        \"77b62a3d-3296-4b0d-904f-dbd5845fa3c4\"\n" +
                "    ],\n" +
                "    \"user_groups\": [\n" +
                "\"08758b8c-00bc-46d8-9557-0ef9f3a60b74\",\n" +
                "\"992ab02e-a543-40d4-affc-b1b794b0c9ae\"\n" +
                "    ]\n" +
                "}";
        AssetsPermissionRequest object = JSON.parseObject(paramStr, AssetsPermissionRequest.class);

        os.getHeaders().put(ClientConstants.X_JMS_ORG, "00000000-0000-0000-0000-000000000002");
        AssetsPermission objectBack = os.permissionsV3().createAssetsPermission(object);
        System.out.println(objectBack.getId());
    }

    @Test
    public void getAssetsPermission() {
        AssetsPermission object = os.permissionsV3().getAssetsPermission("16f05dd6-2083-499d-b74d-4cb8caf1038f");
        System.out.println(object.getName());
    }
    @Test
    public  void getPermissionsWithAssets() {
        List<AssetsPermission> list = os.assetsV3().getPermissionsWithAssets("4f41c3b1-7523-4e42-b8c2-6e7fc9998553","3c4f5cc6-c729-408a-8c59-f019eec99f0a");
        System.out.println(list.size());
        for (AssetsPermission object : list) {
            System.out.println(object.getId());
            System.out.println(object.getName());
        }
    }

    @Test
    public void updateAssetsPermission() {
        String paramStr = "{\n" +
                "    \"assets\": [\n" +
                "        \"0520beb5-7e2e-458e-9795-1a46e467466b\"\n" +
                "    ],\n" +
                "    \"nodes\": [\n" +
                "    ],\n" +
                "    \"accounts\": [\n" +
                "        \"@ALL\"\n" +
                "    ],\n" +
                "    \"actions\": [\n" +
                "        \"connect\",\n" +
                "        \"upload\",\n" +
                "        \"download\",\n" +
                "        \"copy\",\n" +
                "        \"paste\"\n" +
                "    ],\n" +
                "    \"is_active\": true,\n" +
                "    \"date_start\": \"2023-06-14T09:58:43.320Z\",\n" +
                "    \"date_expired\": \"2123-05-21T09:58:43.320Z\",\n" +
                "    \"name\": \"tyhtestAuth6\",\n" +
                "    \"users\": [\n" +
                "        \"77b62a3d-3296-4b0d-904f-dbd5845fa3c4\"\n" +
                "    ],\n" +
                "    \"user_groups\": [\n" +
                "\"08758b8c-00bc-46d8-9557-0ef9f3a60b74\",\n" +
                "\"992ab02e-a543-40d4-affc-b1b794b0c9ae\"\n" +
                "    ]\n" +
                "}";
        AssetsPermissionRequest object = JSON.parseObject(paramStr, AssetsPermissionRequest.class);
        AssetsPermission objectBack = os.permissionsV3().updateAssetsPermission(object);
        System.out.println(objectBack.getId());
    }

    @Test
    public void AssetsPermission() {
        List<AssetsPermission> list = os.permissionsV3().list();
        System.out.println(list.size());
        for (AssetsPermission object : list) {
            System.out.println(object.getId());
            System.out.println(object.getName());
        }
    }

    @Test
    public void removePermissionAsset() {
        String permissionId = "7bf91adc-21f7-4d65-a729-210821b40fef";
//        String userId = "f0a96c87-80b1-45da-8b18-9132c985e576";
        String userId = "20cc575b-af97-4fb3-a404-6a69a5a9691e";
//        os.permissionsV3().removePermissionUser(permissionId, userId);
        os.permissionsV3().createPermissionUser(permissionId, userId);
//        os.permissionsV3().removePermissionAsset("030dcb45-578d-4462-bd48-3a4ff49c69b5", "030dcb45-578d-4462-bd48-3a4ff49c69b5");
//        os.permissionsV3().createPermissionAsset("030dcb45-578d-4462-bd48-3a4ff49c69b5", "030dcb45-578d-4462-bd48-3a4ff49c69b5");
//        os.permissionsV3().removePermissionUserGroup("030dcb45-578d-4462-bd48-3a4ff49c69b5", "811a7b4a-ba21-4427-ba73-a1d6e2851431");
//        os.permissionsV3().createPermissionUserGroup("030dcb45-578d-4462-bd48-3a4ff49c69b5", "811a7b4a-ba21-4427-ba73-a1d6e2851431");
    }

}
