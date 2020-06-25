package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.entity.FinancialCard;

public interface FinancialCardServiceInterface {
	
	FinancialCard findOne(int id);
	List<FinancialCard> findAll();
	int save(FinancialCard financialCard);

}
