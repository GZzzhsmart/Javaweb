package T4Sj;
/*创建一个名称为StaticDemo的类，
 * 并声明一个静态变量和一个普通变量。
 * 对变量分别赋予10和5的初始值。
 * 在main()方法中输出变量值。  
 * */
import java.util.Scanner;
public class StaticDemo {
	private static int a=10;
	private int b=5;
	public String getInfo(){
		return "a="+a+"\nb="+b;
	}
	public static void main(String[] args){
		StaticDemo m = new StaticDemo();
		System.out.println(m.getInfo());
	}
}
