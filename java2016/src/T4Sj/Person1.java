package T4Sj;
//定义一个类，该类有一个私有成员变量，通过构造方法将其进行赋初值，并提供该成员的getXXX()和setXXX()方法 
import java.util.Scanner;
public class Person1 {
	private String name;
	public Person1(String n){
		this.setName(n);
	}
	public void setName(String n){
		name=n;
	}
	public String getName(){
		return name;
	}
	public void getInfo(){
		System.out.println("名字："+name);
	}
	public static void main(String[] args){
		Person1 per = new Person1("胡歌");
		per.getName();
		per.getInfo();
	}
}
