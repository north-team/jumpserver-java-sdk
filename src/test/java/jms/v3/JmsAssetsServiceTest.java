package jms.v3;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jumpserver.sdk.common.ActionResponse;
import com.jumpserver.sdk.model.asset.v3.AssetRequest;
import com.jumpserver.sdk.model.asset.v3.Asset;
import com.jumpserver.sdk.model.asset.v3.DescribeAsset;
import jms.v2.CommonBeforeTest;
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

    @Test
    public void createAsset() {
        String paramStr = "{\"address\":\"10.1.13.87\",\"id\":\"113d96fc-e0f7-415e-9e1a-c39632b9c089\",\"is_active\":true,\"name\":\"北区-张金力-跳板机-长期使用-勿关勿删\",\"nodes\":[\"811a7b4a-ba21-4427-ba73-a1d6e2851431\"],\"platform\":5,\"protocols\":[{\"name\":\"rdp\",\"port\":22}]}";
        AssetRequest assetRequest = JSON.parseObject(paramStr, AssetRequest.class);
        Asset assetResult = os.assetsV3().create(assetRequest);
        String sss = "sss";
    }

    @Test
    public void deleteAsset() {
        ActionResponse response = os.assetsV3().delete("0520beb5-7e2e-458e-9795-1a46e467466b");
        String sss = "sss";
    }

    @Test
    public void updateAsset() {
        String paramStr = "{\n" +
                "    \"id\":\"0520beb5-7e2e-458e-9795-1a46e467466b\",\n" +
                "    \"platform\": \n" +
                "        1\n" +
                "    ,\n" +
                "        \"nodes\": [\n" +
                "        {\n" +
                "            \"d3a51c53-241e-4bf0-92dd-a572a9a91866\"\n" +
                "        \n" +
                "    ],\n" +
                "    \"protocols\": [\n" +
                "        {\n" +
                "            \"name\": \"ssh\",\n" +
                "            \"port\": 22\n" +
                "        }\n" +
                "    ],\n" +
                "    \"labels\": [],\n" +
                "    \"is_active\": true,\n" +
                "    \"name\": \"tyh-test3\",\n" +
                "    \"address\": \"111.111.111.114\",\n" +
                "}";
        AssetRequest assetRequest = JSON.parseObject(paramStr, AssetRequest.class);
        Asset assetResult = os.assetsV3().update(assetRequest);
        String sss = "sss";
    }
}
