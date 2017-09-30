package T11;

import java.util.Stack;
public class StackDemo {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		//peek取出栈顶元素，不会删除元素
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println("size="+stack.size());
		//isEmpty判断堆栈中是否有元素
		while(!stack.isEmpty()){
			//取元素值pop(取出元素的同时，也会删除元素)
			System.out.println(stack.pop());
		}
		System.out.println("size="+stack.size());
//		System.out.println(stack.peek());报错
	}
}
