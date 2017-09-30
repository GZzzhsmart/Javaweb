package T12;
/**
 * 5.2.	在d:\jtd下有些文件，用java把里面的.jtd文件改成.Java文件保存在d:\java中
 * @author admin
 * */
import java.io.*;
public class ChangeJtdToJava {
	public static void main(String[] args) {
		File dir = new File("d:/jtd");
		//得到d:/jtd下的所有文件对象
		File[] files = dir.listFiles();
		for(File file:files){
			String filename = file.getName();
			int index = filename.indexOf(".");
			String filename2 = filename.substring(0,index);
			String houzui = filename.substring(index);
			if(houzui.equals(".jtd")){
				file.renameTo(new File("d:/java/"+filename2+".java"));
			}
		}
	}
}
