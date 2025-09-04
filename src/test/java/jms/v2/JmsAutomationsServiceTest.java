package jms.v2;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.model.account.ChangeSecretAutomation;
import com.jumpserver.sdk.model.account.ChangeSecretAutomationRequest;
import com.jumpserver.sdk.model.organization.Org;
import org.junit.Test;
import sun.tools.jar.resources.jar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 组织API调用相关测试用例
 */
public class JmsAutomationsServiceTest extends CommonBeforeTest{

    private static final String changeSecretAutomationsId = "c303f342-e50e-4ebd-9a4a-e7dc9280b86d";


    @Test
    public void Org() {
        List<Org> list = os.orgs().listOrg();
        System.out.println(list.size());
        for (Org object : list) {
            System.out.println(object.getId() + " \t\t" + object.getName());
        }
    }

    @Test
    public void listChangeSecretAutomations() {
        List<ChangeSecretAutomation> res = os.changeSecretAutomationV3().list();
        System.out.println(JSON.toJSONString(res));

    }

    @Test
    public void CreateChangeSecretAutomations() {
        ChangeSecretAutomationRequest changeSecretAutomationsRequest = new ChangeSecretAutomationRequest();
        changeSecretAutomationsRequest.setAccounts(Collections.singletonList("root"));
        changeSecretAutomationsRequest.setName("ApiCreateTest");
        changeSecretAutomationsRequest.setSecretType("password");
        changeSecretAutomationsRequest.setSecretStrategy("random");
        changeSecretAutomationsRequest.setIsActive(true);
        changeSecretAutomationsRequest.setIsPeriodic(false);

        ChangeSecretAutomationRequest.PasswordRulesDTO passwordRules = new ChangeSecretAutomationRequest.PasswordRulesDTO();
        passwordRules.setDigit(true);
        passwordRules.setLength(15);
        passwordRules.setLowercase(true);
        passwordRules.setSymbol(true);
        passwordRules.setUppercase(true);

        changeSecretAutomationsRequest.setPasswordRules(passwordRules);
        ChangeSecretAutomation res = os.changeSecretAutomationV3().create(changeSecretAutomationsRequest);
        System.out.println(JSON.toJSONString(res));
    }

    @Test
    public void updateChangeSecretAutomations() {
        ChangeSecretAutomationRequest changeSecretAutomationsRequest = new ChangeSecretAutomationRequest();
        changeSecretAutomationsRequest.setId(changeSecretAutomationsId);
        changeSecretAutomationsRequest.setName("ApiCreateTest-update");
        ChangeSecretAutomation res = os.changeSecretAutomationV3().update(changeSecretAutomationsRequest);
        System.out.println(JSON.toJSONString(res));
    }


    @Test
    public void delChangeSecretAutomations() {
        os.changeSecretAutomationV3().delete(changeSecretAutomationsId);
    }

    @Test
    public void addAsset() {
        List<String> assetIds = Arrays.asList("2edc3fda-3b73-4f3a-928e-86d76f327de7");
        os.changeSecretAutomationV3().addAsset(changeSecretAutomationsId, assetIds);
    }
    @Test
    public void removeAsset() {
        List<String> assetIds = Arrays.asList("2edc3fda-3b73-4f3a-928e-86d76f327de7");
        os.changeSecretAutomationV3().removeAsset(changeSecretAutomationsId, assetIds);
    }



}
