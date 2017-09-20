package com.gs.bean;

import java.util.Set;

public class Student1 {
	
	private int id;
	private String name;
	private String gender;
	private int age;
	
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<Score1> getScores() {
		return scores;
	}

	public void setScores(Set<Score1> scores) {
		this.scores = scores;
	}

}
