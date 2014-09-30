package com.ubp.volart.vo.indicator;

import java.util.Date;

public class VarLineVO {

    private String depth;
    private double level;
    private double var;
    private double varAmount;
    private Date date;

    public VarLineVO(String aDepth, double aLevel, double aVar, double aVarAmount, Date aDate) {
	depth = aDepth;
	level = aLevel;
	var = aVar;
	varAmount = aVarAmount;
	date = aDate;
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

    public double getVarAmount() {
	return varAmount;
    }

    public void setVarAmount(double varAmount) {
	this.varAmount = varAmount;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

}
