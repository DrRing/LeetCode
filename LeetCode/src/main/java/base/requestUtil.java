package base;

import java.util.Map;

import config_util.getProperty;

public class requestUtil {
	public static void GetMethod(Map<String, String> map) {

	}

	public static void postMethod(String url, Map<String, String> map) {

	}

	public static String re_postMethod(String url, Map<String, String> map) {

		return null;
	}

	public static String getcaptchaCode(Map<String, String> map) {

		String uString = getProperty.getProperty("testhost") + getProperty.getProperty("captcha_url");
		requestUtil.re_postMethod(uString, map);

		return null;
	}

	public static void login(Map<String, String> map) {
		String uString = getProperty.getProperty("testhost") + getProperty.getProperty("login_url");
		requestUtil.postMethod(uString, map);

	}

}
