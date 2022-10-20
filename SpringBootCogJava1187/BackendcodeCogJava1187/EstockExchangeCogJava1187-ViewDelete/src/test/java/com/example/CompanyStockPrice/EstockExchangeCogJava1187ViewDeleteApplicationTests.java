package com.example.CompanyStockPrice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.example.CompanyStockPrice.Entity.Company;
import com.example.CompanyStockPrice.Entity.Stock;
import com.example.CompanyStockPrice.Repository.CompanyRepository;
import com.example.CompanyStockPrice.Repository.StockRepository;
import com.example.CompanyStockPrice.Service.CompanyStockService;
import com.example.CompanyStockPrice.model.CompanyStock;


@SpringBootTest
class EstockExchangeCogJava1187ViewDeleteApplicationTests {

	@InjectMocks
	CompanyStockService companyStockService;

	
	@Mock
	CompanyRepository companyRepository;
	
	@Mock
	StockRepository stockRepository;
	
	@Test
	void contextLoads() {

		}
	

	@Test
		public void persistData()
		{
			Company company =new Company(1, "cogni", "xyz", 100000000, "website", "NSE");	
			Company companyReturn =new Company(1, "cogni", "xyz", 100000000, "website", "NSE");			
			when(companyRepository.save(company)).thenReturn(companyReturn);			
			Company companyResult = companyStockService.addCompany(company);			
			assertNotNull(companyResult);
			assertEquals("cogni", companyResult.getCompanyName());
			
		}
	
	@Test
	public void persistDataStock()
	{
		LocalDate stockDate= LocalDate.now();
		LocalTime stockTime = LocalTime.now();
		LocalDateTime currentDatetime = LocalDateTime.now();
		Stock stock = new Stock(1, 1, 1234, stockDate, stockTime, currentDatetime);
		Stock stock1 = new Stock(1, 1, 1234, stockDate, stockTime, currentDatetime);			
		when(stockRepository.save(stock)).thenReturn(stock1);			
		Stock stockResult = companyStockService.addStock(stock);			
		assertNotNull(stockResult);
		assertEquals(1,stockResult.getCompanyCode());
		
	}
	
	
	@Test
	public void getStock()
	{
		persistData();
		persistDataStock();
		List<Stock> stock = companyStockService.findAllStockByCompanyCode(1);
		for (Stock stock2 : stock) {
			assertNotNull(stock2.getCompanyCode());
			System.out.println(stock2.getStockid());
			}	
	}
	
/*	@Test
	public void getCompany()
	{
		persistData();
		persistDataStock();
		persistDataStock1();
//		Optional<Company> company = companyRepository.findById(1);
		Stock stock = companyStockService.getStockLatestPrice(1);
	  //  assertNotNull(company.isPresent());
    assertEquals(1, stock.getStockid());
	}*/

}
