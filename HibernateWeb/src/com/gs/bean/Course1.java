package com.gs.bean;

import java.util.Set;

public class Course1 {
	
	private int id;
	private String name;
	private String des;
	
	private Set<Score1> scores;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Set<Score1> getScores() {
		return scores;
	}

	public void setScores(Set<Score1> scores) {
		this.scores = scores;
	}

}
