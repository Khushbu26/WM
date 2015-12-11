package vo;

public class UScheduleVo {
	private  int scheduleId;
	private AreaVo areaRef;
	private ScheduleVo scheduleRef;
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public AreaVo getAreaRef() {
		return areaRef;
	}
	public void setAreaRef(AreaVo areaRef) {
		this.areaRef = areaRef;
	}
	public ScheduleVo getScheduleRef() {
		return scheduleRef;
	}
	public void setScheduleRef(ScheduleVo scheduleRef) {
		this.scheduleRef = scheduleRef;
	}

}
