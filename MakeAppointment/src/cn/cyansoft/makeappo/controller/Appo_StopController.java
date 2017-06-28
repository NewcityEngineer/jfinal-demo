package cn.cyansoft.makeappo.controller;

import java.util.List;




import cn.cyansoft.makeappo.model.AppoStop;
import cn.cyansoft.makeappo.util.TimeTran;

import com.jfinal.core.Controller;

public class Appo_StopController extends Controller{
	private TimeTran timeTran;
	public void add(){


		int docId=getParaToInt("docId");
		String stopDaynum=getPara("stopDaynum");
		
		new AppoStop()
			.set("docId",docId)
			.set("stopTime", stopDaynum)
			.set("stopDaynum", timeTran.getCurrentDate("yyyy-MM-dd"))
			.save();

		renderJson("1");
	}

	public void delete(){
		int id=getParaToInt("id");
		AppoStop appoStop=AppoStop.dao.find("select * from appo_stop where id="+id).get(0);
		appoStop.delete();
		renderJson("1");
	}

	public void get(){
		int id=getParaToInt(0);
		AppoStop appoStop=AppoStop.dao.find("select * from appo_stop where id="+id).get(0);
		renderJson(appoStop);
	}

	public void update(){
		int id=getParaToInt("id");
		int docId=getParaToInt("docId");
		String stopDaynum=getPara("stopDaynum");
		AppoStop appoStop=AppoStop.dao.find("select * from appo_stop where id="+id).get(0);
		appoStop.setDocId(docId);
		appoStop.setStopDaynum(stopDaynum);
		appoStop.update();
		renderJson("1");
	}

	
	
	public void all(){

		List<AppoStop> appoStop=AppoStop.dao.find("select * from appo_stop");
		renderJson(appoStop);
	}
	
}
