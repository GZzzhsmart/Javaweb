package T3;
import java.util.Scanner;
public class Circle {
	double radius;
	public double zhouchang(double radius){
		return (2*radius*Math.PI);
	}
	public double mianji(double radius){
		return (Math.PI*radius*radius);
	}
	public static void main(String[] args){
		Circle C1=new Circle();
		Circle C2=new Circle();
		Scanner in = new Scanner(System.in);
		double sum,sum1;
		System.out.println("请输入圆1的半径");
		C1.radius=in.nextDouble();
		System.out.println("请输入圆2的半径");
		C2.radius=in.nextDouble();
		sum=C1.zhouchang(C1.radius);
		sum1=C1.mianji(C1.radius);
		sum=C2.zhouchang(C2.radius);
		sum1=C2.mianji(C2.radius);
		System.out.println("圆1的面积周长如下：");
		System.out.println("半径："+C1.radius);
		System.out.println("周长："+sum);
		System.out.println("面积："+sum1);
		System.out.println("圆2的面积和周长如下：");
		System.out.println("半径："+C2.radius);
		System.out.println("周长："+sum);
		System.out.println("面积"+sum1);
	}
}
