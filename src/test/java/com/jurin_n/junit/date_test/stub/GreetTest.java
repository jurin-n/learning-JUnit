package com.jurin_n.junit.date_test.stub;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Enclosed.class)
public class GreetTest {
	
	public static class 朝05時以上_12時未満_の場合{

		@BeforeClass
		public static void setUpCalendar() {
		}

		//朝(05:00:00以上 12:00:00未満)の場合、「おはようございます」と返す
		@Test
		@Ignore("うまく時間をコントロールできずorz")
		public void 朝05時以上_12時未満_の場合_おはようございます_と返す() {
			Greeter sut = new Greeter();
			assertThat(sut.greet(), is("おはようございます"));
		}
	};

	public static class 昼12時以上_18時未満_の場合{
		@BeforeClass
		public static void setUpCalendar() {
		}
		
		//昼(12:00:00以上 18:00:00未満)の場合、「こんにちは」と返す
		@Test
		@Ignore("うまく時間をコントロールできずorz")
		public void 昼12時以上_18時未満_の場合_こんにちは_と返す() {
			Greeter sut = new Greeter();
			assertThat(sut.greet(), is("こんにちは"));
		}
	};
	
	public static class 夜18時以上_05時未満_の場合{
		@BeforeClass
		public static void setUpCalendar() {
		}
		
		//夜(18:00:00以上 05:00:00未満)の場合、「こんばんは」と返す/
		@Test
		@Ignore("うまく時間をコントロールできずorz")
		public void 夜18時以上_05時未満_の場合_こんばんは_と返す() {
			Greeter sut = new Greeter();
			assertThat(sut.greet(), is("こんばんは"));
		}
	};
}