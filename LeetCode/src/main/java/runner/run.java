package runner;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils.Null;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import base.OkHttpUtil;
import config_util.getProperty;
import constructor.operateExcel;
import dto.*;

public class run {

	public static void main(String[] args) {
		String path = "property/Resource.json";
		String json = util.getJson.getJson(path);
		String url = getProperty.getDepencyProperty("host") + getProperty.getDepencyProperty("login_url");
		String responseString = OkHttpUtil.postJson(url, json);
		JSONObject jsonObject = JSONObject.parseObject(responseString);
		String dataObject = jsonObject.getString("data");
		System.out.println(responseString);
		JSONObject data = JSONObject.parseObject(dataObject);
		try {
			String captchaCode = data.getString("loginId");
			System.out.print(captchaCode);
		} catch (Exception e) {
			System.out.print(e);
		}
	}

}
