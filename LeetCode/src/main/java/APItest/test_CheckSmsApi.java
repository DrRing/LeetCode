package APItest;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import base.OkHttpUtil;
import base.depencyOn;
import config_util.getProperty;
import constructor.operateExcel;

public class test_CheckSmsApi {
	@Test
	public void testSendSms() {
		String sheetname = "Case_sendsms";
		String pathString = "C:\\Users\\Administrator\\Desktop\\0312.xlsx";
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("captcha_url");
		List<Map<String, Object>> cases_list = operateExcel.excel_re_map(pathString, sheetname);
		for (int i = 0; i < cases_list.size(); i++) {
			Map<String, Object> ob = cases_list.get(i);

			if (ob.get("body") != null && ob.get("expected") != null) {
				Map<String, String> body = JSONObject.parseObject(ob.get("body").toString(), Map.class);
				// 插入验证码

				String param = JSON.toJSONString(body);
				String resopseString = OkHttpUtil.postJson(url, param);
				// System.out.println(resopseString);
				JSONObject jsonObject = JSONObject.parseObject(resopseString);

				String codeString = jsonObject.getString("code");
				String expected = ob.get("expected").toString();
				// System.out.println(codeString+":"+expected);
				if (expected.equals(codeString)) {
					// System.out.println(ob.get("subname") + ":" + "用例执行通过");
					continue;
				} else {
					System.out.println(ob.get("subname") + ":" + "用例执行失败");
				}
			} else {
				System.out.println("body为空");

			}
		}
	}
}
