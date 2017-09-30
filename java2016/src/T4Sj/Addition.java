package T4Sj;
/*10.构造方法与重载、包 编写Addition类，该类中应包含一组实现两数相加运算的重载方法。
 *  实现加法运算的方法，应接受两个参数（即加数和被加数），
 *  方法将两个参数进行加法运算后，返回相加结果。考虑可能针对不同的数据类型进行计算，
 *  重载一组方法，包括整型int、长整型long、浮点型float、双精度浮点型double、还有字符串String。 
 *  在main方法中创建Addition类的实例，分别调用重载方法测试其效果。 
 *  应将Addition类打入到包中，以自己名字的拼音为包命名。  
 * 
 * */
import java.util.Scanner;
public class Addition {
	public Addition(){
		
	}
	public void add(int a,int b){
		int c=a+b;
		System.out.println("a+b="+c);
	}
	public void add(long a,long b){
		long c=a+b;
		System.out.println("a+b="+c);
	}
	public void add(float a,float b){
		float c=a+b;
		System.out.println("a+b="+c);
	}
	public void add(double a,double b){
		double c=a+b;
		System.out.println("a+b="+c);
	}
	public void add(String a,String b){
		String c=a+b;
		System.out.println("a+b="+c);
	}
	public static void main(String[] args){
		Addition m = new Addition();
		Addition n = new Addition();
		m.add(5, 6);
		n.add(3,4);
	}
	
}
