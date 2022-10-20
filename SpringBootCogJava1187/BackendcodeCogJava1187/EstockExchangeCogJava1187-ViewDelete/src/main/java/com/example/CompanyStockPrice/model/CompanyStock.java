package com.example.CompanyStockPrice.model;

import org.springframework.stereotype.Component;

import com.example.CompanyStockPrice.Entity.Company;
import com.example.CompanyStockPrice.Entity.Stock;

@Component
public class CompanyStock {
	private Company company;
	private Stock stock;

	public CompanyStock() {
		super();
	}

	public CompanyStock(Company company, Stock stock) {
		super();
		this.company = company;
		this.stock = stock;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
