package com.ht.aop;

public class HelloService implements IHello{

	public void helloSay(String name) {
		System.out.println("你好="+name);
		
	}

	public void testException() {
		int i=0;
		int j=10;
		int c= j/i;
	}
	
	public static void main(String[] args) {
		HelloService hello = new HelloService();
//		hello.helloSay("小美");
		hello.testException();
	}

	public void helloNiBi(String name) {
		
		System.out.println("你好，"+name+",棒棒的！");
	}

	public void test() {
		System.out.println("test.....");
		
	}

	

}
