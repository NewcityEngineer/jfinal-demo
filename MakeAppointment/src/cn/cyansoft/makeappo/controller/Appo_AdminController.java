package cn.cyansoft.makeappo.controller;

import java.util.List;

import cn.cyansoft.makeappo.model.AppoAdmin;

import com.jfinal.core.Controller;

public class Appo_AdminController extends Controller {

	
	public void add(){
		
		String name=getPara("name");
		String pwd=getPara("pwd");
		String level=getPara("level");
		List<AppoAdmin> appoAdmins=AppoAdmin.dao.find("select * from appo_admin where name='"+name+"' and level='"+level+"'");
		if(appoAdmins.size()==0){
			AppoAdmin appoAdmin=new AppoAdmin();
			appoAdmin.set("name",name).set("pwd", pwd).save();
			
			renderJson(appoAdmin);
		}else{
			renderJson("{\"result\":\"error\",\"key\":\"null\"}");
		}
		
	}
	
	public void getJsonFromObject(Object object){
		renderJson(object);
	}
	
	public void delete(){
		int id=getParaToInt("id");
		AppoAdmin admin=AppoAdmin.dao.find("select * from appo_admin where id="+id).get(0);
		admin.delete();
		renderJson("1");
	}
	
	public void get(){
		int id=getParaToInt(0);
		AppoAdmin admin=AppoAdmin.dao.find("select * from appo_admin where id="+id).get(0);
		renderJson(admin);
	}
	
	public void update(){
		int id=getParaToInt("id");
		String name=getPara("name");
		String pwd=getPara("pwd");
		AppoAdmin admin=AppoAdmin.dao.find("select * from appo_admin where id="+id).get(0);
		admin.setName(name);
		admin.setPwd(pwd);
		admin.update();
		renderJson("1");
	}
	
	public void all(){
		
		List<AppoAdmin> admins=AppoAdmin.dao.find("select * from appo_admin");
//		StringBuffer sb=new StringBuffer();
//		sb.append("[");
//		for (AppoAdmin appoAdmin : admins) {
//			sb.append(returnJsonFromObject(appoAdmin)+",");
//		}
//		String json=sb.toString();
//		if(admins.size()>0)
//			json=json.substring(0, json.length()-1);
//		json=json+"]";

		renderJson(admins);
	}
	
//	private String returnJsonFromObject(AppoAdmin appoAdmin){
//		
//		StringBuffer sb=new StringBuffer();
//		sb.append("{");
//		sb.append("\"id\":"+appoAdmin.getId()+",");
//		sb.append("\"name\":\""+appoAdmin.getName()+"\",");
//		sb.append("\"pwd\":\""+appoAdmin.getPwd()+"\"}");
//		
//		
//		
//		return sb.toString();
//		
//	}
	
}
