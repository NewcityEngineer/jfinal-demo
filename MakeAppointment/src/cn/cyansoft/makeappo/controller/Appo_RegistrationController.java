package cn.cyansoft.makeappo.controller;

import java.util.List;

import cn.cyansoft.makeappo.model.AppoRegistration;
import cn.cyansoft.makeappo.util.TimeTran;

import com.jfinal.core.Controller;

public class Appo_RegistrationController extends Controller {
	private TimeTran timeTran;
	public void add(){


		int appointmentId=getParaToInt("appointmentId");
		int money=getParaToInt("money");
		String payway=getPara("payway");
		String diagnosis=getPara("diagnosis");
		
		
		new AppoRegistration()
			.set("appointmentId",appointmentId)
			.set("money", money)
			.set("payway", payway)
			.set("diagnosis", diagnosis)
			.set("time", timeTran.getCurrentDate("yyyy-MM-dd HH:mm:ss"))
			.save();

		renderJson("1");
	}

	public void delete(){
		int id=getParaToInt("id");
		AppoRegistration appoRegistration=AppoRegistration.dao.find("select * from appo_registration where id="+id).get(0);
		appoRegistration.delete();
		renderJson("1");
	}

	public void get(){
		int id=getParaToInt(0);
		AppoRegistration appoRegistration=AppoRegistration.dao.find("select * from appo_registration where id="+id).get(0);
		renderJson(appoRegistration);
	}

	public void update(){
		int id=getParaToInt("id");
		int appointmentId=getParaToInt("appointmentId");
		int money=getParaToInt("money");
		String payway=getPara("payway");
		String diagnosis=getPara("diagnosis");
		AppoRegistration appoRegistration=AppoRegistration.dao.find("select * from appo_registration where id="+id).get(0);
		appoRegistration.setAppointmentId(appointmentId);
		appoRegistration.setMoney(money);
		appoRegistration.setPayway(payway);
		appoRegistration.setDiagnosis(diagnosis);
		appoRegistration.update();
		
		
		renderJson("1");
	}

	public void all(){

		List<AppoRegistration> appoRegistrations=AppoRegistration.dao.find("select * from appo_registration");
		
		renderJson(appoRegistrations);
	}


	
}
