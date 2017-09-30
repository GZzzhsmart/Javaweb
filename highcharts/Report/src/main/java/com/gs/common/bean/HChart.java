package com.gs.common.bean;

public class HChart<T> {
	
	private String name;
	private T[] data;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T[] getData() {
		return data;
	}
	public void setData(T[] data) {
		this.data = data;
	}
	
}
