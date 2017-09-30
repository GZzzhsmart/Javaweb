package com.gs.common.bean;

public class Pie<T> {
	private String name;
	private T y;
	private boolean sliced;
	private boolean selected;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
	public boolean isSliced() {
		return sliced;
	}
	public void setSliced(boolean sliced) {
		this.sliced = sliced;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}

