package T12;

import java.io.*;

public class TestInputStreamReader {
	public TestInputStreamReader(){
		int i=0;
		try{
			//根据文件名实例化一个文件对象
			File f = new File("a.txt");
			//将该文件对象中的内容以字节流的方式读入
			FileInputStream fis = new FileInputStream(f);
			BufferedInputStream bis = new BufferedInputStream(fis);
			//将字节流转换为字符流
			InputStreamReader isr = new InputStreamReader(bis);
			//一个一个字符的读取内容
			while((i=isr.read())>=0){
				System.out.print((char)i);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new TestInputStreamReader();
	}
}
