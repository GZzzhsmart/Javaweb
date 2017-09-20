package com.ht.vo;

import java.io.Serializable;

public class MajorVo implements Serializable{

	private int majorid;
	private String majorname;
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
