package com.ubp.volart.vo.ptf;

import java.util.List;

public class PtfContentLineVO {

	private String className;
	private List<PtfContentCellVO> cols;

	public PtfContentLineVO(String aClassName) {
		className = aClassName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<PtfContentCellVO> getCols() {
		return cols;
	}

	public void setCols(List<PtfContentCellVO> cols) {
		this.cols = cols;
	}

}
