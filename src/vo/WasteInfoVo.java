package vo;

public class WasteInfoVo {
	private int waste_id;
	private String waste_info;
	private String des;
	private AreaVo areaRef;
	public int getWaste_id() {
		return waste_id;
	}
	public void setWaste_id(int waste_id) {
		this.waste_id = waste_id;
	}
	public String getWaste_info() {
		return waste_info;
	}
	public void setWaste_info(String waste_info) {
		this.waste_info = waste_info;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public AreaVo getAreaRef() {
		return areaRef;
	}
	public void setAreaRef(AreaVo areaRef) {
		this.areaRef = areaRef;
	}
	
}
