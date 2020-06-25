package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.DTO.ExamDTO;
import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.entity.Admin;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.entity.Student;

public interface StudentServiceInterface {

	StudentDTO findOne(int id);
	List<StudentDTO> findAll();
	int save(Student student);
	List<ExamDTO> findPassedExams(int id);
	List<ExamDTO> findFailedExams(int id);
	List<ExamDTO> findTakenExams(int id);
}
