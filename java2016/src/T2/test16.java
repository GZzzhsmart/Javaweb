package T2;
import java.util.Scanner;
/**
 * 求n的阶乘,如10!=10*9*8*7...*2*1;
 * */
public class test16 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int i=0;
		double sum=1;
		System.out.println("请输入一个数字：");
		for(i=1;i<=n;i++){
			sum*=i;
			if(i!=n){
				System.out.println("i*="+i);
			}
		}
		if(i==n){
			System.out.println("i="+i);
		}
		System.out.println("sum="+sum);
	}
}
