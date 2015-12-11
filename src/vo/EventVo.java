package vo;

import java.io.Serializable;

public class EventVo implements Serializable{
	private int eventId;
	private String eventName;
	private String eventDes;
	private String startDate;
	private String endDate;
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDes() {
		return eventDes;
	}
	public void setEventDes(String eventDes) {
		this.eventDes = eventDes;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	
	

}
