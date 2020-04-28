package APItest;

import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import base.OkHttpUtil;
import config_util.getProperty;
import constructor.operateExcel;
import base.depencyOn;

public class test_LoginApi {

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@Test
	// @Test(dependsOnGroups = {"getcaptcha"})
	public void testLogin() {
		String sheetname = "test";
		String pathString = "C:\\Users\\Administrator\\Desktop\\0312.xlsx";
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("login_url");
		List<Map<String, Object>> cases_list = operateExcel.excel_re_map(pathString,sheetname);

		for (int i = 0; i < cases_list.size(); i++) {
			Map<String, Object> ob = cases_list.get(i);
//			System.out.println(ob.get("depency")+":"+ob.get("body"));
			if (ob.get("depency") != null) {
				String para_captchString = ob.get("depency").toString();
				System.out.println(para_captchString);
				String captchaCode = depencyOn.getSendSms(para_captchString);
				System.out.println(captchaCode);
//				if (ob.get("body") != null && ob.get("expected") != null) {
//					JSONObject body = JSONObject.parseObject(ob.get("body").toString());
//					body.put("captchaCode", captchaCode);
//					System.out.println(body);
//				Map<String, String> mapQ = JSONObject.parseObject(ob.get("body").toString(), Map.class);
//				String param = JSON.toJSONString(mapQ);
//				String resopseString = OkHttpUtil.postJson(url, param);
//				JSONObject jsonObject = JSONObject.parseObject(resopseString);
//				String codeString = jsonObject.getString("code");
//				String expected = ob.get("expected").toString();
//				if (expected.equals(codeString)) {
//				 System.out.println(ob.get("subname")+":"+"用例执行通过");
//					continue;
//				} else {
//					System.out.println(ob.get("subname") + ":" + "用例执行失败");
//				}
//
//			} else {
//				System.out.println("body为空");
//			}				
			}
		}
	}
}