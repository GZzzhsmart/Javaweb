package T2;
import java.util.Scanner;
/**
 * 编写一个程序实现如下功能：
	一个班有3个学生，每个学生有4门功课，从键盘输入学生每门功课的成绩并输出，
	最后打印出每门功课的最高分和每个学生的总分
 * */
public class test12 {
	public static void main(String[] args) {
		int a[][] = new int[4][5];
		int i,j;
		Scanner input = new Scanner(System.in);
		a[0][4]=a[1][4]=a[2][4]=0;
		a[3][0]=a[3][1]=a[3][2]=a[3][3]=0;
		for(i=0;i<3;i++){
			for(j=0;j<4;j++){
				a[i][j]=input.nextInt();
				a[i][4]+=a[i][j];
				if(a[3][j]<a[i][j])
					a[3][j]=a[i][j];
			}
		}
		System.out.print("课程1\t课程2\t课程3\t课程4\t总分\n");
		for(i=0;i<a.length;i++){
			for(j=0;j<a[i].length;j++){
				System.out.println(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
