package T2;

import java.util.Scanner;

public class djx1 {

	public static void main(String[] args) {
		int a[][]={{1,2,3},{4,5,6},{7,8,9}};
		int sum=0;
		int i,j;
		for(i=0;i<a.length;i++){
			for(j=0;j<a[i].length;j++){
				if(i==j){
					sum+=a[i][j];
				}
				if(i+j==2){
					sum+=a[i][j];
				}
			}
		}
		System.out.println("对角线之和="+sum);
	}
}
