package client;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.builder.ClientBuilder;
import com.jumpserver.sdk.builder.JMSClient;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.httpclient.build.Config;
import com.jumpserver.sdk.jumpserver.permissions.v3.Request.AssetsPermissionRequest;
import com.jumpserver.sdk.jumpserver.role.v3.RoleService;
import com.jumpserver.sdk.model.Role;
import com.jumpserver.sdk.model.account.*;
import com.jumpserver.sdk.model.permission.v3.AssetsPermission;
import com.jumpserver.sdk.model.user.User;
import com.jumpserver.sdk.model.usergroup.UserGroup;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author yankaijun
 * @date 2018/10/15 下午4:26
 */
public class JMSClientTest {

    private String endPoint;
    private String keyId;
    private String keySecret;
    private String orgId;

    @Before
    public void prepare() {
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = this.getClass().getResourceAsStream("/credential.property");
            properties.load(resourceAsStream);
            endPoint = (String) properties.get("endPoint");
            keyId = (String) properties.get("keyId");
            keySecret = (String) properties.get("keySecret");
            orgId = (String) properties.get("orgId");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void token() {
        try {
            JMSClient os;
            ClientBuilder credentials = new ClientBuilder()
                    .endpoint(endPoint)
                    .credentials(keyId, keySecret)
                    .withConfig(Config.newConfig().withConnectionTimeout(10000).withReadTimeout(10000));
            if (StringUtils.isBlank(orgId)) {
                os = credentials.authenticate();
            } else {
                os = credentials.header(ClientConstants.X_JMS_ORG, "00000000-0000-0000-0000-000000000001").authenticate();
            }
            System.out.println("=======JMSClientTest======");
            System.out.println(os.getApiKey());
            RoleService roles = os.roles();
            List<Role> orgRoles = roles.selectOrgRoles();
            System.out.println(orgRoles);
            List<Role> selectSystemRoles = roles.selectSystemRoles();
            System.out.println(selectSystemRoles);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void tokenWithOrgChange() {
        JMSClient client = new ClientBuilder()
                .endpoint(endPoint)
                .credentials(keyId, keySecret)
                .header(ClientConstants.X_JMS_ORG, "2107470f-1107-4352-84fc-8de6ef3b7fe8")
                .withConfig(Config.newConfig().withConnectionTimeout(10000).withReadTimeout(10000)).authenticate();
        System.out.println(client.getHeaders());
        List<UserGroup> userGroups = client.users().userGroups();
        userGroups.stream().forEach(u -> System.out.println(u.getName()));

        //切换组织
        client.getHeaders().put(ClientConstants.X_JMS_ORG, "84d8a23e-5bd9-410e-9438-756054daf128");
        System.out.println(client.getHeaders());
        List<UserGroup> userGroups2 = client.users().userGroups();
        userGroups2.stream().forEach(u -> System.out.println(u.getName()));
    }


    @Test
    public void testAccountTemplates() {

        JMSClient client = new ClientBuilder()
                .endpoint("")
                .credentials("", "")
                .header(ClientConstants.X_JMS_ORG, "")
                .withConfig(Config.newConfig().withConnectionTimeout(10000).withReadTimeout(10000)).authenticate();
        System.out.println(client.getHeaders());
        List<AccountTemplate> list = client.accountTemplateV3().list();
        System.out.printf("length" +list.size());
        List<AccountTemplate> accountTemplates = client.accountTemplateV3().list();

        User userInfo = client.users().getUserInfo();
        AccountTemplateRequest request = new AccountTemplateRequest();
        request.setName("lbs");
        request.setUsername("lbs");
        request.setSecret_type(SecretType.ssh_key);
        request.setIs_sync_account(true);
        request.setIs_active(true);
        AccountTemplate accountTemplate = client.accountTemplateV3().create(request);
    }

    @Test
    public void testCreateByAccountTemplate() {

        JMSClient client = new ClientBuilder()
                .endpoint("https://north-jms-dev.fit2cloud.com/")
                .credentials("4b823756-d9d1-49ec-b79b-2c69e6a911fd", "f1b7a7e3-8bce-4352-8459-78174588d48c")
                .header(ClientConstants.X_JMS_ORG, "")
                .withConfig(Config.newConfig().withConnectionTimeout(10000).withReadTimeout(10000)).authenticate();
        AssetAccountRequest accountRequest = new AssetAccountRequest();
        accountRequest.setTemplate("773b0d36-2de5-412f-9ff8-7684c40f1efa");
        accountRequest.setName("lbs12345");
        accountRequest.setUsername("lbs12345");
        accountRequest.setSecret_type(SecretType.ssh_key);
        accountRequest.setPrivileged(false);
        accountRequest.setPush_now(true);
        accountRequest.setAsset("d270f049-8b76-442b-b1d4-9889f6567e1c");
        List<AssetAccount> byAccountTemplate = client.assetAccountV3().createByAccountTemplate(Arrays.asList(accountRequest));
    }
}
