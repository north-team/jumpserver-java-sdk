package jms.v3;

import com.alibaba.fastjson.JSONObject;
import com.jumpserver.sdk.model.account.AssetAccount;
import com.jumpserver.sdk.model.account.AssetAccountRequest;
import com.jumpserver.sdk.model.account.SecretType;
import jms.v2.CommonBeforeTest;
import org.junit.Test;


/**
 * @author : houchen
 */
public class JmsAaccountServerTest extends CommonBeforeTest {

    @Test
    public void updateAccount() {
        AssetAccountRequest accountRequest = new AssetAccountRequest();
        accountRequest.setId("a917134b-7093-4241-b1a7-9c70a3d3e9c6");
//        accountRequest.setName("asdfasf");
//        accountRequest.setUsername("asdfasf");
        accountRequest.setSecret_type(SecretType.password);
        accountRequest.setPush_now(false);
        accountRequest.setIs_active(true);
        accountRequest.setComment("");
        accountRequest.setSecret("test123456");
        AssetAccount asset = os.assetAccountV3().update(accountRequest);
        System.out.println(JSONObject.toJSONString(asset));
    }

    @Test
    public void createAccount() {
        AssetAccountRequest accountRequest = new AssetAccountRequest();
        accountRequest.setId("a917134b-7093-4249-b1a7-9c70a3d3e9c6");
        accountRequest.setName("asdfasf");
        accountRequest.setUsername("asdfasf");
        accountRequest.setAsset("0a8c905e-045b-4252-8ae3-9f63481309e7");
        accountRequest.setSecret_type(SecretType.password);
        accountRequest.setPush_now(false);
        accountRequest.setIs_active(true);
        accountRequest.setComment("");
        accountRequest.setSecret("test123456");
        AssetAccount asset = os.assetAccountV3().create(accountRequest);
        System.out.println(JSONObject.toJSONString(asset));
    }

    @Test
    public void getAccount() {
        String accountId = "a917134b-7093-4241-b1a7-9c70a3d3e9c6";
        AssetAccount asset = os.assetAccountV3().getAccountSecret(accountId);
        System.out.println(JSONObject.toJSONString(asset));
    }
}
