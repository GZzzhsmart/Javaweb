package Fuxi;

import java.util.Scanner;

public class Jiecheng {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("������һ������");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int i=0;
		long sum=1;
		for(i=1;i<=n;i++){
			sum*=i;
		}
		System.out.println(sum);
	}
}
