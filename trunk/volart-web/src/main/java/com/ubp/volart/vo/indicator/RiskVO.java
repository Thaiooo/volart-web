package com.ubp.volart.vo.indicator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ubp.volart.model.risk.DrawDown;
import com.ubp.volart.model.risk.Greek;
import com.ubp.volart.model.risk.Var;

public class RiskVO implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;

    private String fundName;
    private Date date;

    private Var currentVar;
    private List<Var> vars;
    private List<Greek> greeks;
    private DrawDown drawDown;

    public DrawDown getDrawDown() {
	return drawDown;
    }

    public void setDrawDown(DrawDown drawDown) {
	this.drawDown = drawDown;
    }

    public List<Greek> getGreeks() {
	return greeks;
    }

    public void setGreeks(List<Greek> greeks) {
	this.greeks = greeks;
    }

    public Var getCurrentVar() {
	return currentVar;
    }

    public void setCurrentVar(Var currentVar) {
	this.currentVar = currentVar;
    }

    public List<Var> getVars() {
	return vars;
    }

    public void setVars(List<Var> vars) {
	this.vars = vars;
    }

    public String getFundName() {
	return fundName;
    }

    public void setFundName(String fundName) {
	this.fundName = fundName;
    }

    public Date getDate() {
	return date;
    }

    public void setDate(Date date) {
	this.date = date;
    }

}
