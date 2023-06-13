package jms.v3;

import com.alibaba.fastjson.JSONObject;
import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.common.ClientConstants;
import com.jumpserver.sdk.model.asset.v2.AssetAccount;
import com.jumpserver.sdk.model.asset.v3.Asset;
import com.jumpserver.sdk.model.asset.v3.DescribeAsset;
import com.jumpserver.sdk.model.assetgroup.AssetsNode;
import jms.v2.CommonBeforeTest;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.List;

/**
 * 资产API调用相关测试用例
 */
public class JmsAssetsServiceTest extends CommonBeforeTest{


    @Test
    public void getAsset() {
        List<Asset> asset = os.assetsV3().getAsserts(new DescribeAsset());
        System.out.println(JSONObject.toJSONString(asset));
    }
}
