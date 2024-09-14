package jms.v2;

import com.jumpserver.sdk.builder.ClientBuilder;
import com.jumpserver.sdk.builder.JMSClient;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.common.eunms.PermissionExecInfoEnum;
import org.apache.commons.lang.StringUtils;
import org.junit.Before;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonBeforeTest {

    protected JMSClient os;
    protected String orgId;
    private String endPoint;
    private String keyId;
    private String keySecret;

    @Before
    public void initClient() {
        try {
            Properties properties = new Properties();
//            InputStream resourceAsStream = this.getClass().getResourceAsStream("/credential.property");
            FileReader credentialFileReader = new FileReader("/opt/fit2cloud/credential.properties");
            properties.load(credentialFileReader);
            endPoint = (String) properties.get("endPoint");
            keyId = (String) properties.get("keyId");
            keySecret = (String) properties.get("keySecret");
            orgId = (String) properties.get("orgId");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ClientBuilder credentials = new ClientBuilder()
                .endpoint(endPoint)
                .credentials( keyId, keySecret);
        if (StringUtils.isBlank(orgId)) {
            os = credentials.authenticate();
        } else {
            os = credentials.header(ClientConstants.X_JMS_ORG, orgId).authenticate();
        }
    }


    public static void main(String[] args) {
        System.out.println(PermissionExecInfoEnum.getPermissionExecInfo(ClientConstants.ORG));
    }
}
