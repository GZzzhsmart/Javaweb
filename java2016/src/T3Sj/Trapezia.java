package T3Sj;
//创建Trapezia类用来设置梯形的底与高，并给出求面积的方法
import java.util.Scanner;
public class Trapezia {
	double a,b,height,area;
	
	public double getArea(){
		
		return (a+b)*height/2;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入梯形的低和高：");
		Trapezia trap = new Trapezia();
		trap.a = input.nextDouble();
		trap.b = input.nextDouble();
		trap.height = input.nextDouble();
		System.out.println("梯形的面积="+trap.getArea());
	}
}
