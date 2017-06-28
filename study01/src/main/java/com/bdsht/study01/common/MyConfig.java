package com.bdsht.study01.common;

import com.bdsht.study01.interceptor.GlobalInterceptor;
import com.bdsht.study01.interceptor.InjectInterceptor;
import com.bdsht.study01.model._MappingKit;
import com.bdsht.study01.routes.AdminRoute;
import com.bdsht.study01.routes.FrontRoute;
import com.bdsht.study01.service.ShareMethod;
import com.bdsht.study01.service.ShareObject;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.template.Engine;

public class MyConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		
		PropKit.use("a_little_config.txt");
		
		me.setDevMode(PropKit.getBoolean("devMode", false));
	}

	@Override
	public void configRoute(Routes me) {
		me.add(new FrontRoute());
		me.add(new AdminRoute());
	}
	
	@Override
	public void configEngine(Engine me) {
		me.setBaseTemplatePath(PathKit.getWebRootPath());
		me.addSharedFunction("/front/common.html");
		me.addSharedStaticMethod(ShareObject.class);
//		me.addSharedMethod(new ShareMethod());
		me.addSharedObject("sm", new ShareMethod());
	}

	@Override
	public void configPlugin(Plugins me) {
		C3p0Plugin c3p0Plugin=new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user").trim(), PropKit.get("password").trim());
		me.add(c3p0Plugin);
		
	
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.setBaseSqlTemplatePath(PathKit.getWebRootPath()+"/WEB-INF");
		arp.setShowSql(true);
		arp.addSqlTemplate("/sql/demo.sql");
		
		_MappingKit.mapping(arp);
		
		Cron4jPlugin cron4j=new Cron4jPlugin(PropKit.use("cron4j.properties"), "cron4j");
		me.add(cron4j);
		
		
		EhCachePlugin ehCachePlugin=new EhCachePlugin();
		me.add(ehCachePlugin);
		
//		Cron4jPlugin cron4jPlugin=new Cron4jPlugin();
//		cron4jPlugin.addTask("* * * * *", new Task());
//		me.add(cron4jPlugin);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		me.addGlobalActionInterceptor(new GlobalInterceptor());
		me.addGlobalServiceInterceptor(new InjectInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {

	}
	
	public static void main(String[] args) {
		JFinal.start("src/main/webapp",8080,"/",5);
	}

}
