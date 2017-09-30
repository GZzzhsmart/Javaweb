package com.ht.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StudentVo implements Serializable{

	private int id;
	private String studno;
	private String studname;
	private String classname;
	public StudentVo() {}
	public StudentVo(int id,String studno,String studname,String classname) {
		this.id = id;
		this.studno = studno;
		this.studname = studname;
		this.classname = classname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudno() {
		return studno;
	}
	public void setStudno(String studno) {
		this.studno = studno;
	}
	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		return "id="+this.id +",studno="+this.studno+",studname="+this.studname+",classname="+this.classname;
	}
}
