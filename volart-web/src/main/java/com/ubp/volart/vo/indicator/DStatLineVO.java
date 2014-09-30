package com.ubp.volart.vo.indicator;

public class DStatLineVO {

	private String id;
	private String underlying;
	private String downDStat;
	private String upDStat;
	private String todayValue;
	private String yesterdayValue;

	public DStatLineVO(String anId, String anUnderlying, String aDownDStat,
			String anUpDStat, String aTodayValue, String aYesterdayValue) {
		id = anId;
		underlying = anUnderlying;
		downDStat = aDownDStat;
		upDStat = anUpDStat;
		todayValue = aTodayValue;
		yesterdayValue = aYesterdayValue;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUnderlying() {
		return underlying;
	}

	public void setUnderlying(String underlying) {
		this.underlying = underlying;
	}

	public String getDownDStat() {
		return downDStat;
	}

	public void setDownDStat(String downDStat) {
		this.downDStat = downDStat;
	}

	public String getUpDStat() {
		return upDStat;
	}

	public void setUpDStat(String upDStat) {
		this.upDStat = upDStat;
	}

	public String getTodayValue() {
		return todayValue;
	}

	public void setTodayValue(String todayValue) {
		this.todayValue = todayValue;
	}

	public String getYesterdayValue() {
		return yesterdayValue;
	}

	public void setYesterdayValue(String yesterdayValue) {
		this.yesterdayValue = yesterdayValue;
	}

}
