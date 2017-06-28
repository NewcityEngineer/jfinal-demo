package cn.cyansoft.makeappo.controller;

import java.util.List;





import cn.cyansoft.makeappo.model.AppoAppointment;
import cn.cyansoft.makeappo.model.AppoSource;
import cn.cyansoft.makeappo.util.TimeTran;

import com.jfinal.core.Controller;

public class Appo_AppointmentController extends Controller {
	private TimeTran timeTran;
	private AppoSource appoSource;
	
	public void add(){

		int docId=getParaToInt("docId");
		String time=getPara("time");

		List<AppoSource> appoSources=AppoSource.dao.find("select * from appo_source where docId="+docId+" and time='"+time+"'");
		if(appoSources.size()==0){
//			new AppoSource().set("", value)
		}
		
		
		int userId=getParaToInt("userId");
		int deptId=getParaToInt("deptId");
		String remark=getPara("remark");
		String describe=getPara("describe");
		String money=getPara("money");
		String payway=getPara("payway");
		new AppoAppointment()
			.set("userId",userId)
			.set("deptId", deptId)
			.set("docId", docId)
			.set("remark", remark)
			.set("describe", describe)
			.set("money", money)
			.set("payway", payway)
			.set("state", "预约成功")
			.set("time", time)
			.save();

		renderJson("1");
	}

	public void delete(){
		int id=getParaToInt("id");
		AppoAppointment appoAppointment=AppoAppointment.dao.find("select * from appo_appointment where id="+id).get(0);
		appoAppointment.delete();
		renderJson("1");
	}

	public void get(){
		int id=getParaToInt(0);
		AppoAppointment appoAppointment=AppoAppointment.dao.find("select * from appo_appointment where id="+id).get(0);
		renderJson(appoAppointment);
	}

	public void update(){
		int id=getParaToInt("id");
		String state=getPara("state");
		AppoAppointment appoAppointment=AppoAppointment.dao.find("select * from appo_appointment where id="+id).get(0);
		appoAppointment.setState(state);
		appoAppointment.update();
		renderJson("1");
	}

	public void all(){

		List<AppoAppointment> appointments=AppoAppointment.dao.find("select * from appo_appointment");
		renderJson(appointments);
	}

	
}
