package vo;

import java.io.Serializable;

public class DustbinVo implements Serializable{
	private int dustId;
	private String dustNo;
	private String dustName;
	private double latitude;
	private double longitude;
	
	public int getDustId() {
		return dustId;
	}
	public void setDustId(int dustId) {
		this.dustId = dustId;
	}
	public String getDustNo() {
		return dustNo;
	}
	public void setDustNo(String dustNo) {
		this.dustNo = dustNo;
	}
	public String getDustName() {
		return dustName;
	}
	public void setDustName(String dustName) {
		this.dustName = dustName;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	
}
