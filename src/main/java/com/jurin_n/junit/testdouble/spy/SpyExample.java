package com.jurin_n.junit.testdouble.spy;

import java.util.logging.Logger;

public class SpyExample {
	Logger logger = Logger.getLogger(SpyExample.class.getName());
	
	public void doSomething(){
		logger.info("doSomething ログログ");
	}
}
