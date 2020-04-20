package config_util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class getProperty {

	public static Map<String, String> getProperty(String path) {
		Map<String, String> list_questsArrayList = new HashMap<String, String>();

		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(new File(path)));
			properties.load(inputStream);
			Set KeyValue = properties.keySet();
			for (Iterator i = KeyValue.iterator(); i.hasNext();) {
				String key = (String) i.next();
				if (key.equals("loginname")) {
					// System.out.println(properties.get(key));
					list_questsArrayList.put("loginname", properties.get(key).toString());

				} else if (key.equals("password")) {
					list_questsArrayList.put("password", properties.get(key).toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list_questsArrayList;
	}

	public static String getProperty(String path, String key_val) {
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(new File(path)));
			properties.load(inputStream);
			Set KeyValue = properties.keySet();
			for (Iterator i = KeyValue.iterator(); i.hasNext();) {
				String key = (String) i.next();
				if (key.equals(key_val)) {
					String valString = properties.get(key).toString();
					return valString;

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		String pathString = "property/depency.properties";
		getProperty.getProperty(pathString, "loginname");
		System.out.print(getProperty.getProperty(pathString));
	}

}
