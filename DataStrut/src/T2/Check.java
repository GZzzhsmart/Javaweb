package T2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

public class Check {

	/**
	 * 写一个代码检查器，
	 * 检查Java源程序中的括号是否匹配，
	 * 即每个“{”都有对应的“}”、每个“（”都有对应的“）”，使用栈实现
	 * 
	 * */
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<Character>();
		int n=0,n1=0,n2=0,n11=0,n22=0;
		//读取一个Java代码
		File file = new File("D:\\text.epf");
		String string="";
		String ch = "";
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((string=br.readLine())!=null){
				ch+=string;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for (int i = 0; i < ch.length(); i++) {
			if(ch.charAt(i)=='{'){
				stack.push(ch.charAt(i));
				n1++;
				System.out.println("n1="+ch.charAt(i));
			}else if(ch.charAt(i)=='}'){
				stack.push(ch.charAt(i));
				n11++;
				System.out.println("n11="+ch.charAt(i));
			}else if(ch.charAt(i)=='('){
				stack.push(ch.charAt(i));
				n2++;
				System.out.println("n2="+ch.charAt(i));
			}else if(ch.charAt(i)==')'){
				stack.push(ch.charAt(i));
				n22++;
				System.out.println("n22="+ch.charAt(i));
			}
		}
		
		if(n1==n11 && n2==n22){
			System.out.println("语法正确");
			System.out.println(n1+" "+n11);
			System.out.println(n2+" "+n22);
		}else if(n1<n11){
			System.out.println("语法错误，少了{");
			System.out.println(n1+" "+n11);
			System.out.println(n2+" "+n22);
		}else if(n1>n11){
			System.out.println("语法错误，少了}");
			System.out.println(n1+" "+n11);
			System.out.println(n2+" "+n22);
		}else if(n2<n22){
			System.out.println("语法错误，少了(");
			System.out.println(n1+" "+n11);
			System.out.println(n2+" "+n22);
		}else if(n2>n22){
			System.out.println("语法错误，少了)");
			System.out.println(n1+" "+n11);
			System.out.println(n2+" "+n22);
		}
	}
}
