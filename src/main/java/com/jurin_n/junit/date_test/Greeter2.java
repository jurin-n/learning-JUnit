package com.jurin_n.junit.date_test;

public class Greeter2 {
	public DateTime dateTime = new MachineDateTime();
	
	public String greet() {
		int hour = dateTime.getHour();
		if(hour>=5 && hour<12){
			return "おはようございます";
		}else if(hour>=12 && hour<18){
			return "こんにちは";
		}
		return "こんばんは";
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
}
