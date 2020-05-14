package APItest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import base.OkHttpUtil;
import base.depencyOn;
import config_util.getProperty;
import constructor.operateExcel;

public class test_CheckLoginApi {
	@DataProvider
	private Iterator<Object[]> CheckLoginProvider() throws IOException {
		List<Object[]> result = new ArrayList<Object[]>();
		String sheetname = "Case_checkLogin";
		String pathString = "C:\\Users\\Administrator\\Desktop\\0514.xlsx";
		List<Map<String, Object>> cases_list = operateExcel.excel_re_map(pathString, sheetname);
		Iterator it = cases_list.iterator();
		while (it.hasNext()) {
			result.add(new Object[] { it.next() });
		}
		return result.iterator();
	}
	@Test(dataProvider = "CheckLoginProvider")
	public void testLogin(Map<String, Object> casedemo) {
		String url = getProperty.getDepencyProperty("host") + getProperty.getDepencyProperty("checkLogin_web_url");
		try {
			Map<String, String> body = JSONObject.parseObject(casedemo.get("body").toString(), Map.class);
			if (casedemo.get("depency").equals(null)) {
				body.put("loginId", null);
			} else {
				String login_String = casedemo.get("depency").toString();
				String loginID = depencyOn.getLoginId(login_String);
				body.put("loginId", loginID);
			}
			String param = JSON.toJSONString(body);
			String resopseString = OkHttpUtil.postJson(url, param);
			JSONObject jsonObject = JSONObject.parseObject(resopseString);

			String codeString = jsonObject.getString("code");
			System.out.println(codeString);

			String expected = casedemo.get("expected").toString();
			assertEquals(codeString, expected);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
