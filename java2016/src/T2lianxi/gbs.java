package T2lianxi;

import java.util.Scanner;
/**
 * 求最大公约数和最小公倍数
 * */
public class gbs {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入两个数：");
		int x = input.nextInt();
		int y = input.nextInt();
		int m,i,a=1;
		m=x;
		m=(x>y)?y:x;
		for(i=1;i<=y;i++){
			if(x%i==0 && y%i==0){
				a=i;
			}
		}
		System.out.println("最大公因数="+a);
		System.out.println("最小公倍数="+(x*y)/a);
	}
}
