package com.jurin_n.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();
	
	public Customer(String name){
		this.name = name;
	}
	
	public void addRental(Rental rental){
		rentals.add(rental);
	}
	
	public String getName(){
		return this.name;
	}
	
	public String statement(){
		String result = "Rental Record for " + getName() + "\n";
		for(Rental rental : rentals){			
			//この貸し出しに関する数値の表示
			result += "\t" + rental.getMovie().getTitle() + "\t" +
					rental.getCharge() + "\n";
		}
		
		//フッタ部分の追加
		result += "Amount owed is " + getTotalCharge() + "\n";
		result += "You earned " + getTotalFrequentRenterPoints() +
				" frequent renter points";
		return result;
	}
	
	public String htmlStatement(){
		String result = "<h1>Rental Record for <strong>" + getName() + "</strong></h1>\n";
		for(Rental rental : rentals){			
			//この貸し出しに関する数値の表示
			result += rental.getMovie().getTitle() + ":" +
					rental.getCharge() + "<br/>\n";
		}
		
		//フッタ部分の追加
		result += "<p>You owe <strong>" + getTotalCharge() + "</strong>\n";
		result += "On this rental you earned <strong>"
				 + getTotalFrequentRenterPoints()
				 + "</strong> frequent renter points</p>";
		return result;
	}
	
	private double getTotalCharge(){
		double result = 0;
		for(Rental rental : rentals){
			result += rental.getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints(){
		int result = 0;
		for(Rental rental : rentals){
			//レンタルポイントを加算
			result += rental.getFrequentRenterPoints();
		}
		return result;
	}
}
