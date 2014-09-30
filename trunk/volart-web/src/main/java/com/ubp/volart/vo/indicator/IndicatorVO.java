package com.ubp.volart.vo.indicator;

import java.io.Serializable;
import java.util.List;

public class IndicatorVO implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;

    private String fundName;
    private String date;
    private List<DStatGroupVO> dstatValues;
    private List<RelativeValueLineVO> relativeValues;
    private List<BetatTargetLineVO> betaTargetValues;

    public List<DStatGroupVO> getDstatValues() {
	return dstatValues;
    }

    public void setDstatValues(List<DStatGroupVO> dstatValues) {
	this.dstatValues = dstatValues;
    }

    public List<RelativeValueLineVO> getRelativeValues() {
	return relativeValues;
    }

    public void setRelativeValues(List<RelativeValueLineVO> relativeValues) {
	this.relativeValues = relativeValues;
    }

    public List<BetatTargetLineVO> getBetaTargetValues() {
	return betaTargetValues;
    }

    public void setBetaTargetValues(List<BetatTargetLineVO> betaTargetValues) {
	this.betaTargetValues = betaTargetValues;
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
