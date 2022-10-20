package com.example.CompanyStockPrice.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CompanyStockPrice.Entity.Company;
import com.example.CompanyStockPrice.Entity.MinMaxAvg;
import com.example.CompanyStockPrice.Entity.Stock;
import com.example.CompanyStockPrice.Service.CompanyStockService;
import com.example.CompanyStockPrice.model.CompanyStock;

@RestController
@RequestMapping("/viewCompanyStock")
public class CompanyStockController {

	@Autowired
	CompanyStockService companyStockService;

	@Autowired
	CompanyStock companyStock;

	@GetMapping("/getCompany/{companyCode}")
	public CompanyStock getCompany(@PathVariable int companyCode) {
		// CompanyStock companyStock = new CompanyStock();
		companyStock.setCompany(companyStockService.getCompany(companyCode));
		companyStock.setStock(companyStockService.getStockLatestPrice(companyCode));
		return companyStock;
	}

	@GetMapping("/ListAllComapany")
	public List<CompanyStock> listAllCompany() {
		List<CompanyStock> listCompanyAndStock = new ArrayList<>();
		List<Company> allCompany = companyStockService.listAllCompany();
		for (Company company : allCompany) {
			Stock stock = companyStockService.getStockLatestPrice(company.getCompanyCode());
			listCompanyAndStock.add(new CompanyStock(company, stock));
		}
		return listCompanyAndStock;
	}

	@GetMapping("/ListAllStock")
	public List<Stock> listAllStock() {
		return companyStockService.listAllStock();
	}

	@GetMapping("/FindStockByCompanyCode/{companyCode}")
	public List<Stock> findAllStockByCompanyCode(@PathVariable int companyCode) {
		return companyStockService.findAllStockByCompanyCode(companyCode);
	}

	@GetMapping("/GetStockByDates")
	public List<Stock> betweenDate(@RequestParam int companyCode, @RequestParam String fromDate,
			@RequestParam String endDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fromDt = LocalDate.parse(fromDate, formatter);
		LocalDate endDt = LocalDate.parse(endDate, formatter);
		return companyStockService.betweenDate(companyCode, fromDt, endDt);

	}

	@GetMapping("/GetMinMaxAvgPrice")
	public MinMaxAvg minMaxAvgPrice(@RequestParam int companyCode, @RequestParam String fromDate,
			@RequestParam String endDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fromDt = LocalDate.parse(fromDate, formatter);
		LocalDate endDt = LocalDate.parse(endDate, formatter);
		List<Stock> stock = companyStockService.betweenDate(companyCode, fromDt, endDt);
		int size = stock.size();
		Optional<Stock> minPrice = stock.stream().min(Comparator.comparing(Stock::getPrice));
		Optional<Stock> maxPrice = stock.stream().max(Comparator.comparing(Stock::getPrice));
		double sum = 0.0;
		for (Stock stock2 : stock) {
			sum = sum + stock2.getPrice();
		}
		MinMaxAvg price = new MinMaxAvg();
		price.setMinimumPrice(minPrice.get().getPrice());
		price.setMaximumPrice(maxPrice.get().getPrice());
		price.setAveragePrice((sum / size));
	//	List<Double> price = Arrays.asList(minPrice.get().getPrice(), maxPrice.get().getPrice(), (sum / size));
		return price;
	}

}
