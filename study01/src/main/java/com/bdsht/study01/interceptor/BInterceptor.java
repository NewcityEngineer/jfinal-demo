package com.bdsht.study01.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class BInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		System.out.println("-----------BInterceptor--------------");
		inv.invoke();
	}

}
