package com.ubp.volart.vo.indicator;

public class GreekLineVO {

	private String name;
	private double value;
	private double min;
	private double max;

	public GreekLineVO(String aName, double aMin, double aMax, double aValue) {
		name = aName;
		value = aValue;
		min = aMin;
		max = aMax;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

}
