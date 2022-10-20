package com.example.CompanyStockPrice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CompanyStockPrice.Entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
