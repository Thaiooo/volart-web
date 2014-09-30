package com.ubp.volart.vo.ptf;

public class PtfHeaderCellVO {

	private String dataPriority;
	private String name;

	public PtfHeaderCellVO(String aDataPriority, String aName) {
		dataPriority = aDataPriority;
		name = aName;
	}

	public String getDataPriority() {
		return dataPriority;
	}

	public void setDataPriority(String dataPriority) {
		this.dataPriority = dataPriority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
