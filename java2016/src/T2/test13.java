package T2;
import java.util.Scanner;
/**
 * 水仙花数
 * */
public class test13 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a,b,c,p=100;
		for(p=100;p<1000;p++){
			a=p/100%100;
			b=p/10%10;
			c=p/1%10;
			if(p==a*a*a+b*b*b+c*c*c){
				System.out.println("p="+p);
			}
		}
	}
}
