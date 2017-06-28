package com.bdsht.stydy01.controller;

import com.bdsht.study01.model.TBlog;
import com.jfinal.core.Controller;

public class AdminController extends Controller {
	public void index(){
		
		String msg=getPara("msg", "defaultValue");
		
		setAttr("msg", "AdminRoute---AdminController---index():"+msg);
		renderTemplate("index.html");
		
	}
	
	public void add(){
		
	}
	
	public void doAdd(){
		TBlog tBlog=getModel(TBlog.class);
		tBlog.save();
		renderHtml("提交成功！");
	}
}
