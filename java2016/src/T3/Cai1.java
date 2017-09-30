package T3;
/**
 * 现在有小鸟和大象，它们共有36个头和100只脚，求它们有多少只
 * */
import java.util.Scanner;

import T5Sj.interfaceDemo;
public class Cai1 {
	public static void main(String[] args) {
		int i,j;
		for(i=0;i<=36;i++){
			for(j=0;j<=36;j++){
				if((i*2+4*j==100)&&(i+j==36)){
					System.out.println("i="+i);
					System.out.println("j="+j);
					return;
				}
			}
		}
	}
}
