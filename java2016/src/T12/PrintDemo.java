package T12;
/**
 * 4.3.	编一段代码，实现在控制台输入一组数字后，排序后在控制台输出，直到输入"END"为止
 * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import T5Sj.interfaceDemo;

public class PrintDemo {
	public static void main(String[] args) {
		String str;
		boolean b = true;
		ArrayList<Integer> list = new ArrayList();
		//接受键盘输入并保存到input流中
		InputStreamReader stdin = new InputStreamReader(System.in);
		//并将其转换成缓冲流保存
		BufferedReader bufin = new BufferedReader(stdin);
		
		while(b){
			try{
				System.out.print("请输入字符： ");
				str = bufin.readLine();//读当前行的内容
				if(str.equals("end"))
					b=false;
				if(b){
					list.add(Integer.valueOf(str));
					System.out.println("你输入的字符为："+str);
				}
			}catch(IOException E){
				System.out.println("发生了I/O错误!!!");
				b=false;
			}
		}
		System.out.println("排序结果");
		Object[] a = list.toArray();
		Arrays.sort(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
}
