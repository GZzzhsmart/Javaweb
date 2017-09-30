package T2;
import java.util.Scanner;
/**
 * 输入一个三位数，每个数分解出个位，十位，百位。
 * */
public class test8 {
	public static void main(String[] args) {
		int a,b,c,num=123;
		System.out.println("请输入一个三位数：");
		a=num/100%10;
		b=num/10%10;
		c=num%10;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
