package T2lianxi;

import java.util.Scanner;
/**
 * 求n的阶乘，如10!=10*9*8..*1;
 * */
public class jiecehng {
	public static void main(String[] args) {
		System.out.println("请输入一个数字:");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int i=0;
		long sum=1;
		for(i=1;i<=n;i++){
			sum*=i;
		}
		System.out.println("sum="+sum);
	}
}
