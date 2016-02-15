package com.jurin_n.junit.date_test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Enclosed.class)
public class GreetTest2 {
	
	@RunWith(Theories.class)
	public static class 朝05時以上_12時未満_の場合{

		@DataPoints
		public static SystemCalendar CALENDAR[];

		@BeforeClass
		public static void setUpSystemCalendar() {
			SystemCalendar sysCal1 = mock(SystemCalendar.class);
			SystemCalendar sysCal2 = mock(SystemCalendar.class);
			when(sysCal1.getHour()).thenReturn(5);
			when(sysCal2.getHour()).thenReturn(11);
			
			CALENDAR = new SystemCalendar[]{
							 sysCal1
							,sysCal2
						};
		}

		//朝(05:00:00以上 12:00:00未満)の場合、「おはようございます」と返す
		@Theory
		public void 朝05時以上_12時未満_の場合_おはようございます_と返す(SystemCalendar sysCal) {
			Greeter2 sut = new Greeter2();
			sut.setSystemCalendar(sysCal);
			
			assertThat(sut.toString(), sut.greet(), is("おはようございます"));
		}
	};
	
	@RunWith(Theories.class)
	public static class 昼12時以上_18時未満_の場合{

		@DataPoints
		public static SystemCalendar CALENDAR[];

		@BeforeClass
		public static void setUpSystemCalendar() {
			SystemCalendar sysCal1 = mock(SystemCalendar.class);
			SystemCalendar sysCal2 = mock(SystemCalendar.class);
			when(sysCal1.getHour()).thenReturn(12);
			when(sysCal2.getHour()).thenReturn(17);
			
			CALENDAR = new SystemCalendar[]{
							 sysCal1
							,sysCal2
						};
		}
	
		//昼(12:00:00以上 18:00:00未満)の場合、「こんにちは」と返す
		@Theory
		public void 昼12時以上_18時未満_の場合_こんにちは_と返す(SystemCalendar sysCal) {
			Greeter2 sut = new Greeter2();
			sut.setSystemCalendar(sysCal);
			
			assertThat(sut.greet(), is("こんにちは"));
		}
	};
	
	@RunWith(Theories.class)
	public static class 夜18時以上_05時未満_の場合{
		@DataPoints
		public static SystemCalendar CALENDAR[];

		@BeforeClass
		public static void setUpSystemCalendar() {
			SystemCalendar sysCal1 = mock(SystemCalendar.class);
			SystemCalendar sysCal2 = mock(SystemCalendar.class);
			SystemCalendar sysCal3 = mock(SystemCalendar.class);
			SystemCalendar sysCal4 = mock(SystemCalendar.class);

			
			when(sysCal1.getHour()).thenReturn(18);
			when(sysCal2.getHour()).thenReturn(0);
			when(sysCal3.getHour()).thenReturn(1);
			when(sysCal4.getHour()).thenReturn(4);
			
			CALENDAR = new SystemCalendar[]{
							 sysCal1
							,sysCal2
							,sysCal3
							,sysCal4
						};
		}
		
		//夜(18:00:00以上 05:00:00未満)の場合、「こんばんは」と返す/
		@Theory
		public void 夜18時以上_05時未満_の場合_こんばんは_と返す(SystemCalendar sysCal) {
			Greeter2 sut = new Greeter2();
			sut.setSystemCalendar(sysCal);

			assertThat(sut.greet(), is("こんばんは"));
		}
	};
}