package T4;

public class Person {
	public String name;
	protected String sex;
	int age;
	private String cardno;
	public Person(){
		
	}
	public Person(String name,String sex,int age,String cardno){
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.cardno = cardno;
	}
	public void display(){
		System.out.println("name:"+this.name +";sex:"+sex+";age:"+age+";cardno"+this.cardno);
	}
}
