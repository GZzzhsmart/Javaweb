package T2;
import java.util.Scanner;
/**
 * 写一条for 语句，计数条件为n 从100~200，步长为2；然后再用while 语句实现同样的循环
 * */
public class test18 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sum=0;
		for(int i=100;i<=200;i+=2){
			sum+=i;
		}
		System.out.println("100到200之间偶数的和="+sum);
		sum=0;
		int i=100;
		while(i<=200){
			sum+=i;
			i+=2;
		}
		System.out.println("100到200之间偶数的和="+sum);
	}
}
