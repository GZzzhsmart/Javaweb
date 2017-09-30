package T12lianxi;

import java.io.*;

import T12.ObjectOutputStreamDemo;

public class ByteArrayTest {
	public static void main(String[] args) throws Exception{
		String tmp="abcdefghijklmnopqrstuvwxyz";
		//src为转换前的内存块
		byte [] src = tmp.getBytes();
		//字节数组输入流
		ByteArrayInputStream input = new ByteArrayInputStream(src);
		//字节数组输出流
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		new ByteArrayTest().transform(input,output);
		//输出到另一个字节数组
		byte [] result = output.toByteArray();//result为转换后的内存块
		System.out.println(new String(result));
	}

	public void transform(InputStream in,OutputStream out){
		int c=0;
		try{
			//c代表当前读取的字节
			while((c=in.read())!=-1)//read在读到流的结尾处返回-1
			{
				//toUpperCase把小写字母转换为大写字母
				int C = (int) Character.toUpperCase((char)c);
				out.write(C);
			}
		}catch(Exception e){
			e.printStackTrace();
			e.printStackTrace();
		}
	}
}

