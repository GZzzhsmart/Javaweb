package T2;

import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		Stack<String> myStack = new Stack<String>();
		myStack.push("组长");
		myStack.push("部门经理");
		myStack.push("主管副总");
		myStack.push("总经理");
		myStack.push("董事长");
		//取栈顶元素，但不删除
		System.out.println(myStack.peek());
		System.out.println(myStack.peek());
		//大小
		System.out.println("------------size="+myStack.size());
		//容量
		System.out.println("------------size="+myStack.capacity());
		while(!myStack.isEmpty()){
			//去栈顶元素，同时删除该元素
			System.out.println(myStack.pop());
		}
		//大小
		System.out.println("------------size="+myStack.size());
		//容量
		System.out.println("------------size="+myStack.capacity());
	}
}
