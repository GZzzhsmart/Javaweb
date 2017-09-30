package T2;
import java.util.Scanner;
public class sushu {

	public static void main(String[] args) {
		int count=0,t=0;
		for(int i=2;i<100;i++){
			t=0;
			for(int j=2;j<i;j++){
				if(i%j==0){
					t=1;
				}
			}
			if(t==0){
				System.out.println(i+"\t");
				count++;
				if(count%8==0){
					System.out.println("\n");
				}
			}
		}
		System.out.println("\n");
		System.out.println("1到100之间的素数有"+count+"个");
	}
}
