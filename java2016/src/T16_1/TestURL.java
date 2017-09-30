package T16_1;

import java.io.*;
import java.net.*;

public class TestURL {
	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://images.sohu.com/uiue/sohu_logo/beijing2008/sohu.gif");
		InputStream in = url.openStream();//生成输入流
		FileOutputStream fout = new FileOutputStream(new File("sohu.gif"));
		int a=0;
		while(a>-1){
			a = in.read();//读入
			fout.write(a);//写入
		}
	}
}
