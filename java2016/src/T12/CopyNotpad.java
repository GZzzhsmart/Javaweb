package T12;
/**
 * 5.1.	把一个记事本中的内容复制到另一个记事本中；
 * */
import java.io.*;
public class CopyNotpad {
	public static void main(String[] args) throws Exception{
		//根据读取文件生成一个file对象
		File file1 = new File("D:\\三字经a.txt");
		//根据文件对象生成一个文件输入流
		FileInputStream fis = new FileInputStream(file1);
		//通过InputStreamReader流来封装fis中的内容
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		//生成保存文件输入的内容
		File file2 = new File("D:\\三字经b.txt");
		//指定将输入的内容追加到指定的文件后面
		FileOutputStream fos = new FileOutputStream(file2,true);
		PrintWriter pw = new PrintWriter(fos,true);
		
		String s="";
		
		//使用行方式读取内容
		while((s=br.readLine())!=null){
			pw.println(s);
		}
	}
}
