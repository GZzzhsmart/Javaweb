package T12;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class FileOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\File\\file.txt");
		//如果文件不存在先创建文件
		if(!file.exists()){
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file,true);
		String str = "我是特工007";
		//转换为字节数组
		byte b[]=str.getBytes();
		fos.write(b,0,b.length);
		//关闭文件
		fos.close();
	}
}
