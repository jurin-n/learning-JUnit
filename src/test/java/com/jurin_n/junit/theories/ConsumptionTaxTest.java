package com.jurin_n.junit.theories;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class ConsumptionTaxTest {
	@RunWith(Theories.class)
	public static class 一般的な状態の場合 {
		@DataPoints
		public static Fixture[] FIXTURES = new Fixture[]{
			 new Fixture(5, 100, 105)
			,new Fixture(5, 3000, 3150)
			,new Fixture(10, 50, 55)
			,new Fixture(5, 50, 52)
			,new Fixture(3, 50, 51)
		};
		
		@Theory
		public void applyで消費税が加算された価格が取得できる(Fixture fixture){
			ConsumptionTax sut = new ConsumptionTax(fixture.taxRate);
			String desc = "when rate=" + fixture.taxRate
					+", price=" + fixture.price;
			assertThat(desc, sut.apply(fixture.price), is(fixture.expected));
		}
	}
}

class Fixture{
	final int taxRate;
	final int price;
	final int expected;
	Fixture(int taxRate,int price,int expected){
		this.taxRate = taxRate;
		this.price = price;
		this.expected = expected;
	}
}
