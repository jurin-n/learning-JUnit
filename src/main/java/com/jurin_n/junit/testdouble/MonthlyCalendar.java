package com.jurin_n.junit.testdouble;

import java.util.Calendar;

public class MonthlyCalendar {
	private final Calendar cal;
	
	//プロダクションコードはこちらのコンストラクタ利用を想定。
	public MonthlyCalendar(){
		this(Calendar.getInstance());
	}
	
	//UnitTest用のコンストラクタ。自由に実行日時を設定できるようにするために準備。
	MonthlyCalendar(Calendar cal){
		this.cal = cal;
	}
	public int getRemainginDays(){
		return cal.getActualMaximum(Calendar.DATE)
					-cal.get(Calendar.DATE);
	}
}
