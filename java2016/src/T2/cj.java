package T2;
import java.util.Scanner;
/**
 * 看y的运行次数是多少
 * */
public class cj {
	public static void main(String[] args) {
		int x,y;
		for(x=1,y=1;y<=50;y++){
			if(x>=10){
				break;
			}
			if(x%2==1){
				x+=5;
				continue;
			}
			x-=3;
		}
		System.out.println(y);
	}
}
