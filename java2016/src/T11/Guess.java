package T11;

import java.util.Random;
import java.util.Scanner;

import T5Sj.interfaceDemo;

public class Guess {
	int num;
	int n;
	public Guess(){
		Random rand = new Random();
		num=Math.abs(rand.nextInt()) % 100;
	}
	public void guessnum(){
		int count=0;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入商品的价格：");
		do{
			count++;
			n = input.nextInt();
			if(num>n){
				System.out.println("你输入的价格太小了：");
			}else if(num<n){
				System.out.println("你输入的价格太大了：");
			}else{
				System.out.println("恭喜你猜对了，共猜了"+count+"次");
			}
		}while(num!=n);
	}
	public static void main(String[] args){
		new Guess().guessnum();
	}
}
