package vo;

import java.io.Serializable;

public class ZoneVo implements Serializable{
private int zoneId;
private String zoneName;
private String zoneDes;
public int getZoneId() {
	return zoneId;
}
public void setZoneId(int zoneId) {
	this.zoneId = zoneId;
}
public String getZoneName() {
	return zoneName;
}
public void setZoneName(String zoneName) {
	this.zoneName = zoneName;
}
public String getZoneDes() {
	return zoneDes;
}
public void setZoneDes(String zoneDes) {
	this.zoneDes = zoneDes;
}
}
