package com.bdsht.study01.routes;

import com.bdsht.study01.interceptor.FrontInterceptor;
import com.bdsht.stydy01.controller.IndexController;
import com.jfinal.config.Routes;

public class FrontRoute extends Routes {

	@Override
	public void config() {
		setBaseViewPath("/front");
		addInterceptor(new FrontInterceptor());
		add("/",IndexController.class);
	}

}
