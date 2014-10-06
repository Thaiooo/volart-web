package com.ubp.volart.vo.indicator;

import java.util.ArrayList;
import java.util.List;

import com.ubp.volart.model.indicator.DStat;

public class DStatGroupVO {

    private String name;
    private List<DStat> lines = new ArrayList<DStat>();

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public List<DStat> getLines() {
	return lines;
    }

    public void setLines(List<DStat> lines) {
	this.lines = lines;
    }

}
