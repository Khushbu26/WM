package vo;

import vo.AreaVo;

public class UComplaintVo {
	private int compId;
	private String compName;
	private String compDes;
	private AreaVo areaRef;
	
	public int getCompId() {
		return compId;
	}
	public void setCompId(int compId) {
		this.compId = compId;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompDes() {
		return compDes;
	}
	public void setCompDes(String compDes) {
		this.compDes = compDes;
	}
	public AreaVo getAreaRef() {
		return areaRef;
	}
	public void setAreaRef(AreaVo areaRef) {
		this.areaRef = areaRef;
	}
	
	
	
}