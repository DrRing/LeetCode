package dto;

import java.io.Serializable;

import dto.GetcaptchaDTO;
import dto.LoginDTO;

public class ParamRequestDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GetcaptchaDTO getcaptcha;

	private LoginDTO login;

	public GetcaptchaDTO getGetcaptcha() {
		return getcaptcha;
	}

	public void setGetcaptcha(GetcaptchaDTO getcaptcha) {
		this.getcaptcha = getcaptcha;
	}

	public LoginDTO getLogin() {
		return login;
	}

	public void setLogin(LoginDTO login) {
		this.login = login;
	}

}
