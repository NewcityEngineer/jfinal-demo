package com.bdsht.study01.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class MethodInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		System.out.println("-----------MethodInterceptor--------------");
		inv.invoke();
	}

}
