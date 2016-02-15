package com.jurin_n.junit.date_test;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DefaultSystemCalendar implements SystemCalendar {

	private Calendar cal = Calendar.getInstance(
								 TimeZone.getTimeZone("Asia/Tokyo")
								,Locale.JAPAN);

	@Override
	public int getHour() {
		setCurrentTime(cal);
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	private void setCurrentTime(Calendar cal){
		cal.setTime(new Date());
	}
}
