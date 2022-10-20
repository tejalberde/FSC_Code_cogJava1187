package com.example.CompanyStockPrice.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Company {

	@Id
	@Column(name = "company_code")
	private int companyCode;

	@Column(name = "company_name")
	@NotNull
	private String companyName;
	@NotNull
	private String companyCEO;
	@NotNull
	private double turnover;
	@NotNull
	private String website;

	@Column(name = "stock_exchange")
	@NotNull
	private String stockExchange;

	public Company() {
		super();
	}

	public Company(int companyCode, String companyName, String companyCEO, double turnover, String website,
			String stockExchange) {
		super();
		this.companyCode = companyCode;
		this.companyName = companyName;
		this.companyCEO = companyCEO;
		this.turnover = turnover;
		this.website = website;
		this.stockExchange = stockExchange;
	}

	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCEO() {
		return companyCEO;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public double getTurnover() {
		return turnover;
	}

	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getStockExchange() {
		return stockExchange;
	}

	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
}
