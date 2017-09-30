package T2;

import java.util.Stack;

public class YufaCheck {

	/**
	 * 写一个代码检查器，
	 * 检查Java源程序中的括号是否匹配，
	 * 即每个“{”都有对应的“}”、每个“（”都有对应的“）”，使用栈实现
	 * 
	 * */
	public static void main(String[] args) {
		String str = "if((a==b)&&(c==d) || (x==y)){}";
		boolean flag = false;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c=='('){
				//左括号入栈
				stack.push(c);
			}else if(c==')'){
				try{
					//右括号出栈
					stack.pop();
				}catch(Exception e){
					System.out.println("少了左括号(");
					flag=true;
				}
			}
			if(c=='{'){
				//左括号入栈
				stack.push(c);
			}else if(c=='}'){
				try{
					//右括号出栈
					stack.pop();
				}catch(Exception e){
					System.out.println("少了左括号{");
					flag = true;
				}
			}
		}
		if(!flag &&stack.size()==0){
			System.out.println("语法正常");
		}
		if(stack.size()>0){
			System.out.println("少了右括号");
		}
	}
}
