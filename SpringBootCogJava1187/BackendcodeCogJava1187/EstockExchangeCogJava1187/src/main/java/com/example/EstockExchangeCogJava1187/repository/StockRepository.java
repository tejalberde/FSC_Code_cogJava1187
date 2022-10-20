package com.example.EstockExchangeCogJava1187.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.EstockExchangeCogJava1187.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

	@Modifying
	@Query("delete from Stock stock where stock.companyCode = :companyCode")
	void deleteAllStockForCompany(@Param("companyCode") int companyCode);

}
