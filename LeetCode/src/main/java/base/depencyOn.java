package base;


import config_util.getProperty;

public class depencyOn {
	public static void depencyOn(String path) {
		String phone = getProperty.getProperty(path,"phone");
		String pwd = getProperty.getProperty(path,"password");



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
