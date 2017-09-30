package Fuxi;

import java.util.Scanner;

public class gongbeishu {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("������2������:");
		int x = input.nextInt();
		int y = input.nextInt();
		int i,a=1;
		for(i=1;i<=y;i++){
			if(x%i==0&&y%i==0){
				a=i;
			}
		}
		System.out.println("���Լ��"+a);
		System.out.println("��С������"+(x*y)/a);
	}
}
