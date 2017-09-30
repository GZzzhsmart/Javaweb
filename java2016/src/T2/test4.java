package T2;
import java.util.Scanner;
/**
 * 马戏团有鸟和大象，它们共有36个头和100只脚，问分别有多少鸟和大象？ 
 * */
public class test4 {
	public static void main(String[] args) {
		int bird=0;
		int big=0;
		/**
		 * bird+big=36;
		bird*2+big*4=100;
		 * */
		for(bird=0;bird<=36;bird++){
			for(big=0;big<=36;big++){
				if((bird*2+big*4==100)&&(big+bird==36)){
					System.out.println("bird="+bird);
					System.out.println("big="+big);
					return;
				}
			}
		}
	}
	
	
}
