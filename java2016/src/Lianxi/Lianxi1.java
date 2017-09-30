package Lianxi;
/**
 * 一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
 * */
import java.util.Scanner;
@SuppressWarnings("unused")
public class Lianxi1 {
	public static void main(String[] args) {
		for(int x=1;x<100000;x++){
			if(Math.sqrt(x+100)%1==0){
				if(Math.sqrt(x+168)%1==0){
					System.out.println(x+"加100是一个完全平方数，再加168又是一个完全平方数");
				}
			}
		}
	}
}
