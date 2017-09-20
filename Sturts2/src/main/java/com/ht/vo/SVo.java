package com.ht.vo;

import java.io.Serializable;

public class SVo implements Serializable{

	private int sno;
	private String studentname;
	private int sage;
	private String ssex;
	private String shobit;
	private String szhuanye;
	private int classid;
	private int nationid;
	private String classname;
	private String nationname;
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getNationname() {
		return nationname;
	}
	public void setNationname(String nationname) {
		this.nationname = nationname;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getShobit() {
		return shobit;
	}
	public void setShobit(String shobit) {
		this.shobit = shobit;
	}
	public String getSzhuanye() {
		return szhuanye;
	}
	public void setSzhuanye(String szhuanye) {
		this.szhuanye = szhuanye;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public int getNationid() {
		return nationid;
	}
	public void setNationid(int nationid) {
		this.nationid = nationid;
	}
}
