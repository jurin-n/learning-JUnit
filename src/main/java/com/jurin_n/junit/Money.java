package com.jurin_n.junit;

public class Money {
	private int fAmount;
	private String fCurrency;
	
	public Money(int amount, String currency){
		fAmount = amount;
		fCurrency = currency;
	}
	
	public int amount(){
		return fAmount;
	}
	public String currency(){
		return fCurrency;
	}
	public Money add(Money m){
		return new Money(amount() + m.amount(),currency());
	}
	
	@Override
	public boolean equals(Object anObject){
		if(anObject instanceof Money){
			Money aMoney = (Money)anObject;
			return aMoney.currency().equals(currency())
				&& aMoney.amount() == amount();
		}
		return false;
	}
}
