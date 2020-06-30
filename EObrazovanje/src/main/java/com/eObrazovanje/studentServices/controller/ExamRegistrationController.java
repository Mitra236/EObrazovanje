package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.ExamPointsDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationDTO;
import com.eObrazovanje.studentServices.service.ExamRegistrationSServiceInterface;
import com.eObrazovanje.studentServices.service.ExamServiceInterface;

@RestController
@RequestMapping(value = "api/examRegistration")
@CrossOrigin(value = "*")
public class ExamRegistrationController {

	@Autowired
	ExamRegistrationSServiceInterface examRegistrationSServiceInterface;
	
	@Autowired
	ExamServiceInterface examService;
	
	@GetMapping
	private List<ExamRegistrationDTO> getExamRegistrations() {
		return examRegistrationSServiceInterface.findAll();
	}
	
	@PutMapping(consumes = "application/json")
	private ResponseEntity<ExamPointsDTO> addExamPoints(@RequestBody
			ExamPointsDTO examPointsDTO) {
		ExamRegistrationDTO exam = examRegistrationSServiceInterface.findOne(examPointsDTO.id);
		if (exam == null) {
			return new ResponseEntity<ExamPointsDTO>(HttpStatus.NOT_FOUND);
		}
		
		examRegistrationSServiceInterface.addFinalPoints(examPointsDTO);
		
		return new ResponseEntity<ExamPointsDTO>(examPointsDTO, HttpStatus.CREATED);
	}
}
