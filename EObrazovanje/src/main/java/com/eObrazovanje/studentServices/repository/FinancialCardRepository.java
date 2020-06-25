package com.eObrazovanje.studentServices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eObrazovanje.studentServices.entity.FinancialCard;

public interface FinancialCardRepository extends JpaRepository<FinancialCard, Integer> {

}
