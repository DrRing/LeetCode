package runner;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import base.OkHttpUtil;
import config_util.getProperty;
import constructor.operateExcel;
import dto.*;

public class run {

	public static void main(String[] args) {
//		String url = getProperty.getProperty("testhost")+getProperty.getProperty("captcha_url");		
//		GetcaptchaDTO getcaptcha = new GetcaptchaDTO();
//		getcaptcha.setPlatform("APP");
//		getcaptcha.setBusinessType("REGISTER");
//		getcaptcha.setCnum("86");
//		getcaptcha.setReceiver("15036770523");
//		ParamRequestDTO request = new ParamRequestDTO();
//		request.setGetcaptcha(getcaptcha);
//		System.out.println(OkHttpUtil.postJson(url, JSON.toJSONString(request)));
		String path = "C:\\Users\\Administrator\\Desktop\\0421\\0312.xlsx";
		List<Map<String, Object>> cases_list = operateExcel.excel_re_map(path);
		System.out.println(cases_list.size());
		
	}
}
