package T12;
/**
 * 4.1.	通过File类实现输出指定目录下包含的所有文件名，包含子目录
 * 
 * */
import java.io.*;
public class IteratorList {
	public void IteratorDir(File file){
		//如果file对象是文件则输出文件名
		if(file.isFile()){
			System.out.println(file.getAbsolutePath()+" "+file.getName());
		}else{
			//得到该目录下包含的全部文件对象数组
			File[] list = file.listFiles();
			for(int i=0;i<list.length;i++){
				File f = list[i];
				//递归调用
				IteratorDir(f);
			}
		}
	}
	public static void main(String[] args) {
		IteratorList test = new IteratorList();
		test.IteratorDir(new File("E:/"));
	}
}
