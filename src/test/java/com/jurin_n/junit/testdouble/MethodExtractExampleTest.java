package com.jurin_n.junit.testdouble;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

public class MethodExtractExampleTest {

	@Test
	public void test() {
		final Date current = new Date();
		MethodExtractExample sut = new MethodExtractExample(){
				@Override
				Date newDate(){
					return current;
				}
		};
		
		sut.doSomething();
		assertThat(sut.date,is(sameInstance(current)));
	}

}
