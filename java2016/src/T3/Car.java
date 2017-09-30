package T3;
import java.util.Scanner;
public class Car {
	private int tires;
	private String color;
	private int load;
	public Car(int tires){
		this.tires=tires;
		System.out.println("轮胎个数："+tires);
	}
	public Car(String color){
		this.color=color;
		System.out.println("汽车颜色："+color);
	}
	public Car(int tires,String color,int load){
		this(tires);
		this.color=color;
		System.out.println("汽车颜色："+color);
		this.load=load;
		System.out.println("汽车重量："+load);
	}
	public void speedUp(){
		System.out.println("汽车正在加速中");
	}
	public void speedDown(){
		System.out.println("汽车正在减速中");
	}
	public void stop(){
		System.out.println("汽车已经停止");
	}
	public static void main(String[] args){
		Car a = new Car(6);
		Car b = new Car(4,"白色",4000);
		a.speedUp();
		b.stop();
	}
}
