package com.ubp.volart.vo.indicator;

import java.util.Date;

public class DrawDownVO {

	private double value;
	private Date startDate;
	private Date endDate;
	private double max;

	public DrawDownVO(double aValue, double aMax, Date aStartDate,
			Date anEndDate) {
		value = aValue;
		startDate = aStartDate;
		endDate = anEndDate;
		max = aMax;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

}
