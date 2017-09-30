package T12;

import java.io.Serializable;



public class Student implements Serializable{
	private int studId;
	private String studName;
	private String sex;
	private int age;
	
	public Student(){
		
	}
	public Student(int studId,String name,String sex,int age){
		this.studId=studId;
		this.studName=studName;
		this.sex=sex;
		this.age=age;
		
	}
	public int getStudId(){
		return studId;
	}
	public void setStudId(int studId){
		this.studId=studId;
	}
	public String getStudName(){
		return studName;
	}
	public void setStudName(String studName){
		this.studName=studName;
	}
	public String sex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	public int age(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	@Override
	public String toString(){
		return "studId="+studId+";studname="+studName+";sex="+sex+";age="+age;
		
	}
}
