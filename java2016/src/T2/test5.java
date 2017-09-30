package T2;
import java.util.Scanner;
/**
 * 张丘建《算经》中提出“百鸡问题”：
 * 鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、母、雏各几何？
 * */
public class test5 {
	public static void main(String[] args) {
		int a,b,c;
		for(a=1;a<=20;a++){
			for(b=1;b<=33;b++){
				c=100-a-b;
				if(a+b+c==100 && 5*a+3*b+1/3*c==100){
					System.out.println("鸡翁="+a);
					System.out.println("鸡母="+b);
					System.out.println("鸡雏="+c);
					System.out.println("");
				}
			}
		}
	}
}
