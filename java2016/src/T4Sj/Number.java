package T4Sj;
//编写Java程序，模拟简单的计算器
import java.util.Scanner;
public class Number {
	private int n1;
	private int n2;
	
	//构造方法
	public Number(int n1,int n2){
		
		this.n1=n1;
		this.n2=n2;
	}
	//加
	public int addition(){
		System.out.println(this.n1+this.n2);
		return this.n1+this.n2;
	}
	//减
	public int subtration(){
		System.out.println(this.n1-this.n2);
		return this.n1-this.n2;
	}
	//乘
	public int multiplication(){
		System.out.println(this.n1*this.n2);
		return this.n1*this.n2;
	}
	//除
	public int division(){
		System.out.println(this.n1/this.n2);
		return this.n1/this.n2;
	}
	public int getN1(){
		return n1;
	}
	public void setN1(int n1){
		this.n1=n1;
	}
	public int getN2(){
		return n2;
	}
	public void setN2(int n2){
		this.n2=n2;
	}
	public static void main(String[] args){
		Number number = new Number(4,3);
		number.addition();
		number.subtration();
		number.multiplication();
		number.division();
	}
}
