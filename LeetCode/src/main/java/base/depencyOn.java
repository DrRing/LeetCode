package base;


import java.util.HashMap;
import java.util.Map;

import config_util.getProperty;

public class depencyOn {
	public static void depencyOn(String path) {
		String phone = getProperty.getProperty("phone");
		String pwd = getProperty.getProperty("password");



	}
    private void construct_json(String[] args) {
		for (String arg : args) {
			System.out.println(arg);
		} 
	}
	public String getLoginId(String[] args) {
		return null;
	}

	public String getSendSms() {
		return null;
	}

	public void register() {
	}
	public static void main(String[] args)  {
		String pathString = "property/depency.properties";
		depencyOn.depencyOn(pathString);
	}
}
