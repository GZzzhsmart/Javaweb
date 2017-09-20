package com.ht.aop;

public class Some implements ISome{

	private Object data;
	public void doSome() {
		System.out.println("原来的职责");
	}
	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
}
