package T2;

import java.util.Scanner;
/**
 * 1900到2016中有哪些闰年?
 * */
public class test7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a;
		a=1900;
		System.out.println("1900到2016中闰年有：\n");
		do{
			if(a%4==0&&a%100!=0||a%400==0){
				System.out.println(a+"\t");
			}
			a++;
		}while(a<=2016);
		if(a%8==0);
		System.out.println();
		System.out.println("\n");
	}
}
