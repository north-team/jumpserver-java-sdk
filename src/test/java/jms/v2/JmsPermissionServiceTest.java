package jms.v2;

import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.permission.v2.AssetsPermission;
import org.junit.Test;
import java.util.List;

/**
 * 授权API调用相关测试用例
 */
public class JmsPermissionServiceTest extends CommonBeforeTest{

    private String permissionId = "41864956-6d00-4e96-b7fd-33ae4adf2643";

    @Test
    public void addAssetsPermission() {
        AssetsPermission object = new AssetsPermission();
        object.setId("9111c19a-a74e-4b55-9af2-81d53cab6c35");
        object.setUser_groups(new String[]{"e25c1675-1715-4de6-9ce9-d8f466294963"});
        object.setAssets(new String[]{"5e1eb5a4-5c10-4383-ab74-4bccd0b0a234"});
        object.setName("API授权规则test");
        object.setSystem_users(null);
        os.getHeaders().put(ClientConstants.X_JMS_ORG, "00000000-0000-0000-0000-000000000002");
        AssetsPermission objectBack = os.permissions().updateAssetsPermission(object);
        System.out.println(objectBack.getId());
    }

    @Test
    public void getAssetsPermission() {
        AssetsPermission object = os.permissions().getAssetsPermission(permissionId);
        System.out.println(object.getName());
    }

    @Test
    public void updateAssetsPermission() {
        AssetsPermission object = new AssetsPermission();
        object.setId(permissionId);
        object.setName("niubi");
        AssetsPermission objectBack = os.permissions().updateAssetsPermission(object);
        System.out.println(objectBack.getId());
    }

    @Test
    public void AssetsPermission() {
        List<AssetsPermission> list = os.permissions().list();
        System.out.println(list.size());
        for (AssetsPermission object : list) {
            System.out.println(object.getId());
            System.out.println(object.getName());
        }
    }

    @Test
    public void deleteAssetsPermission() {
        ActionResponse delete = os.permissions().deleteAssetsPermission(permissionId);
        System.out.println(delete);
    }

}
