package T4Sj;
/*建立一个汽车类，包括轮胎tires个数，汽车颜色color，车身重量load等属性。
 * 并通过不同的构造方法创建事例。 
  至少要求：汽车能够加速，减速，停车。   
 * */
import java.util.Scanner;
public class Car1 {
	private int tires;
	private String color;
	private int load;
	public Car1(int tires){
		this.tires=tires;
		System.out.println("轮胎个数："+tires);
	}
	public Car1(String color){
		this.color=color;
		System.out.println("汽车颜色："+color);
	}
	public Car1(int tires,String color,int load){
		this(tires);
		this.color=color;
		System.out.println("汽车颜色："+color);
		this.load=load;
		System.out.println("汽车重量："+load);
	}
	public void speedUp(){
		System.out.println("车子正在加速");
	}
	public void speedDown(){
		System.out.println("车子正在减速");
	}
	public void stop(){
		System.out.println("车子已经停止");
	}
	public static void main(String[] args){
		Car1 a = new Car1(6);
		Car1 b = new Car1(4,"白色",4000);
		a.speedUp();
		b.stop();
	}
}

