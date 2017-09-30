package T4Sj;
//编写Java程序，用于显示人的姓名和年龄
import java.util.Scanner;
public class Person {
	private String name;
	private int age;
	public Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void display(){
		System.out.println("姓名："+name+";年龄："+age);
	}
	public static void main(String[] args){
		Person per = new Person("胡歌",40);
		per.display();
	}
}
