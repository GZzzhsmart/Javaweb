package com.ht.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class TestBean {

	private String helloWorld="你好，世界！";
	private String name = "张三";
	private Date date;
	private String[] nation;
	private List list;
	private HashMap map;
	public HashMap getMap() {
		return map;
	}
	public void setMap(HashMap map) {
		this.map = map;
	}
	public String[] getNation() {
		return nation;
	}
	public void setNation(String[] nation) {
		this.nation = nation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public TestBean() {
		
	}
	public TestBean(String helloWorld) {
		this.helloWorld = helloWorld;
	}
	public TestBean(String helloWorld,String name) {
		this.helloWorld = helloWorld;
		this.name = name;
	}
	
	public String getHelloWorld() {
		return helloWorld;
	}

	public void setHelloWorld(String helloWorld) {
		this.helloWorld = helloWorld;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
}
