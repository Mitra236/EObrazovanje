package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.ExamDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationDTO;
import com.eObrazovanje.studentServices.DTO.StudentBasicInfoDTO;
import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.DTO.StudentDetailsDTO;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.service.StudentServiceInterface;

@RestController
@RequestMapping("api/students")
@CrossOrigin(value="*")
public class StudentController {

	@Autowired
	StudentServiceInterface studentServiceInterface;
	
	@GetMapping
	private List<StudentDTO> getStudents() {
		return studentServiceInterface.findAll();
	}
	
	@GetMapping(value="/{studentId}")
	private StudentDetailsDTO getStudentInfo(@PathVariable("studentId") int id) {
		return studentServiceInterface.findOne(id);
	}
	
	@GetMapping(value="/{studentId}/exams")
	private List<ExamRegistrationDTO> getTakenExams(@PathVariable("studentId") int id) {
		return studentServiceInterface.findTakenExams(id);
	}
	
	@GetMapping(value="/{studentId}/failed-exams")
	private List<ExamRegistrationDTO> getFailedExams(@PathVariable("studentId") int id) {
		return studentServiceInterface.findFailedExams(id);
	}
	
	@GetMapping(value="/{studentId}/passed-exams")
	private List<ExamRegistrationDTO> getPassedExams(@PathVariable("studentId") int id) {
		return studentServiceInterface.findPassedExams(id);
	}

	@GetMapping(value="/{studentId}/financial-card")
	private List<StudentDTO> getFinancialCardInfo(@PathVariable("studentId") int id) {
		return studentServiceInterface.findAll();
	}
	
	@GetMapping(value="enrollments")
	private ResponseEntity<List<StudentBasicInfoDTO>> getNotEnrolledStudents(@RequestParam("id") int id) {
		List<StudentBasicInfoDTO> studentDTOs = studentServiceInterface.getNotEnrolledStudents(id);
		if(studentDTOs.size() <= 0) {
			return new ResponseEntity<List<StudentBasicInfoDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<StudentBasicInfoDTO>>(studentDTOs, HttpStatus.OK);
	}
}
