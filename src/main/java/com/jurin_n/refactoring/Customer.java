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
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		for(Rental rental : rentals){
			double thisAmount = amountFor(rental);
			
			//レンタルポイントを加算
			frequentRenterPoints++;
			
			//新作を二日以上借りた場合はボーナスポイント
			if((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
				rental.getDaysRented() > 1){
				frequentRenterPoints++;
			}
			
			//この貸し出しに関する数値の表示
			result += "\t" + rental.getMovie().getTitle() + "\t" +
						thisAmount + "\n";
			totalAmount += thisAmount;
		}
		
		//フッタ部分の追加
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints +
				" frequent renter points";
		return result;
	}

	private double amountFor(Rental aRental) {
		double result = 0;
		
		//一行ごとに金額を計算
		switch(aRental.getMovie().getPriceCode()){
			case Movie.REGULAR:
				result += 2;
				if(aRental.getDaysRented() >= 2){
					result  += (aRental.getDaysRented() -2) * 1.5;
				}
				break;
			case Movie.NEW_RELEASE:
				result += aRental.getDaysRented() * 3;
				break;
			case Movie.CHILDRENS:
				result += 1.5;
				if(aRental.getDaysRented() > 3){
					result += (aRental.getDaysRented() - 3) * 1.5;
				}
				break;
		}
		return result;
	}
}
