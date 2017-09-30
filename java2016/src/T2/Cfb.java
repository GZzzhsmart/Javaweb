package T2;
import java.util.Scanner;
/**
 * 打印九九乘法表
 * */
public class Cfb {
	public static void main(String[] args) {
		int i,j;
		for(i=1;i<=9;i++){
			for(j=1;j<=i;j++){
				System.out.print(j+"*"+i+"="+(i*j)+"\t");
			}
			System.out.println("");
		}
	}
}
