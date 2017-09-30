package T2;
import java.util.Scanner;
/**
 * 求最大公因数和最小公倍数
 * */
public class test9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入2个数：");
		int x = input.nextInt();
		int y = input.nextInt();
		
		int m,i,a=1;
		m=x;
		if(x<y){
			x=y;
			y=m;
		}
		for(i=1;i<=y;i++){
			if(x%i==0&&y%i==0)
				a=i; 	
			}
		System.out.println("两数的最大公因数是:"+a);
		m=(x*y)/a;
		System.out.println("两数的最小公倍数是:"+m);
		}
		
	}

