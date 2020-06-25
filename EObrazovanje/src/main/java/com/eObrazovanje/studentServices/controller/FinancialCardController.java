package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.entity.FinancialCard;
import com.eObrazovanje.studentServices.service.FinancialCardServiceInterface;

@RestController
@RequestMapping(value = "api/financialCard")
public class FinancialCardController {
	
	@Autowired
	FinancialCardServiceInterface financialCardServiceInterface;
	
	@GetMapping
	private List<FinancialCard> getAll() {	
		return financialCardServiceInterface.findAll();
	}

}
