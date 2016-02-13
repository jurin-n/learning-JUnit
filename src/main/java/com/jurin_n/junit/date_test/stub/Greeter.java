package com.jurin_n.junit.date_test.stub;

import java.util.Calendar;

public class Greeter {
	public String greet() {
		Calendar now = Calendar.getInstance();
		int hour = now.get(Calendar.HOUR_OF_DAY);
		if(hour>=5 && hour<12){
			return "おはようございます";
		}else if(hour>=12 && hour<18){
			return "こんにちは";
		}
		return "こんばんは";
	}
}
