package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.ExamPeriodDTO;
import com.eObrazovanje.studentServices.service.ExamPeriodServiceInterface;

@RestController
@RequestMapping(value = "api/examPeriods")
public class ExamPeriodController {
	
	@Autowired
	ExamPeriodServiceInterface examPeriodServiceInterface;
	
	@GetMapping
	private ResponseEntity<List<ExamPeriodDTO>> getExamPeriods() {
		return new ResponseEntity<List<ExamPeriodDTO>>(examPeriodServiceInterface.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/examPeriod")
	private ResponseEntity<ExamPeriodDTO> getExamPeriod(@RequestParam("id") int id) {
		ExamPeriodDTO examPeriodDTO = examPeriodServiceInterface.findOne(id);
		if (examPeriodDTO == null) {
			return new ResponseEntity<ExamPeriodDTO>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ExamPeriodDTO>(examPeriodDTO, HttpStatus.OK);
	}
	
	@PutMapping(consumes = "application/json")
	private ResponseEntity<Void> editExamPeriod(@RequestBody ExamPeriodDTO examPeriodDTO) {
		ExamPeriodDTO examPeriod = examPeriodServiceInterface.findOne(examPeriodDTO.id);
		if (examPeriod == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
		}
		
		examPeriodServiceInterface.update(examPeriod);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping(consumes = "application/json")
	private ResponseEntity<ExamPeriodDTO> addExamPeriod(@RequestBody ExamPeriodDTO examPeriodDTO) {
		if (examPeriodDTO == null) {
			return new ResponseEntity<ExamPeriodDTO>(HttpStatus.NOT_FOUND);
		}
		
		examPeriodServiceInterface.save(examPeriodDTO);
		
		return new ResponseEntity<ExamPeriodDTO>(examPeriodDTO, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "id")
	private ResponseEntity<Boolean> deleteExamPeriod(@PathVariable int id) {
		ExamPeriodDTO examPeriodDTO = examPeriodServiceInterface.findOne(id);
		if (examPeriodDTO == null) {
			return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
		
		examPeriodServiceInterface.remove(id);
		
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
}
