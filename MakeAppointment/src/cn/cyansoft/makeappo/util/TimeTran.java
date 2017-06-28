package cn.cyansoft.makeappo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTran {
	public String getCurrentDate(String format){

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date now = new Date();
		String dt = sdf.format(now);


		return dt;
	}
}
