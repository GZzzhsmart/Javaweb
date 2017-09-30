package T3;

public class Teacher {
	
	String name;
	String sex;
	int age;
	
	static int count = 0;


	public Teacher() {
		count++;
	}

	public Teacher(String name, String sex, int age) {
		this.name = name;
		this.sex = sex;
		this.age = age;
		count++;
	}
	@Override
	public String toString() {
		
		return "老师姓名："+this.name +";性别："+this.sex +";年龄："+this.age+",共有"+this.count+"位老师";
	}
	public static void displayCount(){
		System.out.println("count="+count);
	}
	
	public static void display(){
		
		System.out.println("共有"+Teacher.count+"位老师");
		displayCount();
	}
	
}
