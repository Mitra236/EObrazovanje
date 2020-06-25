package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.entity.ExamPeriod;
import com.eObrazovanje.studentServices.service.ExamPeriodServiceInterface;

@RestController
@RequestMapping(value = "api/examPeriods")
public class ExamPeriodController {
	
	@Autowired
	ExamPeriodServiceInterface examPeriodServiceInterface;
	
	@GetMapping
	private List<ExamPeriod> getExamPeriods() {
		return examPeriodServiceInterface.findAll();
	}

}
