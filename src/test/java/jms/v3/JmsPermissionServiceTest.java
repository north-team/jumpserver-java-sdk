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
    public void deleteAssetsPermission() {
        ActionResponse delete = os.permissionsV3().deleteAssetsPermission("e6f3d2cd-d875-48db-805a-5e37bb83ce7a");
        System.out.println(delete);
    }

}
