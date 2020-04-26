package dto;

public class SendSmsDTO {
	private String platform;
	private String receive;
	private String cnum;
	private String businessType;

//	public enum businessType{
//		lOGIN,CHANGEPASSWORD,CHANGE_PHONE,CHANGE_EMAIL,REGISTER,PAY,OTHER
//	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getReceive() {
		return receive;
	}
	public String getCnum() {
		return cnum;
	}
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
}
