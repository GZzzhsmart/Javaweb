package T2;

import java.util.Scanner;

public class Jx {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i,j,k;
		for(i=0;i<=3;i++){
			for(j=0;j<=2-i;j++){
				System.out.printf("");
			}
			for(k=0;k<=2*i;k++){
				System.out.printf("*");
			}
			System.out.printf("\n");
		}
		
		for(i=0;i<=2;i++){
			for(j=0;j<=i;j++){
				System.out.printf("");
			}
			for(k=0;k<=4-2*i;k++){
				System.out.printf("*");
			}
			System.out.printf("\n");
		}
	}
}
