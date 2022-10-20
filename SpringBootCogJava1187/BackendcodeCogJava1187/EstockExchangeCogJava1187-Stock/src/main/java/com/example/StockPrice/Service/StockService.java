package com.example.StockPrice.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.StockPrice.Entity.Stock;
import com.example.StockPrice.Repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	public Stock addStock(Stock stock) {
		stock.setStockid(0);
		stock.setStockDate(LocalDate.now());
		stock.setStockTime(LocalTime.now());
		stock.setCurrentDatetime(LocalDateTime.now());
		return stockRepository.save(stock);
	}

	public Stock getStock(int stockid) {
		Stock stock = new Stock();
		stock.setStockid(stockid);
		return stockRepository.findById(stock.getStockid()).orElse(null);
	}

}
