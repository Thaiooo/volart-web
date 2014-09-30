package com.ubp.volart.vo.indicator;


public class CurrentVarVO {

    private String depth;
    private double level;
    private double var;
    private double min;
    private double max;

    public CurrentVarVO(String aDepth, double aLevel, double aVar, double aMin, double aMax) {
	depth = aDepth;
	level = aLevel;
	var = aVar;
	min = aMin;
	max = aMax;
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

    public String getDepth() {
	return depth;
    }

    public void setDepth(String depth) {
	this.depth = depth;
    }

    public double getLevel() {
	return level;
    }

    public void setLevel(double level) {
	this.level = level;
    }

    public double getVar() {
	return var;
    }

    public void setVar(double var) {
	this.var = var;
    }

}
