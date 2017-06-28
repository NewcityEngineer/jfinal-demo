package cn.cyansoft.makeappo.controller;

import java.util.List;

import cn.cyansoft.makeappo.interfaces.DataOpeInterface;
import cn.cyansoft.makeappo.model.AppoDept;

import com.jfinal.core.Controller;

public class Appo_DeptController extends Controller implements DataOpeInterface{

	@Override
	public void add() {

		String style=getPara("style");
		String name=getPara("name");
		String information=getPara("information");
		int flag=getParaToInt("flag");
		if(information==null){
			information="";
		}
		new AppoDept().set("style", style).set("name", name)
		.set("information", information).set("flag", flag).save();
		
	}

	@Override
	public void get() {
		int id=getParaToInt(0);
		AppoDept appoDept=AppoDept.dao.find("select * from appo_dept where id="+id).get(0);
		renderJson(appoDept);
	}

	@Override
	public void delete() {
		int id=getParaToInt("id");
		AppoDept appoDept=AppoDept.dao.find("select * from appo_dept where id="+id).get(0);
		appoDept.delete();
		renderJson("1");
	}

	@Override
	public void update() {
		int id=getParaToInt("id");
		String style=getPara("style");
		String name=getPara("name");
		String information=getPara("information");
		int flag=getParaToInt("flag");
		AppoDept appoDept=AppoDept.dao.find("select * from appo_dept where id="+id).get(0);
		appoDept.setStyle(style);
		appoDept.setName(name);
		appoDept.setInformation(information);
		appoDept.setFlag(flag);
		appoDept.update();
		renderJson("1");
	}

	@Override
	public void all() {
		List<AppoDept> appoDepts=AppoDept.dao.find("select * from appo_dept");
	
		renderJson(appoDepts);
	}
	
	
}
