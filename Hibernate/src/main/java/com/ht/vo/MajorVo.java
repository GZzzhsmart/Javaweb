package com.ht.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MajorVo implements Serializable {

	private int majorid;
	private String majorname;
	private Set<ClassesVo> classes = new HashSet<ClassesVo>();
	public Set<ClassesVo> getClasses() {
		return classes;
	}
	public void setClasses(Set<ClassesVo> classes) {
		this.classes = classes;
	}
	public int getMajorid() {
		return majorid;
	}
	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}
	public String getMajorname() {
		return majorname;
	}
	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}
}
