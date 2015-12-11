package vo;

public class RoadsideunitVo {
	private int roadId;
	private double longi;
	private double lati;
	private DustbinVo dustbinRef;
	private ZoneVo zoneRef;
	private WardVo wardRef;
	private AreaVo areaRef;
	public int getRoadId() {
		return roadId;
	}
	public void setRoadId(int roadId) {
		this.roadId = roadId;
	}
	public double getLongi() {
		return longi;
	}
	public void setLongi(double longi) {
		this.longi = longi;
	}
	public double getLati() {
		return lati;
	}
	public void setLati(double lati) {
		this.lati = lati;
	}
	public DustbinVo getDustbinRef() {
		return dustbinRef;
	}
	public void setDustbinRef(DustbinVo dustbinRef) {
		this.dustbinRef = dustbinRef;
	}
	public ZoneVo getZoneRef() {
		return zoneRef;
	}
	public void setZoneRef(ZoneVo zoneRef) {
		this.zoneRef = zoneRef;
	}
	public WardVo getWardRef() {
		return wardRef;
	}
	public void setWardRef(WardVo wardRef) {
		this.wardRef = wardRef;
	}
	public AreaVo getAreaRef() {
		return areaRef;
	}
	public void setAreaRef(AreaVo areaRef) {
		this.areaRef = areaRef;
	}
	
	
}
