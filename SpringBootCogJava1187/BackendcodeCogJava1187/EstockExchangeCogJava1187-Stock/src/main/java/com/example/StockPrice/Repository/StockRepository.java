package com.example.StockPrice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StockPrice.Entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

}
