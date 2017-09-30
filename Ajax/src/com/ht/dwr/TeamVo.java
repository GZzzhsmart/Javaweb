package com.ht.dwr;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings({ "unused", "serial" })
public class TeamVo implements Serializable{

	private int id;
	private String teamName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
