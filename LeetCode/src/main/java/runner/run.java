package runner;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import base.OkHttpUtil;
import config_util.getProperty;
import constructor.operateExcel;
import dto.*;
@Test
public class run {

	public static void main(String[] args) {
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("captcha_url");
		String path = "C:\\Users\\Administrator\\Desktop\\1.xlsx";
		List<Map<String, Object>> cases_list = operateExcel.excel_re_map(path);
		for (int i = 0; i < cases_list.size(); i++) {
			Map<String, Object> ob = cases_list.get(i);
			if (ob.get("body") != null) {
				Map<String, String> mapQ = JSONObject.parseObject(ob.get("body").toString(), Map.class);
				String param = JSON.toJSONString(mapQ);
				String respString2 = OkHttpUtil.postJson(url, param);
				JSONObject jsonObject = JSONObject.parseObject(respString2); 
				//String respose_code = jsonObject.get("code"));
				assertEquals("SUCCESS", jsonObject.get("code"));
			}

		}
	}
}
