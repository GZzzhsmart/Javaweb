package T5Sj;
import java.util.Scanner;
public class Employee extends Role{
	private int salary;
	private static String ID;
	public Employee(int a,String i){
		super(a);
		setID(i);
	}
	public Employee(int a,String b,int s,String i){
		this(a,i);
		this.setName(b);
		setSalary(s);
	}
	private void setSalary(int s) {
		// TODO Auto-generated method stub
		
	}
	public void setID(String i){
		ID=i;
	}
	public String getID(){
		return ID;
	}
	public int getSalary(){
		return salary;
	}
	public void play(){
		
		System.out.println("职工信息：\n"+"\n 姓名："+getName()+"\n 年龄："+getAge()+"\n 薪水："+getSalary()+"元\n 编号："+getID());
	}
	public final void sing(){
		System.out.println("----------");
	}
}
