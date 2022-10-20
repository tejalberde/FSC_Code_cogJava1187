package com.example.EstockExchangeCogJava1187.entity;

import org.springframework.stereotype.Component;

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
