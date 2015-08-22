package com.jurin_n.junit.testdouble;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

import com.jurin_n.junit.testdouble.DateDependencyExample;

public class DateDependencyExampleTest {

	@Test
	public void test() {
		DateDependencyExample sut = new DateDependencyExample();
		sut.doSomething();
		assertThat(sut.date, is(new Date()));
	}

}
