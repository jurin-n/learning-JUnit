package com.jurin_n.junit;

import static org.junit.Assert.*;

import org.junit.Before;

import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class MoneyTest {
	private Money m12CHF;
	private Money m14CHF;
	
	@Before
	public void setUp(){
		m12CHF = new Money(12,"CHF");
		m14CHF = new Money(14,"CHF");
	}
	
	@Test
	public void testSimpleAdd() {
		Money expected = new Money(26,"CHF");
		Money result = m12CHF.add(m14CHF);
		assertThat(result ,is(expected));
	}
	
	@Test
	public void testEquals(){
		assertThat(m12CHF.equals(null),is(false));
		assertThat(m12CHF,is(m12CHF));
		assertThat(m12CHF, is(new Money(12,"CHF")));
		assertThat(m12CHF.equals(m14CHF),is(false));
	}
}
