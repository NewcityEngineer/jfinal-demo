package cn.cyansoft.makeappo.controller;

import java.util.List;



import cn.cyansoft.makeappo.model.AppoUser;

import com.jfinal.core.Controller;

public class Appo_UserController extends Controller {
	public void add(){


		String name=getPara("name");
		String userName=getPara("userName");
		String userPwd=getPara("userPwd");
		int age=getParaToInt("age");
		String telephone=getPara("telephone");
		String sex=getPara("sex");
		String describe=getPara("describe");

		AppoUser appoUser=new AppoUser();
		appoUser.set("name",name);
		appoUser.set("userName", userName);
		appoUser.set("age", age);
		appoUser.set("userPwd", userPwd);
		appoUser.set("telephone", telephone);
		appoUser.set("sex", sex);
		appoUser.set("describe", describe);
		appoUser.save();

		renderJson(appoUser);
	}

	public void delete(){
		int id=getParaToInt("id");
		AppoUser appoUser=AppoUser.dao.find("select * from appo_user where id="+id).get(0);
		appoUser.delete();
		renderJson("1");
	}

	public void get(){
		int id=getParaToInt(0);
		AppoUser appoUser=AppoUser.dao.find("select * from appo_user where id="+id).get(0);
		renderJson(appoUser);
	}

	public void update(){
		int id=getParaToInt("id");
		String name=getPara("name");
		String userName=getPara("userName");
		String userPwd=getPara("userPwd");
		int age=getParaToInt("age");
		String telephone=getPara("telephone");
		String sex=getPara("sex");
		String describe=getPara("describe");
		AppoUser appoUser=AppoUser.dao.find("select * from appo_user where id="+id).get(0);
		appoUser.setName(name);
		appoUser.setUserName(userName);
		appoUser.setUserPwd(userPwd);
		appoUser.setAge(age);
		appoUser.setTelephone(telephone);
		appoUser.setSex(sex);
		appoUser.setDescribe(describe);
		renderJson("1");
	}



	public void all(){

		List<AppoUser> appoUser=AppoUser.dao.find("select * from appo_user");
		renderJson(appoUser);
	}
}
