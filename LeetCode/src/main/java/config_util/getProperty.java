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
	/* 返回整个map */
	public static Map<String, String> getProperty1(String path) {
		Map<String, String> list_questsArrayList = new HashMap<String, String>();
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(new File(path)));
			properties.load(inputStream);
			Set KeyValue = properties.keySet();
			for (Iterator i = KeyValue.iterator(); i.hasNext();) {
				String key = (String) i.next();
				list_questsArrayList.put(key, properties.get(key).toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list_questsArrayList;
	}
	/* 返回指定的字段 */
	public static String getDepencyProperty(String key_val) {
		String path = "property/depency.properties";
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
	public static String getResourceProperty(String key_val) {
		String path = "property/Resource.properties";
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

}
