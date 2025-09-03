package jms.v2;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.model.account.ChangeSecretAutomation;
import com.jumpserver.sdk.model.account.ChangeSecretAutomationRequest;
import com.jumpserver.sdk.model.organization.Org;
import org.junit.Test;
import sun.tools.jar.resources.jar;

import java.util.Collections;
import java.util.List;

/**
 * 组织API调用相关测试用例
 */
public class JmsAutomationsServiceTest extends CommonBeforeTest{

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
        changeSecretAutomationsRequest.setId("124ff7a8-1ceb-4097-98f6-ba6c43a364f1");
        changeSecretAutomationsRequest.setName("ApiCreateTest-update");
        ChangeSecretAutomation res = os.changeSecretAutomationV3().update(changeSecretAutomationsRequest);
        System.out.println(JSON.toJSONString(res));
    }


    @Test
    public void delChangeSecretAutomations() {
        String uuid = "124ff7a8-1ceb-4097-98f6-ba6c43a364f1";
        os.changeSecretAutomationV3().delete(uuid);
    }


}
