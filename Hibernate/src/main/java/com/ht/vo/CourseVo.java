package com.ht.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CourseVo implements Serializable{

	private int courseid;
	private String coursename;
	private Set<StudentVo> studSet = new HashSet<StudentVo>();
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
	public Set<StudentVo> getStudSet() {
		return studSet;
	}
	public void setStudSet(Set<StudentVo> studSet) {
		this.studSet = studSet;
	}
	
}
