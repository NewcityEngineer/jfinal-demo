package com.bdsht.study01.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class AdminInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		System.out.println("-----------AdminInterceptor--------------");
		inv.invoke();
	}

}
