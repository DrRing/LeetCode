package APItest;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import Assertion.AssertListener;
import base.OkHttpUtil;
import config_util.getProperty;
import constructor.operateExcel;

@Listeners(AssertListener.class)
public class test_SendsmsApi {
	public void before() {
		System.out.println("测试开始");
	}

	@Test
	public void testSend() {
		String sheetname = "Case_sendsms";
		String pathString = "C:\\Users\\Administrator\\Desktop\\0312.xlsx";
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("captcha_url");
		// List<Map<String, Object>> cases_list= operateExcel.excel_re_map(pathString,
		// sheetname);
		List<Map<String, Object>> cases_list = operateExcel.excel_re_map2(pathString);

		for (int i = 0; i < cases_list.size(); i++) {
			Map<String, Object> ob = cases_list.get(i);

			if (ob.get("body") != null && ob.get("expected") != null) {
				Map<String, String> mapQ = JSONObject.parseObject(ob.get("body").toString(), Map.class);
				String param = JSON.toJSONString(mapQ);
				String resopseString = OkHttpUtil.postJson(url, param);
				JSONObject jsonObject = JSONObject.parseObject(resopseString);
				String codeString = jsonObject.getString("code");
				String expected = ob.get("expected").toString();
				if (expected.equals(codeString)) {
					// System.out.println(ob.get("subname")+":"+"用例执行通过");
					continue;
				} else {
					System.out.println(ob.get("subname") + ":" + "用例执行失败");
				}

			} else {
				System.out.println("body为空");
			}
		}
//		Assertion.Assertion.verifyEquals(codeString, expected,"预期是:"+"codeString"+"实际是："+expected);
//		SoftAssert assertion = new SoftAssert();
//		System.out.println(expected+":"+codeString);
//		assertion.assertEquals(codeString, expected);
//		assertion.assertAll();
	}

	public void after() {
		System.out.println("测试结束");

	}

}
