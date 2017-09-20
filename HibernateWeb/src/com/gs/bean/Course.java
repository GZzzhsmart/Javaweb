package com.gs.bean;

import java.util.Set;

public class Course {
	
	private int id;
	private String name;
	private String des;
	
	private Set<Student> stus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Set<Student> getStus() {
		return stus;
	}

	public void setStus(Set<Student> stus) {
		this.stus = stus;
	}

}
