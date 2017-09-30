package T2;

import java.util.Scanner;
public class Ruinian {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a=1900;
		
		System.out.println("1900~2016年的闰年有：\n");
		do{
			if(a%4==0&&a%100!=0||a%400==0){
				System.out.print(a+"\t");
			}
			a++;
		}while(a<=2016);
		if(a%8==0)
			System.out.println();
			System.out.println("\n");
	}
	
}
