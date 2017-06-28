package cn.cyansoft.makeappo.controller;

import java.util.List;

import cn.cyansoft.makeappo.model.AppoSource;

import com.jfinal.core.Controller;

public class Appo_SourceController extends Controller {
	public void add(){


		int docId=getParaToInt("docId");
		int total=getParaToInt("total");
		String time=getPara("time");
		
		new AppoSource()
			.set("docId",docId)
			.set("total", total)
			.set("remain", total)
			.set("time", time)
			.save();

		renderJson("1");
	}

	public void delete(){
		int id=getParaToInt("id");
		AppoSource appoSource=AppoSource.dao.find("select * from appo_source where id="+id).get(0);
		appoSource.delete();
		renderJson("1");
	}

	public void get(){
		int id=getParaToInt(0);
		AppoSource appoSource=AppoSource.dao.find("select * from appo_source where id="+id).get(0);
		renderJson(appoSource);
	}

	public void update(){
		int id=getParaToInt("id");
		int docId=getParaToInt("docId");
		int total=getParaToInt("total");
		int remain=getParaToInt("remain");
		String time=getPara("time");
		AppoSource appoSource=AppoSource.dao.find("select * from appo_source where id="+id).get(0);
		appoSource.setDocId(docId);
		appoSource.setTotal(total);
		appoSource.setRemain(remain);
		appoSource.setTime(time);
		renderJson("1");
	}

	public void decrease(){
		int docId=getParaToInt("docId");
		String time=getPara("time");
		AppoSource appoSource=AppoSource.dao.find("select * from appo_source where docId="+docId+" and time like '%"+time+"%'").get(0);
		if(appoSource!=null){
			appoSource.setRemain(appoSource.getRemain()-1);
			//renderJson(appoSource);
		}
	}
	
	public void all(){

		List<AppoSource> appoSources=AppoSource.dao.find("select * from appo_registration");
		renderJson(appoSources);
	}

}
