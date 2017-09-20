package com.ht.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

public class OtherIntroduction implements IntroductionInterceptor,IOther{

	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if(implementsInterface(
                methodInvocation.getMethod().getDeclaringClass())) {
                // 呼叫执行额外加入（mixin）的行为
                return methodInvocation.getMethod(). invoke(this, 
    		methodInvocation.getArguments());
            }
            else {  // 呼叫执行原目标对象行为
                return methodInvocation.proceed();
            }
	}
	public boolean implementsInterface(Class clazz) {
		return clazz.isAssignableFrom(IOther.class);
	}

	public void doOther() {
		System.out.println("额外的职责");
	}

}
