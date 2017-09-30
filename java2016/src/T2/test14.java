package T2;
import java.util.Scanner;
/**
 * 猴子吃桃问题
 * */
public class test14 {
	public static void main(String[] args) {
		int a,sum=1;
		for(a=9;a>0;a--){
			sum=(sum+1)*2;
			System.out.println("第"+a+"天摘了"+sum+"个桃子");
		}
		System.out.println("sum="+sum);
	}
}
