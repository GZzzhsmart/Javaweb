package T12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
	public static void main(String[] args) {
		String sfilename="D:/FeigeDownload/Java/java20161/src/T7/Calc.java";
		File file = new File(sfilename);
		try{
			FileInputStream fis = new FileInputStream(file);
			//定义保存文件内容的字节数组
			byte b[]=new byte[1024];
			String content="";
			int n=0;
			while((n=fis.read(b,0,b.length))!=-1){
				//把字节数组转换成字符串
				content+=new String(b,0,n);
				
			}
			System.out.println(content);
			//关闭文件
			fis.close();
		}catch(FileNotFoundException  e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
