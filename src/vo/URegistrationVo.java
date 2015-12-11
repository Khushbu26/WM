package vo;

import java.io.Serializable;

public class URegistrationVo implements Serializable {
	private int uRegId;
private String name;
private long number;
private String email;
private String password;
private String city;
private int pin;

public int getuRegId() {
	return uRegId;
}
public void setuRegId(int uRegId) {
	this.uRegId = uRegId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public long getNumber() {
	return number;
}
public void setNumber(long number) {
	this.number = number;
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
