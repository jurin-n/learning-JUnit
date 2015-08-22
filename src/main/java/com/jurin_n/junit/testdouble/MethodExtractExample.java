package com.jurin_n.junit.testdouble;

import java.util.Date;

public class MethodExtractExample {
	Date date = null;
	
	public void doSomething(){
		for(int i= 0; i<200000;i++){
			String test = "aaa" + "bbbb" + 1 + 2 + 3;
			System.out.println("["+i+"]test=" + test);
		}
		date = newDate();
	}

	Date newDate() {
		return new Date();
	}
}
