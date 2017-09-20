package com.ht.vo;

import java.io.Serializable;

public class StudentVo implements Serializable{

	private String studid;
	private String studname;
	private int age;
	private String sex;
	private String cardno;
	private String hobit;
	private int nationid;
	private int classid;
	public String getStudid() {
		return studid;
	}
	public void setStudid(String studid) {
		this.studid = studid;
	}
	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public int getNationid() {
		return nationid;
	}
	public void setNationid(int nationid) {
		this.nationid = nationid;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getHobit() {
		return hobit;
	}
	public void setHobit(String hobit) {
		this.hobit = hobit;
	}
	
}
