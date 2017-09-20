package com.ht.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class StudentVo implements Serializable {

	/*
	 * 配置步骤 1.创建表对应的javabean 2.创建javabean对应的xml配置文件,命名规则javabean的名称.hbm.xml
	 * 3.在hibernate.cfg.xml文件中配置hbm文件
	 * 
	 */
	private int studid;
	private String studname;
	private String sex;
	private String cardid;
	private int classid;
	private int age;
	private Set<CourseVo> courseSet = new HashSet<CourseVo>();
	public int getStudid() {
		return studid;
	}

	public void setStudid(int studid) {
		this.studid = studid;
	}

	public String getStudname() {
		return studname;
	}

	public void setStudname(String studname) {
		this.studname = studname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<CourseVo> getCourseSet() {
		return courseSet;
	}

	public void setCourseSet(Set<CourseVo> courseSet) {
		this.courseSet = courseSet;
	}

}
