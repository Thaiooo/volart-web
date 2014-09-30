package com.ubp.volart.vo.indicator;

import java.io.Serializable;
import java.util.List;

public class RiskVO implements Serializable {

	/**
     */
	private static final long serialVersionUID = 1L;

	private String fundName;
	private String date;

	private CurrentVarVO currentVar;
	private List<VarLineVO> vars;
	private List<GreekLineVO> greeks;
	private DrawDownVO drawDown;

	public DrawDownVO getDrawDown() {
		return drawDown;
	}

	public void setDrawDown(DrawDownVO drawDown) {
		this.drawDown = drawDown;
	}

	public List<GreekLineVO> getGreeks() {
		return greeks;
	}

	public void setGreeks(List<GreekLineVO> greeks) {
		this.greeks = greeks;
	}

	public CurrentVarVO getCurrentVar() {
		return currentVar;
	}

	public void setCurrentVar(CurrentVarVO currentVar) {
		this.currentVar = currentVar;
	}

	public List<VarLineVO> getVars() {
		return vars;
	}

	public void setVars(List<VarLineVO> vars) {
		this.vars = vars;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
