package Lianxi;
/**
 * 显示文件内容
 * */
import java.io.*;
public class Lianxi4 {
	@SuppressWarnings({ "resource", "hiding" })
	public static void main(String[] args) {
		try{
			@SuppressWarnings("unused")
			FileInputStream fis = new FileInputStream("test");
			System.out.println("content of test is:");
		}catch(FileNotFoundException e){
			System.out.println(e);
			System.out.println("message:"+e.getMessage());
			e.printStackTrace(System.out);
		}catch(IOException e){
			System.out.println(e);
		}
	}
}
