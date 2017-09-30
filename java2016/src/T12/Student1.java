package T12;

import java.io.*;
public class Student1 implements Serializable{
	int id;
	String name;
	int age;
	String department;
	
	public Student1(int id,String name,int age,String department){
		this.id=id;
		this.name=name;
		this.age=age;
		this.department=department;
	}
	public static void main(String[] args) {
		Student1 stu = new Student1(1001,"Liu Ming",18,"CSD");
		Student1 stug;
		try{
			FileOutputStream fo = new FileOutputStream("data.ser");
			//保存对象的状态 实现序列化
			ObjectOutputStream so = new ObjectOutputStream(fo);
			so.writeObject(stu);
			so.close();
			
			FileInputStream fi = new FileInputStream("data.ser");
			ObjectInputStream si = new ObjectInputStream(fi);
			
			//恢复对象的状态 实现反序列化
			stug=(Student1) si.readObject();
			System.out.println(stug.name);
			si.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
