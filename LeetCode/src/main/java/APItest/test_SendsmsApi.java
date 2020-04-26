package APItest;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import base.OkHttpUtil;
import config_util.getProperty;
import constructor.operateExcel;

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
//				System.out.println(codeString);
//				System.out.println(expected);
				Assert.assertEquals(codeString, expected);
				continue;
			}else {
				System.out.println("body为空");
			}
		}
	}

	public void after() {
		System.out.println("测试结束");

	}

	public static void main(String[] args) {
		String sheetname = "Case_sendsms";
		String pathString = "C:\\Users\\Administrator\\Desktop\\0312.xlsx";
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("captcha_url");
		// List<Map<String, Object>> cases_list= operateExcel.excel_re_map(pathString,
		// sheetname);
		List<Map<String, Object>> cases_list = operateExcel.excel_re_map2(pathString);

		for (int i = 0; i < cases_list.size(); i++) {
			Map<String, Object> ob = cases_list.get(i);

			if (ob.get("body") != null) {
				Map<String, String> mapQ = JSONObject.parseObject(ob.get("body").toString(), Map.class);
				String param = JSON.toJSONString(mapQ);
				String resopseString = OkHttpUtil.postJson(url, param);
				JSONObject jsonObject = JSONObject.parseObject(resopseString);
				String codeString = jsonObject.getString("code");
				if(ob.get("expected") != null) {
					String expected = ob.get("expected").toString();
					System.out.println(codeString);
					System.out.println(expected);
				}else {
					System.out.println("expected为空");

				}

			}
		}

	}

}
