package Lianxi;
/**
 * 自定义异常例子
 * */
import java.lang.Throwable;
public class Lianxi3 {
	public static void main(String[] args) {
		try{
			throw new Throwable("Here is my Exception");
		}catch(Throwable e){
			System.out.println("Caught Throwable");
			System.out.println("e.getMessage()"+e.getMessage());
			System.out.println("e.toString()"+e.toString());
			System.out.println("e.printStackTrace();");
			e.printStackTrace();
		}
	}
}
