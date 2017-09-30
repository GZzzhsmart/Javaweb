package T2lianxi;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Caishuzi {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num,count=0;
		int n;
		Random random = new Random();
		num = Math.abs(random.nextInt(100));
		Date date1 = new Date();
		long d1 = date1.getTime();
		System.out.println("请输入一个数字");
		do{
			count++;
			n = input.nextInt();
			if(num>n){
				System.out.println("您输入的数字太小了");
			}else if(num<n){
				System.out.println("您输入的数字太大了");
			}else{
				Date date2 = new Date();
				long d2 = date2.getTime();
				long time = (d2-d1)/1000;
				System.out.println("恭喜您猜对了，共猜了"+count+"次");
				System.out.println("花费时间"+time+"秒");
			}
		}while(num!=n);
		
	}
}
