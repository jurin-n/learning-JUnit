package com.jurin_n.junit.testdouble;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

public class DelegateObjectExampleTest {

	@Test
	public void test() {
		final Date current = new Date();
		DelegateObjectExample sut = new DelegateObjectExample();
		sut.dateFactory = new DateFactory(){
			@Override
			public Date newDate() {
				return current;
			}
		};
		sut.doSomething();
		assertThat(sut.date, is(sameInstance(current)));
	}

}
