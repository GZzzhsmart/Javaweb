package Fuxi;

import java.util.Scanner;

public class Shuixianhua {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int a,b,c;
		for(int d=100;d<1000;d++){
			a=d/100%100;
			b=d/10%10;
			c=d/1%10;
			if(d==a*a*a+b*b*b+c*c*c){
				System.out.println("ˮ�ɻ���="+d);
			}
		}
	}
}
