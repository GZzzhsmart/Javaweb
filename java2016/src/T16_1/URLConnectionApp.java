package T16_1;

import java.io.*;
import java.net.*;

public class URLConnectionApp {
	public static void main(String[] args) {
		
		//异常处理
		try{
			//创建一个URL对象
			URL url = new URL("http://www.sohu.com");
			//调用openConnection()方法，返回一个URLConnection对象
			URLConnection apply = url.openConnection();
			System.out.println("连接的URL信息:");
			//显示URL的一些信息
			for(int i=1;i<8;i++){
				System.out.println(apply.getHeaderField(i));
				
			}
			//调用getInputStream()方法，返回一个InputStream对象inStream
			InputStream inStream = apply.getInputStream();
			 //以inStream为参数生成一个InputStreamReader对象
            //以InputStreamReader为参数
            //生成一个BufferedReader对象read
			BufferedReader read = new BufferedReader(new InputStreamReader(inStream));
			
			System.out.println("生成与URL连接成功的输入流");
			
			//从URL中读取一行数据
			String URLConnection = read.readLine();
			System.out.println("得到的一行HTML代码："+URLConnection);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
