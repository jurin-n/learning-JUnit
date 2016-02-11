package com.jurin_n.junit.theories;

public class ConsumptionTax {
	private final int rate;
	
	public ConsumptionTax(int rate){
		this.rate = rate;
	}
	
	public int apply(int price){
		return price + (price * this.rate / 100);
	}
}
