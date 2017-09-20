package com.ht.vo;

import java.io.Serializable;

public class NationVo implements Serializable{

	private int nationid;
	private String nationName;
	public NationVo() {
		
	}
	public NationVo(int nationid,String nationName) {
		this.nationid = nationid;
		this.nationName = nationName;
	}
	public int getNationid() {
		return nationid;
	}
	public void setNationid(int nationid) {
		this.nationid = nationid;
	}
	public String getNationName() {
		return nationName;
	}
	public void setNationName(String nationName) {
		this.nationName = nationName;
	}
	
}
