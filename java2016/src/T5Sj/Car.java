package T5Sj;

public class Car extends Vehicles{
	int a;
	int b;
	public Car(int a,int b){
		this.a=a;
		this.b=b;
	}
	public String NoofWheels(){
		return "四轮车 \n载重："+a+"\n 体积："+b;
	}
}
