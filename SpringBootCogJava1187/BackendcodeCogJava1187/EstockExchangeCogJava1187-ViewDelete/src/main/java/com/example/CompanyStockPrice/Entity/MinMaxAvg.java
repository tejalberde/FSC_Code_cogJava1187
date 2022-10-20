package com.example.CompanyStockPrice.Entity;

public class MinMaxAvg {

	private double MinimumPrice;
	private double MaximumPrice;
	private double AveragePrice;

	public double getMinimumPrice() {
		return MinimumPrice;
	}

	public void setMinimumPrice(double minimumPrice) {
		MinimumPrice = minimumPrice;
	}

	public double getMaximumPrice() {
		return MaximumPrice;
	}

	public void setMaximumPrice(double maximumPrice) {
		MaximumPrice = maximumPrice;
	}

	public double getAveragePrice() {
		return AveragePrice;
	}

	public void setAveragePrice(double averagePrice) {
		AveragePrice = averagePrice;
	}

}
