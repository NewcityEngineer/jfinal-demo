package com.bdsht.stydy01.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bdsht.study01.interceptor.AInterceptor;
import com.bdsht.study01.interceptor.AdminInterceptor;
import com.bdsht.study01.interceptor.BInterceptor;
import com.bdsht.study01.interceptor.ClassInterceptor;
import com.bdsht.study01.interceptor.MethodInterceptor;
import com.bdsht.study01.model.TBlog;
import com.bdsht.study01.service.ServicerImpl;
import com.jfinal.aop.Before;
import com.jfinal.aop.Duang;
import com.jfinal.aop.Enhancer;
import com.jfinal.core.Controller;
@Before(ClassInterceptor.class)
public class IndexController extends Controller {

	public void index(){
		String msg=getPara("msg", "defaultValue");
		setAttr("msg", "AdminRoute---AdminController---index():"+msg);
		getModel(TBlog.class);
		
		
		renderTemplate("index.html");
		
	}
	@Before(MethodInterceptor.class)
	public void testMethod(){
		String msg=getPara("msg", "defaultValue");
		setAttr("msg", "AdminRoute---AdminController---index():"+msg);
		getModel(TBlog.class);
		
		
		renderTemplate("index.html");
	}
	
	public void testInject(){
		System.out.println("--------------第一种方法----------------");
		ServicerImpl servicerImpl=Duang.duang(ServicerImpl.class);
		servicerImpl.add();
		servicerImpl.update();
		System.out.println("--------------第二种方法----------------");
		ServicerImpl servicerImp2=Enhancer.enhance(ServicerImpl.class,AdminInterceptor.class);
		servicerImp2.add();
		servicerImp2.update();
		renderTemplate("index.html");
	}
	
	@Before({AInterceptor.class,BInterceptor.class})
	public void testInterceptorStack(){
		renderTemplate("index.html");
	}
	
	public void sqlManager(){
		String sql=TBlog.dao.getSql("blog.list");
		sql=TBlog.dao.getSql("blog.findOne");
		sql=TBlog.dao.getSql("blog.between");
		
//		Map<String,Integer> map=new HashMap<String,Integer>();
//		map.put("min_1", 2);
//		map.put("max_1",7);
//		JMap jMap=JMap.create().putAll(map);
//		JMap cond	=new JMap().create().set("min_1", 2).set("max_1", 7);
//		SqlPara sqlPara=getSqlPara("blog.between_new",cond);
		
		renderJson(TBlog.dao.find(sql,2,7));
		
	}
	
	
	public void template_test(){
		setAttr("value", "hello");
		Map<String,Object> user=new HashMap<String,Object>();
		user.put("name", "LiXin Tian");
		user.put("age", 25);
		setAttr("user", user);
		
		setAttr("a", 8);
		setAttr("b", 5);
		
		List<String> names=new ArrayList<String>();
		names.add("Bob");
		names.add("Alice");
		names.add("Ben");
		
		setAttr("names", names);
		
	}
	
	
	
}
