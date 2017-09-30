package T2;
import java.util.Scanner;
/**
 * 打印菱形
 * */
public class test15 {
	public static void main(String[] args) {
		 int zhongjian,kongge,xinhao,i,j;
		  Scanner input = new Scanner(System.in); //新建一个输入实例 
		  System.out.println("请输入行数：");
		  int hang = input.nextInt();
		  zhongjian=hang/2+1;
		  for(i=1;i<=zhongjian;i++)
		  {
			xinhao=i*2-1;
			kongge=(hang-xinhao)/2;
			for(j=0;j<kongge;j++)
			{
				System.out.printf(" ");
			}
			for(j=1;j<=xinhao;j++)
			{
				System.out.printf("*");
			}
			System.out.printf("\n");
		  }
		for(i=zhongjian-1;i>0;i--){
			xinhao=i*2-1;
			kongge=(hang-xinhao)/2;
			for(j=0;j<kongge;j++){
				System.out.printf(" ");
			}for(j=1;j<=xinhao;j++){
				System.out.printf("*");
			}
			System.out.printf("\n");
		}
	}
}
