/**
 * Copyright (c) 2015-2016, Javen Zhou  (javenlife@126.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package cn.cyansoft.makeappo.common;

import cn.cyansoft.makeappo.controller.Appo_AppointmentController;
import cn.cyansoft.makeappo.controller.Appo_AdminController;
import cn.cyansoft.makeappo.controller.Appo_DeptController;
import cn.cyansoft.makeappo.controller.Appo_DoctorController;
import cn.cyansoft.makeappo.controller.Appo_RegistrationController;
import cn.cyansoft.makeappo.controller.Appo_SourceController;
import cn.cyansoft.makeappo.controller.Appo_StopController;
import cn.cyansoft.makeappo.controller.Appo_UserController;
import cn.cyansoft.makeappo.controller.IndexController;
import cn.cyansoft.makeappo.controller.WeixinApiController;
import cn.cyansoft.makeappo.controller.WeixinMsgController;
import cn.cyansoft.makeappo.model._MappingKit;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.usercontroller.UserController;
import com.jfinal.weixin.weboauth2.RedirectUri;

/**
 * @author Javen 2016年1月15日
 */
public class WeixinConfig extends JFinalConfig {

	/**
	 * 如果生产环境配置文件存在，则优先加载该配置，否则加载开发环境配置文件
	 * 
	 * @param pro
	 *            生产环境配置文件
	 * @param dev
	 *            开发环境配置文件
	 */
	public void loadProp(String pro, String dev) {
		try {
			PropKit.use(pro);
		} catch (Exception e) {
			PropKit.use(dev);
		}
	}

	public void configConstant(Constants me) {
		PropKit.use("config.txt");
		me.setDevMode(PropKit.getBoolean("devMode", false));
		me.setEncoding("utf-8");
		//		me.setViewType(ViewType.JSP);
		//		me.setViewType(viewType);
		// ApiConfigKit 设为开发模式可以在开发阶段输出请求交互的 xml 与 json 数据
		ApiConfigKit.setDevMode(me.getDevMode());

		//me.setUrlParaSeparator(",");
		
		//me.setBaseViewPath("/WEB-INF");
	}

	public void configRoute(Routes me) {
		me.add("/msg", WeixinMsgController.class);
		
		me.add("/api", WeixinApiController.class, "/api");
		//me.add("/pay", WeixinPayController.class, "/pay");
		me.add("/", IndexController.class, "/index");
		me.add("/oauth2", RedirectUri.class);
		me.add("/user", UserController.class);
		me.add("/appo_admin",Appo_AdminController.class);
		me.add("/appo_appointment",Appo_AppointmentController.class);
		me.add("/appo_dept",Appo_DeptController.class);
		me.add("/appo_doctor",Appo_DoctorController.class);
		me.add("/appo_registration",Appo_RegistrationController.class);
		me.add("/appo_source",Appo_SourceController.class);
		me.add("/appo_stop",Appo_StopController.class);
		me.add("/appo_user",Appo_UserController.class);
		

		
	}

	public void configPlugin(Plugins me) {
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"),
				PropKit.get("password").trim());
		me.add(c3p0Plugin);

		EhCachePlugin ecp = new EhCachePlugin();
		me.add(ecp);

		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		_MappingKit.mapping(arp);
		me.add(arp);

		
		//me.add(new Cron4jPlugin(PropKit.use("task.properties")));
		
		//        System.out.println(2);
		// RedisPlugin redisPlugin = new RedisPlugin("weixin", "127.0.0.1");
		// me.add(redisPlugin);
	}

	public void configInterceptor(Interceptors me) {

		
		
	}

	public void configHandler(Handlers me) {

	}

	public void afterJFinalStart() {
		// 1.5 之后支持redis存储access_token、js_ticket，需要先启动RedisPlugin
		// ApiConfigKit.setAccessTokenCache(new RedisAccessTokenCache());
		// 1.6新增的2种初始化
		// ApiConfigKit.setAccessTokenCache(new
		// RedisAccessTokenCache(Redis.use("weixin")));
		// ApiConfigKit.setAccessTokenCache(new
		// RedisAccessTokenCache("weixin"));
	}
}
