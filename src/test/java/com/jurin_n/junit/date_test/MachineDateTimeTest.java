package com.jurin_n.junit.date_test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;

public class MachineDateTimeTest {
	final Calendar cal = Calendar.getInstance(
			 TimeZone.getTimeZone("Asia/Tokyo")
			,Locale.JAPAN);
	
	@Before
	public void setUp(){
		cal.set(2016, 2, 1, 15, 00);
	}
	
	@Test
	public void 現在時間を取得できる() {
		final Date current = cal.getTime();
		MachineDateTime sut = new MachineDateTime(){
			@Override
			Date newDate(){
				return current;
			}
		};

		assertThat(sut.getHour(), is(15));
	}
}
