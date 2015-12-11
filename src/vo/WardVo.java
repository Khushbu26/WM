package vo;

import java.io.Serializable;

public class WardVo implements Serializable{
	private int wardId;
	private String wardName;
	private String wardDes;
	private ZoneVo zoneref;
	public int getWardId() {
		return wardId;
	}
	public void setWardId(int wardId) {
		this.wardId = wardId;
	}
	public String getWardName() {
		return wardName;
	}
	public void setWardName(String wardName) {
		this.wardName = wardName;
	}
	public String getWardDes() {
		return wardDes;
	}
	public void setWardDes(String wardDes) {
		this.wardDes = wardDes;
	}
	public ZoneVo getZoneref() {
		return zoneref;
	}
	public void setZoneref(ZoneVo zoneref) {
		this.zoneref = zoneref;
	}

}
