package com.ht.aop;

import com.ht.base.WebApplicationContextUtil;

public class AOPTest {

	public static void main(String[] args) {
//		IHello hello = (IHello)WebApplicationContextUtil.createAppService("helloProxy");
//		hello.helloSay("小张");
//		hello.testException();
		ISome some = (ISome)WebApplicationContextUtil.createAppService("helloProxy");
		some.setData("aabbccdd");
		System.out.println(some.getData());
		try {
			//物件被锁定
			((ILockable) some).lock();
			//无法呼叫set方法，丢出例外
			some.setData("moner");
			// 由于会丢出例外，所以下面的这行程序无法被执行 
			System.out.println(some.getData());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		//object is unlocked
		((ILockable) some).lock();
		//It's ok to use setter again
		some.setData("moner1234");
		System.out.println(some.getData());
	}
}
