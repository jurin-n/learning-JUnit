package com.jurin_n.junit.date_test;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MachineDateTime implements DateTime {

	private Calendar cal = Calendar.getInstance(
								 TimeZone.getTimeZone("Asia/Tokyo")
								,Locale.JAPAN);
	
	Date newDate(){
		return new Date();
	}
	
	@Override
	public int getHour() {
		cal.setTime(newDate());
		return cal.get(Calendar.HOUR_OF_DAY);
	}
}
