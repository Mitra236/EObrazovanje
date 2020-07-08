package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.DTO.CourseToAddDTO;
import com.eObrazovanje.studentServices.DTO.EnrollmentDTO;
import com.eObrazovanje.studentServices.DTO.ExamDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationDTO;
import com.eObrazovanje.studentServices.DTO.FinancialCardDTO;
import com.eObrazovanje.studentServices.DTO.StudentBasicInfoDTO;
import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.DTO.StudentDetailsDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.service.CourseServiceInterface;
import com.eObrazovanje.studentServices.service.ExamRegistrationSServiceInterface;
import com.eObrazovanje.studentServices.service.StudentServiceInterface;

@RestController
@RequestMapping("api/students")
@CrossOrigin(value="*")
public class StudentController {

	@Autowired
	StudentServiceInterface studentServiceInterface;
	@Autowired
	ExamRegistrationSServiceInterface examRegistrationServiceInterface;
	
	@GetMapping
	private List<StudentDTO> getStudents() {
		return studentServiceInterface.findAll();
	}
	
	@GetMapping(value="/{studentId}")
	private StudentDetailsDTO getStudentInfo(@PathVariable("studentId") int id) {
		return studentServiceInterface.findOne(id);
	}
	
	@GetMapping(value="/student")
	private StudentDetailsDTO getStudent(@RequestParam("id") int id) {
		return studentServiceInterface.findOne(id);
	}
	
	@PutMapping(consumes = "application/json")
	private ResponseEntity<Integer> editStudent(@RequestBody StudentDetailsDTO editedStudent) {
		StudentDetailsDTO student = studentServiceInterface.findOne(editedStudent.id);
		if (student == null) return new ResponseEntity<Integer>(0, HttpStatus.NOT_FOUND); 
		
		int updatedId = studentServiceInterface.updateDTO(editedStudent);
		
		return new ResponseEntity<Integer>(updatedId, HttpStatus.CREATED);
	}
	
	@PostMapping(consumes = "application/json")
	private ResponseEntity<Integer> saveStudent(@RequestBody StudentDetailsDTO studentDTO) {
		if (studentDTO == null) return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND); 
		
		int studentId = studentServiceInterface.create(studentDTO);
		
		return new ResponseEntity<Integer>(studentId, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value="/{studentId}/exams-current")
	private List<ExamDTO> getCurrentExamsForSTudent(@PathVariable("studentId") int id) {
		return studentServiceInterface.getCurrentExams(id);
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
	private List<FinancialCardDTO> getFinancialCardInfo(@PathVariable("studentId") int id) {
		return studentServiceInterface.getFinancialCardInfo(id);
	}
	
	@GetMapping(value="/{studentId}/registered-exam")
	private List<ExamRegistrationDTO> getCurrentExamRegistrations(@PathVariable("studentId") int id) {
		return studentServiceInterface.findActiveExams(id);
	}
	
	@PutMapping(value="/{studentId}/unregistered-exam/{examRegistrationId}")
	private List<ExamRegistrationDTO> unregisterExam(@PathVariable("studentId") int id, @PathVariable("examRegistrationId") int examRegistrationId) {
		examRegistrationServiceInterface.remove(examRegistrationId);
		
		return studentServiceInterface.findActiveExams(id);
	}
	
	@GetMapping(value="enrollments")
	private ResponseEntity<List<StudentBasicInfoDTO>> getNotEnrolledStudents(@RequestParam("id") int id) {
		List<StudentBasicInfoDTO> studentDTOs = studentServiceInterface.getNotEnrolledStudents(id);
		if(studentDTOs.size() <= 0) {
			return new ResponseEntity<List<StudentBasicInfoDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<StudentBasicInfoDTO>>(studentDTOs, HttpStatus.OK);
	}
	

	@GetMapping(value="notEnrolledStudents/{courseId}")
	private ResponseEntity<List<StudentBasicInfoDTO>> getStudentsWithoutSelectedCourse(@PathVariable("courseId") int courseId) {
		List<StudentBasicInfoDTO> studentDTOs = studentServiceInterface.getNotEnrolledStudents(courseId);
		if(studentDTOs.size() <= 0) {
			return new ResponseEntity<List<StudentBasicInfoDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<StudentBasicInfoDTO>>(studentDTOs, HttpStatus.OK);
	}
	
	@GetMapping(value="studentEnrollments/{studentId}")
	private ResponseEntity<List<EnrollmentDTO>> getStudentEnrollments(@PathVariable("studentId") int id) {
		List<EnrollmentDTO> enrollmentDTOs = studentServiceInterface.getStudentEnrollments(id);
		if(enrollmentDTOs == null || enrollmentDTOs.size() < 1)
			return new ResponseEntity<List<EnrollmentDTO>>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<EnrollmentDTO>>(enrollmentDTOs, HttpStatus.OK);
	}
	
	
	@PostMapping(value="/{studentId}/register-exam/{examId}")
	private int registerExam(@PathVariable("studentId") int studentId, @PathVariable("examId") int examId) {
		return studentServiceInterface.registerExam(studentId, examId);
	}
}
