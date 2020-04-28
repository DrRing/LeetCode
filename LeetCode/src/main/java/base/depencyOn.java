package base;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;

import config_util.getProperty;

public class depencyOn {
	public static void depencyOn(String path) {
		String phone = getProperty.getProperty("phone");
		String pwd = getProperty.getProperty("password");



	}
	@Test
    private void construct_json(String[] args) {
		for (String arg : args) {
			System.out.println(arg);
		} 
	}
	@Test
	public String getLoginId(String[] args) {
		return null;
	}

	public static String getSendSms(String json) {
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("captcha_url");
		String responseString = OkHttpUtil.postJson(url, json);
		JSONObject jsonObject = JSONObject.parseObject(responseString); 
		String dataObject = jsonObject.getString("data");	
		JSONObject data = JSONObject.parseObject(dataObject); 
		String captchaCode = data.getString("captchaCode");
		return captchaCode;
	}
	@Test
	public void register() {
	}

}
