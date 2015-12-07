package com.jurin_n.refactoring;

public class NewReleasePrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}
	
	@Override
	double getCharge(int daysRented){
		return daysRented * 3;
	}

	@Override
	int getFrequentRenterPoints(int daysRented) {
		if(daysRented > 1){
			//新作を二日以上借りた場合はボーナスポイント
			return 2;
		}
		return 1;
	}
}
