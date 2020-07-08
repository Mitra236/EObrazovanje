package com.eObrazovanje.studentServices.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.ExamAdminDTO;
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
	
	@GetMapping(value = "exam")
	private ExamDTO getExam(@RequestParam("id") int id) {
		return examServiceInterface.findOne(id);
	}
	
	@GetMapping(value = "examAdmin")
	private ExamAdminDTO getExamAdmin(@RequestParam("id") int id) {
		return examServiceInterface.findOneAdmin(id);
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
			return new ResponseEntity<List<ExamDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ExamDTO>>(examDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/examsJanuary")
	private ResponseEntity<List<ExamAdminDTO>> getExamsJanuary(@RequestParam("id") int id, @RequestParam("period") String period) {
		List<ExamAdminDTO> examDTOs = examServiceInterface.getExamsJanuary(id, period);
		if(examDTOs.size() <= 0) {
			return new ResponseEntity<List<ExamAdminDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ExamAdminDTO>>(examDTOs, HttpStatus.OK);
	}
	
	@PostMapping(value = "add", consumes= "application/json")
	private ResponseEntity<Integer> addExam(@RequestBody ExamAdminDTO examAdminDTO) {
		if (examAdminDTO == null) return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		
		examServiceInterface.save(examAdminDTO);
		
		return new ResponseEntity<Integer>(examAdminDTO.id, HttpStatus.CREATED);
	}
	
	@PutMapping(consumes= "application/json")
	private ResponseEntity<Void> editExam(@RequestBody ExamAdminDTO examAdminDTO) {
		if (examAdminDTO == null) return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
		examServiceInterface.update(examAdminDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@DeleteMapping(value= "/{id}")
	private ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		examServiceInterface.remove(id);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
}
