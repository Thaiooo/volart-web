package com.ubp.volart.vo.indicator;

import java.util.ArrayList;
import java.util.List;

public class DStatGroupVO {

	private String name;
	private List<DStatLineVO> lines = new ArrayList<DStatLineVO>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DStatLineVO> getLines() {
		return lines;
	}

	public void setLines(List<DStatLineVO> lines) {
		this.lines = lines;
	}

}
