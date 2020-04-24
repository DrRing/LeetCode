package util;

//https://www.pianshen.com/article/4958223920/
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;

import java.io.Reader;


import base.OkHttpUtil;
import config_util.getProperty;



public class getJson {
	/**
	 * 读取json文件，返回json串
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getJson(String fileName) {
		String jsonStr = "";
		try {
			File jsonFile = new File(fileName);
			FileReader fileReader = new FileReader(jsonFile);

			Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
			int ch = 0;
			StringBuffer sb = new StringBuffer();
			while ((ch = reader.read()) != -1) {
				sb.append((char) ch);
			}
			fileReader.close();
			reader.close();
			jsonStr = sb.toString();
			return jsonStr;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		String path = "property/test.json";
		String bodyString = getJson(path);
		System.out.println(bodyString);
		String url = getProperty.getProperty("testhost")+getProperty.getProperty("captcha_url");
		System.out.println(OkHttpUtil.postJson(url, bodyString));

		
	}

}
