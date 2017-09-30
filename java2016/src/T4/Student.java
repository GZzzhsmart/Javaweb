package T4;

public class Student {
	private int studid;
	private String name;
	private int age;
	private String classname;
	public Student() {
		studid=0;
		name="不知道";
		age=18;
		classname="未分配";
	}
	public Student(int studid,String name,int age,String classname){
		this.studid = studid;
		this.name = name;
		this.age = age;
		this.classname = classname;
	}
	public void display(){
		System.out.println("studid:"+this.studid+";name:"+name+";age:"+age+";classname:"+classname);
	}
	//set
	public void setStudid(int studid){
		this.studid = studid;
	}
	//get
	public int getStudid(){
		return this.studid;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
	public void setClassname(String classname){
		this.classname = classname;
	}
	public String getClassname(){
		return this.classname;
	}
	
}
