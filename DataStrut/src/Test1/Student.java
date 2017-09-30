package Test1;

import java.io.Serializable;

public class Student implements Serializable{

	private int studid;
	private String name;
	private int age;
	private String className;
	public Student() {
		
	}
	public Student(int studid,String name,int age,String className) {
		this.studid = studid;
		this.name = name;
		this.age = age;
		this.className = className;
	}
	
	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "学号："+this.studid +",姓名："+this.name+",年龄:"+this.age +",班级:"+this.className;
	}
}
