package T4Sj;
/*创建一个类，为该类定义三个构造函数，分别执行下列操作：  
 *  1、传递两个整数值并找出其中较大的一个值   
 *  2、传递三个double值并求出其乘积   
 *  3、传递两个字符串值并检查其是否相同   
 *  4、在main方法中测试构造函数的调用  
 * */
import java.util.Scanner;
public class Check {
	public Check(int a,int b){
		int c = Math.max(a, b);
		System.out.println("较大值为："+c);
	}
	public Check(double a,double b,double c){
		double d=a*b*c;
		System.out.println("a*b*c="+d);
	}
	public Check(String a,String b){
		boolean c = a.equals(b);
		System.out.println("两字符串相等："+c);
	}
	public static void main(String[] args){
		Check m = new Check(4,8);
		Check n = new Check(3.3,4.2,4.0);
		Check p = new Check("ac","ab");
	}
}
