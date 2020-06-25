package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.service.StudentServiceInterface;

@RestController
@RequestMapping("api/students")
public class StudentController {

	@Autowired
	StudentServiceInterface studentServiceInterface;
	
	@GetMapping
	private List<StudentDTO> getStudents() {
		return studentServiceInterface.findAll();
	}
	
	@GetMapping(value="/{studentId}/exams")
	private List<Exam> getTakenExams(@PathVariable("studentId") int id) {
		return studentServiceInterface.findTakenExams(id);
	}
	
	@GetMapping(value="/{studentId}/passed-exams")
	private List<Exam> getFailedExams(@PathVariable("studentId") int id) {
		return studentServiceInterface.findFailedExams(id);
	}
	
	@GetMapping(value="/{studentId}/failed-exams")
	private List<Exam> getPassedExams(@PathVariable("studentId") int id) {
		return studentServiceInterface.findPassedExams(id);
	}
	
	@GetMapping(value="/{studentId}/financial-card")
	private List<StudentDTO> getFinancialCardInfo(@PathVariable("studentId") int id) {
		return studentServiceInterface.findAll();
	}
}
