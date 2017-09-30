package T6;

import java.util.Vector;

//线性查找
public class FindInVector extends Vector{

	public void addPerson(String name,int age){
		this.add(new Person(name,age));
	}
	public int query(String name){
		int age=-1;
		for(int i=0;i<this.size();i++){
			Person p=(Person)(this.get(i));
			if(p.getName().equals(name)){
				age=(int)p.getAge();
				break;		//找到姓名后退出
			}
		}
		return age;
	}

	public static void main(String args[]){
		FindInVector find=new FindInVector();
		find.addPerson("小赖子",11);
		find.addPerson("小智",13);
		find.addPerson("小露",15);
		int age=find.query("小露");
		if(age!=-1){
			System.out.println("小露: "+"年龄 "+age);
		}else{
			System.out.println("没找到该同志");
		}
	}
}
class Person{
	private String name;
	private int age;
	public Person(String name,int age){
		this.name = name;
		this.age = age;
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
	
}
