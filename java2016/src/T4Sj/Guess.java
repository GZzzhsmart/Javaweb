package T4Sj;
import java.util.Random;
import java.util.Scanner;
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
		System.out.println("请输入0~100之间的数字");
		do{
			count++;
			n = input.nextInt();
			if(num>n){
				System.out.println("您输入的数字太小了，请重新输入：");
			}else if(num<n){
				System.out.println("您输入的数字太大了，请重新输入：");
			}else{
				System.out.println("恭喜您猜对了，共猜了"+count+"次!!");
			}
		}while(num!=n);
	}
	public static void main(String[] args){
	//	Guess guess = new Guess();
	//	guess.guessnum();
		new Guess().guessnum();
	}
}
