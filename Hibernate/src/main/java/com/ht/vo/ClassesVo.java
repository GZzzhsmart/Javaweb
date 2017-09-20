package com.ht.vo;

import java.io.Serializable;

public class ClassesVo implements Serializable {

	private int classid;
	private String classname;
	private int majorid;
	private MajorVo major;
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public int getMajorid() {
		return majorid;
	}
	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}
	public MajorVo getMajor() {
		return major;
	}
	public void setMajor(MajorVo major) {
		this.major = major;
	}
}
