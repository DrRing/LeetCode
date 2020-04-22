package runner;

import java.util.Map;



import base.OkHttpUtil;
import config_util.getProperty;

public class run {

	public static void main(String[] args) {
		String path = "property/captcha.properties";
		String url = getProperty.getProperty("testhost")+getProperty.getProperty("captcha_url");		
		Map<String, String> params = getProperty.getProperty1(path);
		//System.out.println(params);
		System.out.println(OkHttpUtil.post(url, params));

		
	}
}
