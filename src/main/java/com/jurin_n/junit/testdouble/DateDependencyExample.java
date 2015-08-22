package com.jurin_n.junit.testdouble;

import java.util.Date;

public class DateDependencyExample {
	Date date = null;
	
	public void doSomething(){
		this.date = new Date();
		for(int i= 0; i<100000;i++){
			String test = "aaa" + "bbbb" + 1 + 2 + 3;
		}
	}
}
