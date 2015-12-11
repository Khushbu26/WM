package vo;

import java.io.Serializable;

public class USignVo implements Serializable {
	
	private int signinId;
	private String fName;
	private String lName;
	private String moNo;
	private String email;
	private String password;
	private String city;
	private int pin;
	
	public int getSigninId() {
		return signinId;
	}
	public void setSigninId(int signinId) {
		this.signinId = signinId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getMoNo() {
		return moNo;
	}
	public void setMoNo(String moNo) {
		this.moNo = moNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
}
