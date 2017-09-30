package Lianxi;
/**
 * 显示当前目录下的文件夹
 * */
import java.io.*;
public class Lianxi5 {
	public static void main(String[] args) throws Exception {
		File f = new File("D://FeigeDownLoad//Java//T4 src//Person.java");
		System.out.println(f.getCanonicalPath());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getPath());
		System.out.println(f.getCanonicalPath());
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getParentFile());
		System.out.println(f.getParent());
	}
}
