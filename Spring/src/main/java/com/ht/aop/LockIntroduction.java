package com.ht.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopConfigException;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class LockIntroduction extends DelegatingIntroductionInterceptor
		implements ILockable {
	private boolean lock;

	public boolean isLook() {
		return lock;
	}

	public void lock() {
		lock = true;
	}

	public void unlock() {
		lock = false;
	}

	public Object invoke(MethodInvocation invocation) throws Throwable {
		// locked 为true下不能呼叫set方法
		if (isLook() && invocation.getMethod().getName().indexOf("set") == 0) {
			throw new AopConfigException("物件被锁定！！");
		}
		return super.invoke(invocation);
	}

}
