package T12;

import java.io.File;
import java.io.FilenameFilter;

public class FilterDemo {
	
	public static void main(String[] args) {
		File file = new File("D:\\FeigeDownload\\Java\\T12 src");
		
		FilterName filter = new FilterName("java");
		String[] filelist = file.list(filter);
		for(int i=0;i<filelist.length;i++){
			System.out.println(filelist[i]);
		}
	}
}

class FilterName implements FilenameFilter{
	String extent;
	public FilterName(String extent){
		this.extent=extent;
	}
	//实现过滤文件类型的发方法
	public boolean accept(File dir, String name) {
		//返回文件的后缀名
		return name.endsWith("." +extent);
	}
	
}