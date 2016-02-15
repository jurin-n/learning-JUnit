package com.jurin_n.junit.date_test;

public class Greeter2 {
	public SystemCalendar sysCal = new DefaultSystemCalendar();
	
	public String greet() {
		int hour = sysCal.getHour();
		if(hour>=5 && hour<12){
			return "おはようございます";
		}else if(hour>=12 && hour<18){
			return "こんにちは";
		}
		return "こんばんは";
	}

	public void setSystemCalendar(SystemCalendar sysCal) {
		this.sysCal = sysCal;
	}
}
