package com.ht.bean;

public class HelloService {

	public String sayHello(String name){
		System.out.println(name);
		return "你好，"+name;
	}
	public String sayHello1(String name){
		System.out.println(name);
		return "你好，"+name +",欢迎访问本站";
	}
	public String sayHello2(String name){
		System.out.println(name);
		return "你好，"+name +",你是第一个访问本站的用户";
	}
	public String sayHello3(String name){
		System.out.println(name);
		return "你好，"+name+",到处逛逛吧！";
	}
}
