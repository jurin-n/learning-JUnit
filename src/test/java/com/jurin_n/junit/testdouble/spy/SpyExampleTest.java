package com.jurin_n.junit.testdouble.spy;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

public class SpyExampleTest {

	@Test
	public void SpyLoggerでログ出力テスト() {
		SpyExample sut = new SpyExample();
		SpyLogger spy = new SpyLogger(sut.logger);
		sut.logger = spy;
		sut.doSomething();
		
		assertThat(spy.log.toString(), is("doSomething ログログ"));
	}

}
