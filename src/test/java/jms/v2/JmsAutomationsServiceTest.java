package jms.v2;

import com.alibaba.fastjson.JSON;
import com.jumpserver.sdk.model.account.ChangeSecretAutomation;
import com.jumpserver.sdk.model.organization.Org;
import org.junit.Test;

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
        List<ChangeSecretAutomation> list = os.changeSecretAutomationV3().list();
        System.out.println(JSON.toJSONString(list));

    }






}
