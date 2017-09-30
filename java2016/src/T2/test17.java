package T2;
import java.util.Scanner;
/**
 * 求1到10 的和
 * */
public class test17 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i=1,sum=0;
		do{
			sum=sum+i;
			i++;
		}while(i<=100);
		System.out.println("1到100的和是"+sum);
	}
}
