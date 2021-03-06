package activityServer.com.apiTest;

import activityServer.com.utils.api;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import org.apache.http.HttpResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class invite_list {
  private HttpResponse response;
  private HashMap<String,String> parameter = new HashMap();

  @Test(enabled = true, description = "Api GET /api/wallet/invite/list test")
  public void test001InviteList() throws Exception {
    parameter.put("address", api.testAddressBase64);
    parameter.put("system","Android");
    parameter.put("deviceId","xxxxxx2x");
    response = api.inviteList(parameter);

    JSONObject inviteListInfo = api.parseResponseContent(response);
    api.printJsonContent(inviteListInfo);

    Assert.assertEquals(inviteListInfo.getString("message"),"OK");
    JSONObject inviteList = inviteListInfo.getJSONObject("data");
    api.printJsonContent(inviteList);
  }
}
