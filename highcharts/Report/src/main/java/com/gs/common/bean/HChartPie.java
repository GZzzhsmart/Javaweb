package com.gs.common.bean;

public class HChartPie<T> {

	private String type;
	private String name;
	private Pie<T>[] data;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pie<T>[] getData() {
		return data;
	}

	public void setData(Pie<T>[] data) {
		this.data = data;
	}

}
