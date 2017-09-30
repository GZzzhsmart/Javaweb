package T2;
import java.util.Scanner;
/**
 * 从键盘上输入两个整数，由用户回答它们的和，差，积，商和取余运算结果，并统计出正确答案的个数
 * */
public class test20 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a,b;
		int cnt=0;
		
		System.out.println("请输入2个数:");
		a = input.nextInt();
		b = input.nextInt();
		System.out.println("请输入和：");
		int sum = input.nextInt();
		if(sum==(a+b)){
			cnt++;
		}
		System.out.println("请输入差：");
		sum = input.nextInt();
		if(sum==(a-b)){
			cnt++;
		}
		System.out.println("请输入积：");
		sum = input.nextInt();
		if(sum==(a*b)){
			cnt++;
		}
		System.out.println("请输入商：");
		sum = input.nextInt();
		if(sum==(a/b)){
			cnt++;
		}
		System.out.println("请输入余数：");
		sum = input.nextInt();
		if(sum==(a%b)){
			cnt++;
		}
		System.out.println("正确答案个数="+cnt);
		System.out.println(a+"+"+b+"的和="+(a+b));
		System.out.println(a+"-"+b+"的差="+(a-b));
		System.out.println(a+"*"+b+"的积="+(a*b));
		System.out.println(a+"/"+b+"的商="+(a/b));
		System.out.println(a+"%"+b+"的余数="+(a%b));
	}
}
