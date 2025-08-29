package jms.v2;

import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.jumpserver.account.v3.ChangeSecretAutomationsService;
import com.jumpserver.sdk.model.organization.Org;
import com.jumpserver.sdk.model.organization.OrgUsers;
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
        List<ChangeSecretAutomationsService> list = os.changeSecretAutomationsV3().list();

        System.out.println(list.size());

    }






}
