package base;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;

import config_util.getProperty;

public class depencyOn {

	@Test
	private void construct_json(String[] args) {
		for (String arg : args) {
			System.out.println(arg);
		}
	}

	@Test
	public String getLoginId(String json) {
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("login");
		String responseString = OkHttpUtil.postJson(url, json);
		JSONObject jsonObject = JSONObject.parseObject(responseString);
		String dataObject = jsonObject.getString("data");
		JSONObject data = JSONObject.parseObject(dataObject);
		try {
			String captchaCode = data.getString("loginId");
			return captchaCode;
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	public static void doLogin(String json) {
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("login");
		String responseString = OkHttpUtil.postJson(url, json);
		JSONObject jsonObject = JSONObject.parseObject(responseString);
		String dataObject = jsonObject.getString("data");
		JSONObject data = JSONObject.parseObject(dataObject);
		try {
			String captchaCode = data.getString("code");
			if (captchaCode.equals("SUCCESS") == false) {
				System.out.print("好像登录没有成功");
			}
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	public static String getSendSms(String json) {
		String url = getProperty.getProperty("testhost") + getProperty.getProperty("captcha_url");
		String responseString = OkHttpUtil.postJson(url, json);
		JSONObject jsonObject = JSONObject.parseObject(responseString);
		String dataObject = jsonObject.getString("data");
		JSONObject data = JSONObject.parseObject(dataObject);

		try {
			String captchaCode = data.getString("captchaCode");
			return captchaCode;
		} catch (Exception e) {
			System.out.print(e);
			return null;
		}
	}

	@Test
	public void register() {
	}

}
