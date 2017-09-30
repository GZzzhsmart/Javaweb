package T2;
import java.util.Scanner;
/**
 * 编写程序，输入4*5的二维数组数值，统计二维数组中奇数的个数和偶数的个数
 * */
public class test11 {
	public static void main(String[] args) {
		int a[][]=new int [4][5];
		int i,j,odd=0,even=0;
		Scanner input = new Scanner(System.in);
		for(i=0;i<a.length;i++){
			for(j=0;j<a[i].length;j++){
				a[i][j]=input.nextInt();
				if(a[i][j]%2==0){
					even++;
				}else{
					odd++;
				}
			}
		}
		for(i=0;i<a.length;i++){
			for(j=0;j<a[i].length;j++){
				System.out.println(a[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.print("odd="+odd+";even="+even);
	}
}
