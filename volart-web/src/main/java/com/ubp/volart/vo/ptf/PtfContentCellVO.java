package com.ubp.volart.vo.ptf;

public class PtfContentCellVO {

    private String value;
    private boolean nowrap;

    public PtfContentCellVO(String aValue) {
	value = aValue;
	nowrap = false;
    }

    public PtfContentCellVO(String aValue, boolean aNowrap) {
	value = aValue;
	nowrap = aNowrap;
    }

    public String getValue() {
	return value;
    }

    public void setValue(String value) {
	this.value = value;
    }

    public boolean isNowrap() {
	return nowrap;
    }

    public void setNowrap(boolean nowrap) {
	this.nowrap = nowrap;
    }

}
