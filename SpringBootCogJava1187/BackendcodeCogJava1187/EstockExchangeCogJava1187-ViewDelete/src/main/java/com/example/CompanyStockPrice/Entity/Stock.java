package com.example.CompanyStockPrice.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Stock {
	@Id
	@GeneratedValue
	private int stockid;

	@Column(name = "company_code", nullable = false)
	private int companyCode;
	@NotNull
	private double price;

	@Column(name = "stock_date", nullable = false)
	private LocalDate stockDate;

	@Column(name = "stock_time", nullable = false)
	private LocalTime StockTime;

	@Column(name = "current_datetime", nullable = false)
	private LocalDateTime currentDatetime;

	public LocalDateTime getCurrentDatetime() {
		return currentDatetime;
	}

	public void setCurrentDatetime(LocalDateTime currentDatetime) {
		this.currentDatetime = currentDatetime;
	}

	public Stock() {
		super();
	}

	public Stock(int stockid, int companyCode, double price, LocalDate stockDate, LocalTime stockTime,
			LocalDateTime currentDatetime) {
		super();
		this.stockid = stockid;
		this.companyCode = companyCode;
		this.price = price;
		this.stockDate = stockDate;
		StockTime = stockTime;
		this.currentDatetime = currentDatetime;
	}

	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	public int getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getStockDate() {
		return stockDate;
	}

	public void setStockDate(LocalDate stockDate) {
		this.stockDate = stockDate;
	}

	public LocalTime getStockTime() {
		return StockTime;
	}

	public void setStockTime(LocalTime stockTime) {
		StockTime = stockTime;
	}

}
