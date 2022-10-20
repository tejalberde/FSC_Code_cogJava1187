package com.example.CompanyStockPrice.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CompanyStockPrice.Entity.Company;
import com.example.CompanyStockPrice.Entity.Stock;
import com.example.CompanyStockPrice.Repository.CompanyRepository;
import com.example.CompanyStockPrice.Repository.StockRepository;

@Service
public class CompanyStockService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private StockRepository stockRepository;
	Company company = new Company();
	Stock stock = new Stock();
	Stock stock1 = new Stock();

	public Company getCompany(int companyCode) {
		company.setCompanyCode(companyCode);
		return companyRepository.findById(company.getCompanyCode()).orElse(null);
	}

	public Stock getStockLatestPrice(int companyCode) {
		stock.setCompanyCode(companyCode);
		return stockRepository.findFirstByCompanyCodeOrderByCurrentDatetimeDesc(stock.getCompanyCode());
	}

	public List<Company> listAllCompany() {
		return companyRepository.findAll();
	}

	public List<Stock> listAllStock() {
		return stockRepository.findAll();
	}

	public List<Stock> findAllStockByCompanyCode(int companyCode) {
		stock.setCompanyCode(companyCode);
		return stockRepository.findByCompanyCode(stock.getCompanyCode());
	}

	public List<Stock> betweenDate(int companyCode, LocalDate fromDt, LocalDate endDt) {
		stock.setCompanyCode(companyCode);
		return stockRepository.findByCompanyCodeAndBetweenDates(stock.getCompanyCode(), fromDt, endDt);
	}

	/* for testing */
	public Company addCompany(Company company) {
		return companyRepository.save(company);
	}

	public Stock addStock(Stock stock) {
		return stockRepository.save(stock);
	}

}
