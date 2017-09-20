package com.ht.base;

public class ProxyTestImpl implements IProxyTest {

	public void add() {
		System.out.println("execute add function()");
	}

	public void del() {
		System.out.println("execute del function()");
	}

	public void get(int id) {
		System.out.println("execute get function()");
	}

}
