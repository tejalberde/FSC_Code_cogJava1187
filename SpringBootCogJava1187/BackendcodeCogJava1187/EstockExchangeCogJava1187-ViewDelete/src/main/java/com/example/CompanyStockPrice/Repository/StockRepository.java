package com.example.CompanyStockPrice.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.CompanyStockPrice.Entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	List<Stock> findByCompanyCode(int companyCode);

	@Query("select stock from Stock stock where stock.companyCode = :companyCode and (stock.stockDate between :fromDt AND :endDt)")
	List<Stock> findByCompanyCodeAndBetweenDates(@Param("companyCode") int companyCode,
			@Param("fromDt") LocalDate fromDt, @Param("endDt") LocalDate endDt);

	Stock findFirstByCompanyCodeOrderByCurrentDatetimeDesc(int companyCode);

}
