package com.bdsht.study01.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class ClassInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		System.out.println("-----------ClassInterceptor--------------");
		inv.invoke();
	}

}
