package com.gs.bean;

public class Score1 {
	
	private int id;
	private float score;
	
	private Student1 stu;
	private Course1 course;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public Student1 getStu() {
		return stu;
	}
	public void setStu(Student1 stu) {
		this.stu = stu;
	}
	public Course1 getCourse() {
		return course;
	}
	public void setCourse(Course1 course) {
		this.course = course;
	}
	
}
