package T2lianxi;

import java.util.Scanner;

public class Shuixianhua {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i,j,k;
		for(int p=100;p<1000;p++){
			i=p/100%100;
			j=p/10%10;
			k=p/1%10;
			if(p==i*i*i+j*j*j+k*k*k){
				System.out.println("水仙花数="+p);
			}
		}
	}
}
