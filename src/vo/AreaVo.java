package vo;

import java.io.Serializable;

public class AreaVo implements Serializable{
	private int areaId;
	private String areaName;
	private String areaDes;
	private ZoneVo zoneref;
	private WardVo wardref;

	
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaDes() {
		return areaDes;
	}
	public void setAreaDes(String areaDes) {
		this.areaDes = areaDes;
	}
	public ZoneVo getZoneref() {
		return zoneref;
	}
	public void setZoneref(ZoneVo zoneref) {
		this.zoneref = zoneref;
	}
	public WardVo getWardref() {
		return wardref;
	}
	public void setWardref(WardVo wardref) {
		this.wardref = wardref;
	}

}
