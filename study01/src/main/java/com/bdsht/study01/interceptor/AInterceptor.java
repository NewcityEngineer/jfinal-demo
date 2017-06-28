package com.bdsht.study01.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class AInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		System.out.println("-----------AInterceptor--------------");
		inv.invoke();
	}

}
