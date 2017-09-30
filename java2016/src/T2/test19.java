package T2;
import java.util.Scanner;
/**
 * 编写程序，把由10 个元素组成的一维数组逆序存放再输出
 * */
public class test19 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a[]={1,2,3,4,5,6,7,8,9,10};
		int t=0;
		int i;
		for(i=0;i<a.length/2;i++){
			t=a[i];
			a[i]=a[9-i];
			a[9-i]=t;
		}
		for(i=0;i<a.length;i++){
			System.out.println(a[i]+"\t");
		}
	}
}
