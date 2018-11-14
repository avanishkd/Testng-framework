package com.mindtree.util;
import java. sql. Timestamp;
import java. util. Date;


public class TimeStamp {
	
	public static String getTimeStamp() {
		Date date= new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		String stamp = ts.toString().replace(" ","_").replace(":", "-");
		return stamp;
	}

}
