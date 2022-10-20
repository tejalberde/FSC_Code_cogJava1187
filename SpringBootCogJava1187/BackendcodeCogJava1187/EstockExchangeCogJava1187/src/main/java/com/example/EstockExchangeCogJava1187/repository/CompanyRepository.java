package com.example.EstockExchangeCogJava1187.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EstockExchangeCogJava1187.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
