package com.bdsht.study01.routes;

import com.bdsht.study01.interceptor.AdminInterceptor;
import com.bdsht.stydy01.controller.AdminController;
import com.jfinal.config.Routes;

public class AdminRoute extends Routes {

	@Override
	public void config() {
		setBaseViewPath("/WEB-INF");
		addInterceptor(new AdminInterceptor());
		add("/admin",AdminController.class);
	}



}
