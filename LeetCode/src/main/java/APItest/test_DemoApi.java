package APItest;

import static org.testng.Assert.assertEquals;

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
import base.depencyOn;
import config_util.getProperty;
import constructor.operateExcel;

public class test_DemoApi {
	@DataProvider
	private Iterator<Object[]> LoginProvider() throws IOException {
		List<Object[]> result = new ArrayList<Object[]>();
		String sheetname = "test";
		String pathString = "C:\\Users\\Administrator\\Desktop\\0312.xlsx";
		List<Map<String, Object>> cases_list = operateExcel.excel_re_map(pathString, sheetname);
		Iterator it = cases_list.iterator();
		while (it.hasNext()) {
			result.add(new Object[] { it.next() });
		}
		return result.iterator();
	}

	@Test(dataProvider = "LoginProvider")
	public void testLogin(Map<String, Object> casedemo) {
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("login_url");
		// if (casedemo.get("depency") != null) {
		try {
			String para_captchString = casedemo.get("depency").toString();
			// System.out.println(para_captchString);
			String captchaCode = depencyOn.getSendSms(para_captchString);
			// System.out.println(captchaCode);
			Map<String, String> body = JSONObject.parseObject(casedemo.get("body").toString(), Map.class);
			// 插入验证码
			body.put("captcha", captchaCode);
			// 将对象转化为Json字符串
			//System.out.println(casedemo.get("body").toString());
			String param = JSON.toJSONString(body);
			String resopseString = OkHttpUtil.postJson(url, param);			
			JSONObject jsonObject = JSONObject.parseObject(resopseString);
			String codeString = jsonObject.getString("code");
			String expected = casedemo.get("expected").toString();
			assertEquals(codeString, expected);

		} catch (Exception e) {
			//System.out.println(e);
		}
	}
}
