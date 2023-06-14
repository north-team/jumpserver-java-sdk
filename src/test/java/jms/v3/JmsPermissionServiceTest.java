package jms.v3;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.jumpserver.permissions.v3.PermissionV3Service;
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
                "        {\n" +
                "            \"pk\": \"1ecb988f-ded3-4b57-bc8f-808467abbe2f\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"pk\": \"f45c6018-8033-4c38-9936-4e0551752440\"\n" +
                "        }\n" +
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
                "        {\n" +
                "            \"pk\": \"14d5e9fb-aad5-4fab-b4a2-308ea4d6d2f8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"pk\": \"158a375a-802d-49dc-9f44-7a231ee25d1f\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"user_groups\": [\n" +
                "        {\n" +
                "            \"pk\": \"08758b8c-00bc-46d8-9557-0ef9f3a60b74\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"pk\": \"992ab02e-a543-40d4-affc-b1b794b0c9ae\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        AssetsPermission object = JSON.parseObject(paramStr, AssetsPermission.class);

        os.getHeaders().put(ClientConstants.X_JMS_ORG, "00000000-0000-0000-0000-000000000002");
        com.jumpserver.sdk.model.permission.AssetsPermission objectBack = os.permissionsV3().createAssetsPermission(object);
        System.out.println(objectBack.getId());
    }

    @Test
    public void getAssetsPermission() {
        com.jumpserver.sdk.model.permission.AssetsPermission object = os.permissionsV3().getAssetsPermission("16f05dd6-2083-499d-b74d-4cb8caf1038f");
        System.out.println(object.getName());
    }

    @Test
    public void updateAssetsPermission() {
        String paramStr = "{\n" +
                "    \"assets\": [\n" +
                "        \"0520beb5-7e2e-458e-9795-1a46e467466b\"\n" +
                "    ],\n" +
                "    \"nodes\": [\n" +
                "        {\n" +
                "            \"pk\": \"1ecb988f-ded3-4b57-bc8f-808467abbe2f\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"pk\": \"f45c6018-8033-4c38-9936-4e0551752440\"\n" +
                "        }\n" +
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
                "    \"id\": \"48e66510-f8df-4a13-8bd5-27fa11019dde\",\n" +
                "    \"date_start\": \"2023-06-14T09:58:43.320Z\",\n" +
                "    \"date_expired\": \"2123-05-21T09:58:43.320Z\",\n" +
                "    \"name\": \"tyhtestAuth6\",\n" +
                "    \"users\": [\n" +
                "        {\n" +
                "            \"pk\": \"14d5e9fb-aad5-4fab-b4a2-308ea4d6d2f8\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"pk\": \"158a375a-802d-49dc-9f44-7a231ee25d1f\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"user_groups\": [\n" +
                "        {\n" +
                "            \"pk\": \"08758b8c-00bc-46d8-9557-0ef9f3a60b74\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"pk\": \"992ab02e-a543-40d4-affc-b1b794b0c9ae\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        AssetsPermission object = JSON.parseObject(paramStr, AssetsPermission.class);
        com.jumpserver.sdk.model.permission.AssetsPermission objectBack = os.permissionsV3().updateAssetsPermission(object);
        System.out.println(objectBack.getId());
    }

    @Test
    public void AssetsPermission() {
        List<com.jumpserver.sdk.model.permission.AssetsPermission> list = os.permissionsV3().list();
        System.out.println(list.size());
        for (com.jumpserver.sdk.model.permission.AssetsPermission object : list) {
            System.out.println(object.getId());
            System.out.println(object.getName());
        }
    }

    @Test
    public void deleteAssetsPermission() {
        ActionResponse delete = os.permissionsV3().deleteAssetsPermission("e6f3d2cd-d875-48db-805a-5e37bb83ce7a");
        System.out.println(delete);
    }

}
