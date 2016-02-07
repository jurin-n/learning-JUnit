package com.jurin_n.junit.testdouble;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

import java.util.Calendar;

import org.junit.Test;

public class MonthlyCalendarTest {

	@Test
	public void 現在時刻が20120131の場合_getRemainginDaysは0を返す() {
		MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012,1,31));

		assertThat(sut.getRemainginDays(),is(0));
	}
	
	@Test
	public void 現在時刻が20120130の場合_getRemainginDaysは1を返す() {
		MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012,1,30));

		assertThat(sut.getRemainginDays(),is(1));
	}
	
	@Test
	public void 現在時刻が20120201の場合_getRemainginDaysは28を返す() {
		MonthlyCalendar sut = new MonthlyCalendar(newCalendar(2012,2,1));

		assertThat(sut.getRemainginDays(),is(28));
	}
	
	static Calendar newCalendar(int yyyy, int mm, int dd){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, yyyy);
		cal.set(Calendar.MONTH, mm - 1);
		cal.set(Calendar.DATE, dd);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal;
	}
}
