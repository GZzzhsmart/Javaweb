package T3;
import java.util.Scanner;
public class Jx {
	float height,width;
	public float zhouchang(float height,float width){
		return ((height+width)*2);
	}
	public float mianji(float height,float width){
		return (height*width);
	}
	public static void main(String[] args){
		Jx juxing = new Jx();
		float sum,sum1;
		Scanner input = new Scanner(System.in);
		System.out.println("请输入矩形的长和高");
		juxing.height=input.nextFloat();
		juxing.width=input.nextFloat();
		sum=juxing.zhouchang(juxing.width,juxing.height);
		sum1=juxing.mianji(juxing.width,juxing.height);
		System.out.println("长："+juxing.width);
		System.out.println("高："+juxing.height);
		System.out.println("面积："+sum1);
		System.out.println("周长："+sum);
	}
}
