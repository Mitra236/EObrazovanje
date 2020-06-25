package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.service.ExamServiceInterface;

@RestController
@RequestMapping(value = "api/exams")
public class ExamController {
	
	@Autowired
	ExamServiceInterface examServiceInterface;
	
	@GetMapping
	private List<Exam> getExams() {
		return examServiceInterface.findAll();
	}

}
