package T5;

public class SubClass extends AbstractClass{
	public SubClass(){
		
	}
	public SubClass(int a,int b){
		this.a=a;
		this.b=b;
	}
	public void display(){
		System.out.println("a="+a+";b="+b);
	}
}
