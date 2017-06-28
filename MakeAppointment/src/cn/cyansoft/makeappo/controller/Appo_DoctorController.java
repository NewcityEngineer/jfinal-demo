package cn.cyansoft.makeappo.controller;

import java.util.List;

import cn.cyansoft.makeappo.model.AppoDoctor;

import com.jfinal.core.Controller;

public class Appo_DoctorController extends Controller {

	//private TimeTran timeTran;
	public void add(){


		int deptId=getParaToInt("deptId");
		String name=getPara("name");
		String education=getPara("education");
		String title=getPara("title");
		
		
		new AppoDoctor()
			.set("deptId",deptId)
			.set("name", name)
			.set("education", education)
			.set("title", title)
			.save();

		renderJson("1");
	}

	public void delete(){
		int id=getParaToInt("id");
		AppoDoctor appoDoctor=AppoDoctor.dao.find("select * from appo_doctor where id="+id).get(0);
		appoDoctor.delete();
		renderJson("1");
	}

	public void get(){
		int id=getParaToInt(0);
		AppoDoctor appoDoctor=AppoDoctor.dao.find("select * from appo_doctor where id="+id).get(0);
		renderJson(appoDoctor);
	}

	public void update(){
		int id=getParaToInt("id");
		int deptId=getParaToInt("deptId");
		String name=getPara("name");
		String education=getPara("education");
		String title=getPara("title");
		AppoDoctor appoDoctor=AppoDoctor.dao.find("select * from appo_doctor where id="+id).get(0);
		appoDoctor.setDeptId(deptId);
		appoDoctor.setName(name);
		appoDoctor.setEducation(education);
		appoDoctor.setTitle(title);
		appoDoctor.update();
		
		
		renderJson("1");
	}

	public void all(){

		List<AppoDoctor> appoDoctors=AppoDoctor.dao.find("select * from appo_doctor");
		
		renderJson(appoDoctors);
	}
	
}
