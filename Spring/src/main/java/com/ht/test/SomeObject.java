package com.ht.test;

import org.springframework.context.ApplicationEvent;

//Spring事件
public class SomeObject extends ApplicationEvent{

	/**
	 * Spring事件
	 */
	private static final long serialVersionUID = 1L;
	
	public SomeObject(Object obj) {
		super(obj);
	}

}
