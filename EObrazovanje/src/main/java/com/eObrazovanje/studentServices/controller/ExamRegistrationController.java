package com.eObrazovanje.studentServices.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.DTO.ExamPeriodDTO;
import com.eObrazovanje.studentServices.DTO.ExamPointsDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationCheckDTO;
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
	
	@GetMapping(value="/activeExams")
	private ResponseEntity<List<ExamRegistrationDTO>> getActiveExams(@RequestParam("id") int id) {
		List<ExamRegistrationDTO> examRegistrationDTOs = examRegistrationSServiceInterface.getActiveProfessorExams(id);
		if(examRegistrationDTOs.size() <= 0) return new ResponseEntity<List<ExamRegistrationDTO>>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<ExamRegistrationDTO>>(examRegistrationDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value="/exam-course")
	private ResponseEntity<CourseDTO> findCourseForExam(@RequestParam("id") int id) {
		CourseDTO examRegistrationDTOs = examRegistrationSServiceInterface.findCourseForExam(id);
		if(examRegistrationDTOs == null) return new ResponseEntity<CourseDTO>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<CourseDTO>(examRegistrationDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value="/activeExamsAdmin")
	private ResponseEntity<List<ExamRegistrationCheckDTO>> getActiveExamsAdmin(@RequestParam("id") int id) {
		List<ExamRegistrationCheckDTO> examRegistrationDTOs = examRegistrationSServiceInterface.getNotCheckedExamsInActivePeriod(id);
		if(examRegistrationDTOs.size() <= 0) return new ResponseEntity<List<ExamRegistrationCheckDTO>>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<ExamRegistrationCheckDTO>>(examRegistrationDTOs, HttpStatus.OK);
	}
	
	@PutMapping(value = "check", consumes = "application/json")
	private ResponseEntity<Void> checkExamRegistration(@RequestBody int id) {
		ExamRegistrationCheckDTO examRegistrationCheckDTO = examRegistrationSServiceInterface.findOneChecked(id);
		if (examRegistrationCheckDTO == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
		examRegistrationSServiceInterface.checkRegistration(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
