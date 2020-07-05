package com.eObrazovanje.studentServices.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.eObrazovanje.studentServices.DTO.EnrollmentDTO;
import com.eObrazovanje.studentServices.DTO.ExamDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationDTO;
import com.eObrazovanje.studentServices.DTO.FinancialCardDTO;
import com.eObrazovanje.studentServices.DTO.StudentBasicInfoDTO;
import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.DTO.StudentDetailsDTO;
import com.eObrazovanje.studentServices.entity.Admin;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.entity.Student;

public interface StudentServiceInterface {

	StudentDetailsDTO findOne(int id);
	StudentDTO findOneForEnrollment(int id);
	List<StudentDTO> findAll();
	int save(Student student);
	List<ExamRegistrationDTO> findPassedExams(int id);
	List<ExamRegistrationDTO> findFailedExams(int id);
	List<ExamRegistrationDTO> findTakenExams(int id);
	List<ExamRegistrationDTO> findActiveExams(int id);
	List<StudentBasicInfoDTO> getNotEnrolledStudents(int id);
	List<FinancialCardDTO> getFinancialCardInfo( int id);
	int registerExam(int studentId, int examId);
	List<ExamDTO> getCurrentExams(int id);
	
	List<EnrollmentDTO> enrollUserToProgrammeCourses(int studentId, int programmeId);
}
