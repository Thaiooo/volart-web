package com.ubp.volart.vo.ptf;

import java.io.Serializable;
import java.util.List;

public class PortfolioVO implements Serializable {

    /**
     */
    private static final long serialVersionUID = 1L;

    private String name;
    private String asset;
    private String date;
    private String pnlD;
    private String pnlD1;
    private String pnlMtD;
    private String pnlMtDD1;
    private String delta;
    private String vega;
    private String theta;
    private String invPrem;

    private List<PtfHeaderCellVO> ptfHeaderCols;
    private List<PtfContentLineVO> ptfContent;

    public List<PtfHeaderCellVO> getPtfHeaderCols() {
	return ptfHeaderCols;
    }

    public void setPtfHeaderCols(List<PtfHeaderCellVO> ptfHeaderCols) {
	this.ptfHeaderCols = ptfHeaderCols;
    }

    public List<PtfContentLineVO> getPtfContent() {
	return ptfContent;
    }

    public void setPtfContent(List<PtfContentLineVO> ptfContent) {
	this.ptfContent = ptfContent;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAsset() {
	return asset;
    }

    public void setAsset(String asset) {
	this.asset = asset;
    }

    public String getDate() {
	return date;
    }

    public void setDate(String date) {
	this.date = date;
    }

    public String getPnlD() {
	return pnlD;
    }

    public void setPnlD(String pnlD) {
	this.pnlD = pnlD;
    }

    public String getPnlD1() {
	return pnlD1;
    }

    public void setPnlD1(String pnlD1) {
	this.pnlD1 = pnlD1;
    }

    public String getPnlMtD() {
	return pnlMtD;
    }

    public void setPnlMtD(String pnlMtD) {
	this.pnlMtD = pnlMtD;
    }

    public String getPnlMtDD1() {
	return pnlMtDD1;
    }

    public void setPnlMtDD1(String pnlMtDD1) {
	this.pnlMtDD1 = pnlMtDD1;
    }

    public String getDelta() {
	return delta;
    }

    public void setDelta(String delta) {
	this.delta = delta;
    }

    public String getVega() {
	return vega;
    }

    public void setVega(String vega) {
	this.vega = vega;
    }

    public String getTheta() {
	return theta;
    }

    public void setTheta(String theta) {
	this.theta = theta;
    }

    public String getInvPrem() {
	return invPrem;
    }

    public void setInvPrem(String invPrem) {
	this.invPrem = invPrem;
    }

}
