package com.eObrazovanje.studentServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.entity.FinancialCard;
import com.eObrazovanje.studentServices.repository.FinancialCardRepository;

@Service
public class FinancialCardService implements FinancialCardServiceInterface {
	
	@Autowired
	FinancialCardRepository financialCardRepository;

	@Override
	public FinancialCard findOne(int id) {
		// TODO Auto-generated method stub
		return financialCardRepository.findById(id).orElse(null);
	}

	@Override
	public List<FinancialCard> findAll() {
		// TODO Auto-generated method stub
		return financialCardRepository.findAll();
	}

	@Override
	public int save(FinancialCard financialCard) {
		// TODO Auto-generated method stub
		return financialCardRepository.save(financialCard).getId();
	}

}
