package T5Sj;

public class Motorbike extends Vehicles{
	int c;
	int d;
	public Motorbike(int c,int d){
		this.c=c;
		this.d=d;
	}
	public String NoofWheels(){
		return "双轮车 \n长度："+c+"\n 高度："+d;
	}
	public static void main(String[] args){
		Vehicles m = new Car(88,44);
		System.out.println(m.NoofWheels());
		Vehicles n = new Motorbike(3,4);
		System.out.println(n.NoofWheels());
	}
}
