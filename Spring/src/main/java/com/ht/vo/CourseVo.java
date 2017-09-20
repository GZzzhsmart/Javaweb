package com.ht.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CourseVo implements Serializable{

	private int courseid;
	private String coursename;
	private int credit;
	
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
}
