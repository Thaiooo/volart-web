package com.ubp.volart.vo.indicator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ubp.volart.model.indicator.BetaTarget;
import com.ubp.volart.model.indicator.RelativeValue;

public class IndicatorVO implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;

    private String fundName;
    private Date date;
    private List<DStatGroupVO> dstatLines;
    private List<RelativeValue> relativeValueLines;
    private List<BetaTarget> betaTargetLines;

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

    public List<DStatGroupVO> getDstatLines() {
	return dstatLines;
    }

    public void setDstatLines(List<DStatGroupVO> dstatLines) {
	this.dstatLines = dstatLines;
    }

    public List<RelativeValue> getRelativeValueLines() {
	return relativeValueLines;
    }

    public void setRelativeValueLines(List<RelativeValue> relativeValueLines) {
	this.relativeValueLines = relativeValueLines;
    }

    public List<BetaTarget> getBetaTargetLines() {
	return betaTargetLines;
    }

    public void setBetaTargetLines(List<BetaTarget> betaTargetLines) {
	this.betaTargetLines = betaTargetLines;
    }

}
