package Fuxi;

import java.util.Scanner;

public class chu {

	//1��100����Щ���ֿ��Ա�3��7����
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num=0,i = 0;
		for(i=1;i<=100;i++){
			if(i%3==0 && i%7==0){
				System.out.println(i);
			}
		}
	}
}
