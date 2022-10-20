package com.example.EstockExchangeCogJava1187.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.EstockExchangeCogJava1187.entity.Company;
import com.example.EstockExchangeCogJava1187.entity.CompanyStock;
import com.example.EstockExchangeCogJava1187.entity.Stock;
import com.example.EstockExchangeCogJava1187.repository.CompanyRepository;
import com.example.EstockExchangeCogJava1187.repository.StockRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private StockRepository stockRepository;
	Company company = new Company();
	Stock stock = new Stock();
	Stock stock1 = new Stock();

	@Transactional
	public String addCompany(CompanyStock company) {
		String result;
		Optional<Company> com = companyRepository.findById(company.getCompany().getCompanyCode());
		if (com.isPresent()) {
			result = "record is already present";
		} else {
			companyRepository.save(company.getCompany());
			company.getStock().setCompanyCode(company.getCompany().getCompanyCode());
			company.getStock().setStockDate(LocalDate.now());
			company.getStock().setStockTime(LocalTime.now());
			company.getStock().setCurrentDatetime(LocalDateTime.now());
			stockRepository.save(company.getStock());
			result = "Company added successfully";
		}
		return result;
	}

	@Transactional
	public String deleteCompanyAndStock(int companyCode) {
		company.setCompanyCode(companyCode);
		stock.setCompanyCode(companyCode);
		String result;
		Optional<Company> optionalCompany = companyRepository.findById(company.getCompanyCode());
		if (optionalCompany.isPresent()) {
			companyRepository.deleteById(company.getCompanyCode());
			stockRepository.deleteAllStockForCompany(stock.getCompanyCode());
			result = "Company Deleted successfully!!";
		} else {
			result = "Company not found!!";
		}
		return result;
	}

}
