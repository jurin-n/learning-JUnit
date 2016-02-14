package com.jurin_n.junit.date_test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;

@RunWith(Enclosed.class)
public class GreetTest {
	
	@RunWith(Theories.class)
	public static class 朝05時以上_12時未満_の場合{

		@DataPoints
		public static Calendar CALENDAR[];

		@BeforeClass
		public static void setUpCalendar() {
			CALENDAR = new Calendar[]{
					 newCalendar(
							  Calendar.getInstance(
									   TimeZone.getTimeZone("Asia/Tokyo")
									  ,Locale.JAPAN
									  )
							 ,5,0,0,0)
					,newCalendar(
							  Calendar.getInstance(
									   TimeZone.getTimeZone("Asia/Tokyo")
									  ,Locale.JAPAN
									  )
							,11,59,59,999)
					};
		}

		//朝(05:00:00以上 12:00:00未満)の場合、「おはようございます」と返す
		@Theory
		public void 朝05時以上_12時未満_の場合_おはようございます_と返す(Calendar cal) {
			System.out.println(testDataLoggin(cal));
			assertThat(cal.toString(), Greeter.greet(cal), is("おはようございます"));
		}
	};

	@RunWith(Theories.class)
	public static class 昼12時以上_18時未満_の場合{
		@DataPoints
		public static Calendar CALENDAR[];

		@BeforeClass
		public static void setUpCalendar() {
			CALENDAR = new Calendar[]{
					 newCalendar(
							  Calendar.getInstance(
								   TimeZone.getTimeZone("Asia/Tokyo")
								  ,Locale.JAPAN
								  )
							 ,12,0,0,0)
					,newCalendar(
							  Calendar.getInstance(
									   TimeZone.getTimeZone("Asia/Tokyo")
									  ,Locale.JAPAN
									  )
							,17,59,59,999)
					};
		}
		
		//昼(12:00:00以上 18:00:00未満)の場合、「こんにちは」と返す
		@Theory
		public void 昼12時以上_18時未満_の場合_こんにちは_と返す(Calendar cal) {
			System.out.println(testDataLoggin(cal));
			assertThat(cal.toString(), Greeter.greet(cal), is("こんにちは"));
		}
	};
	
	@RunWith(Theories.class)
	public static class 夜18時以上_05時未満_の場合{
		@DataPoints
		public static Calendar CALENDAR[];

		@BeforeClass
		public static void setUpCalendar() {
			CALENDAR = new Calendar[]{
					 newCalendar(
							  Calendar.getInstance(
									   TimeZone.getTimeZone("Asia/Tokyo")
									  ,Locale.JAPAN
									  )
							 ,18,0,0,0)
					,newCalendar(
							  Calendar.getInstance(
									   TimeZone.getTimeZone("Asia/Tokyo")
									  ,Locale.JAPAN
									  )
							 ,23,59,59,999)
					,newCalendar(
							 Calendar.getInstance(
									   TimeZone.getTimeZone("Asia/Tokyo")
									  ,Locale.JAPAN
									  )
							,0,0,0,0)
					,newCalendar(
							 Calendar.getInstance(
									   TimeZone.getTimeZone("Asia/Tokyo")
									  ,Locale.JAPAN
									  )
							,4,59,59,999)
					};
		}
		
		//夜(18:00:00以上 05:00:00未満)の場合、「こんばんは」と返す/
		@Theory
		public void 夜18時以上_05時未満_の場合_こんばんは_と返す(Calendar cal) {
			System.out.println(testDataLoggin(cal));
			assertThat(cal.toString(), Greeter.greet(cal), is("こんばんは"));
		}
	};
	
	public static class Calenderクラス動作確認{
		@Test
		public void test() throws InterruptedException{
			Calendar now = Calendar.getInstance(
					   TimeZone.getTimeZone("Asia/Tokyo")
					  ,Locale.JAPAN
					  );
			Calendar mock = newCalendar(
					 Calendar.getInstance(
							   TimeZone.getTimeZone("Asia/Tokyo")
							  ,Locale.JAPAN
							  )
					,4,59,59,999);
			System.out.println("now=" + testDataLoggin(now));
			System.out.println("mock=" + testDataLoggin(mock));
			
			Thread.sleep(2000L);

			//TODO Calendar.getInstanceはインスタンス作成した時点の時刻になる。
			//     同一インスタンスを2秒後につかっても時間は作成したタイミングになる。
			//     nowやmockにあたる呼び出しを行うクラスの作成が必要。
			System.out.println("2秒後 now=" + testDataLoggin(now));
			System.out.println("2秒後 mock=" + testDataLoggin(mock));
		}
	};
	
	static String testDataLoggin(Calendar cal){
		return "[testing・・・]"
				+ " HOUR_OF_DAY=" + cal.get(Calendar.HOUR_OF_DAY)
				+ ",MINUTE=" + cal.get(Calendar.MINUTE)
				+ ",SECOND=" + cal.get(Calendar.SECOND)
				+ ",MILLISECOND=" + cal.get(Calendar.MILLISECOND)
				;
	}
	static Calendar newCalendar(Calendar today, int hour, int minute, int second, int millisecond){
		Calendar cal = today;
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);
		cal.set(Calendar.SECOND, second);
		cal.set(Calendar.MILLISECOND, millisecond);
		return cal;
	}
}