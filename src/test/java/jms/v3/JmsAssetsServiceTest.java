package jms.v3;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jumpserver.sdk.common.ActionResponse;
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
        String paramStr = "{\n" +
                "    \"id\":\"0520beb5-7e2e-458e-9795-1a46e467466b\",\n" +
                "    \"platform\": {\n" +
                "        \"pk\": 1\n" +
                "    },\n" +
                "        \"nodes\": [\n" +
                "        {\n" +
                "            \"pk\": \"d3a51c53-241e-4bf0-92dd-a572a9a91866\"\n" +
                "        }\n" +
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
                "    \"accounts\": [\n" +
                "        {\n" +
                "            \"privileged\": true,\n" +
                "            \"secret_type\": \"password\",\n" +
                "            \"push_now\": false,\n" +
                "            \"on_invalid\": \"error\",\n" +
                "            \"is_active\": true,\n" +
                "            \"name\": \"tyh1\",\n" +
                "            \"username\": \"tyh1\",\n" +
                "            \"secret\": \"QDYZcqr2Ud4HBtKMEOHf4wRYak02zDsn5UEz/Hsi3uDlF3nfbdxyfXooHN7CQ6lgZfkuUFKLw8BYHl3Q+y45ebKBRu7fqzFB0UdxXIpwc/aHjwCfaGRFIiivK1K8ucZ+emhAi78JpRCFI10MJKutEABAgK19xzYyDMBucN0MRt8=:1viS34HPOlJ9dNmLFnQE9w==\",\n" +
                "            \"comment\": \"this is comment\"        }\n" +
                "    ]\n" +
                "}";
        Asset asset = JSON.parseObject(paramStr, Asset.class);
        Asset assetResult = os.assetsV3().create(asset);
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
                "    \"platform\": {\n" +
                "        \"pk\": 1\n" +
                "    },\n" +
                "        \"nodes\": [\n" +
                "        {\n" +
                "            \"pk\": \"d3a51c53-241e-4bf0-92dd-a572a9a91866\"\n" +
                "        }\n" +
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
        Asset asset = JSON.parseObject(paramStr, Asset.class);
        Asset assetResult = os.assetsV3().update(asset);
        String sss = "sss";
    }
}
