package dto;

public class RegisterDTO {
	private String platform;
	private String phone;
	private String cnum;
	private String captchaCode;
	private String captchaType;
	private String registerIp;
	private String nickname;
	private String password;
	private String city;
	private String login;
	private String province;
	private String country;
	private String address;
	private String examType;
	private String email;
	private String examTime;
	private String myid;
	private String myidkey;
	private String idNo;
	private String registerExtend;
	private String  sourceExtend ;
	public enum businessType{
		THIRD_QQ,THIRD_SINA,THIRD_WECHAT,PHONE_CODE
	}

	
	
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCnum() {
		return cnum;
	}
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	public String getPassword() {
		return password;
	}
}
