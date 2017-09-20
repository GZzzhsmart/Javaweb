package com.ht.test;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
/*
 * Spring监听类
 * */
public class CustomListener implements ApplicationListener{

	public void onApplicationEvent(ApplicationEvent name) {

		if(name instanceof SomeObject) {
			System.out.println(name.getSource());
		}
	}

}
