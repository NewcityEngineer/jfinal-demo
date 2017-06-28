package com.bdsht.stydy01.controller;

import com.jfinal.core.Controller;

public class HelloController extends Controller {

	public void index(){
		
		setAttr("msg", "Hello,JFinal3.0");
		renderTemplate("index.html");
	}
	
}
