package com.jurin_n.junit.testdouble;

import java.util.Date;

public class DelegateObjectExample {
	Date date = null;
	DateFactory dateFactory = new DateFactoryImpl();
	
	public void doSomething(){
		this.date = dateFactory.newDate();
		for(int i= 0; i<100000;i++){
			String test = "aaa" + "bbbb" + 1 + 2 + 3;
		}
	}
}
