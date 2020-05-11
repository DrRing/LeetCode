package APItest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import base.OkHttpUtil;
import config_util.getProperty;
import constructor.operateExcel;

public class test_DemoApi {
	@DataProvider
	private Iterator<Object[]> SendSmsProvider() throws IOException {
		List<Object[]> result = new ArrayList<Object[]>();
		String sheetname = "Case_sendsms";
		String pathString = "C:\\Users\\Administrator\\Desktop\\0312.xlsx";
		List<Map<String, Object>> cases_list = operateExcel.excel_re_map(pathString, sheetname);
		Iterator it = cases_list.iterator();
		while (it.hasNext()) {
			result.add(new Object[] { it.next() });
		}
		return result.iterator();
	}

	@Test(dataProvider = "SendSmsProvider")
	public void testSend1(Map<String, Object> casedemo) {
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("captcha_url");
		if (casedemo.get("body") != null && casedemo.get("expected") != null) {
			Map<String, String> mapQ = JSONObject.parseObject(casedemo.get("body").toString(), Map.class);
			String param = JSON.toJSONString(mapQ);
			String resopseString = OkHttpUtil.postJson(url, param);
			JSONObject jsonObject = JSONObject.parseObject(resopseString);
			String codeString = jsonObject.getString("code");
			String expected = casedemo.get("expected").toString();
			Assert.assertEquals(codeString, expected);
		}
	}

}
