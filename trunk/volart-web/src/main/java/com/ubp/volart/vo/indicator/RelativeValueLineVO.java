package com.ubp.volart.vo.indicator;

public class RelativeValueLineVO {

    private String instrument;
    private String todayValue;
    private String yesterdayValue;
    private String lastMonthDate;
    private String lastMonthValue;

    public RelativeValueLineVO(String aInstrument, String aTodayValue, String aYesterdayValue, String aLastMonthDate,
	    String aLastMonthValue) {
	instrument = aInstrument;
	todayValue = aTodayValue;
	yesterdayValue = aYesterdayValue;
	lastMonthDate = aLastMonthDate;
	lastMonthValue = aLastMonthValue;
    }

    public String getInstrument() {
	return this.instrument;
    }

    public void setInstrument(String instrument) {
	this.instrument = instrument;
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

    public String getLastMonthDate() {
	return lastMonthDate;
    }

    public void setLastMonthDate(String lastMonthDate) {
	this.lastMonthDate = lastMonthDate;
    }

    public String getLastMonthValue() {
	return lastMonthValue;
    }

    public void setLastMonthValue(String lastMonthValue) {
	this.lastMonthValue = lastMonthValue;
    }

}
