package com.eObrazovanje.studentServices.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.ExamDTO;
import com.eObrazovanje.studentServices.entity.ExamRegistration;
import com.eObrazovanje.studentServices.service.ExamServiceInterface;

@RestController
@RequestMapping(value = "api/exams")
@CrossOrigin(value="*")
public class ExamController {
	
	@Autowired
	ExamServiceInterface examServiceInterface;
	
	@GetMapping
	private List<ExamDTO> getExams() {
		return examServiceInterface.findAll();
	}

	@PostMapping(consumes = "application/json")
	private ResponseEntity<List<ExamRegistration>> addFinalPoints() {
		return null;
	}
	
	@GetMapping(value="/{studyProgrammeId}/current")
	private List<ExamDTO> getCurrentExams(@PathVariable("studyProgrammeId") int id) {
		return examServiceInterface.getCurrentExams(id);
	}
	
	@GetMapping(value = "/period")
	private ResponseEntity<List<ExamDTO>> getExamsByExamPeriod(@RequestParam("id") int id, @RequestParam("period") String period) {
		List<ExamDTO> examDTOs = examServiceInterface.getExamsByExamPeriod(id,  period);
		if(examDTOs.size() <= 0) {
			return new ResponseEntity<List<ExamDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<ExamDTO>>(examDTOs, HttpStatus.OK);
	}
}
