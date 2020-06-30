package com.eObrazovanje.studentServices.service;

import java.util.List;
import com.eObrazovanje.studentServices.DTO.ExamDTO;
import com.eObrazovanje.studentServices.entity.Exam;

public interface ExamServiceInterface {
	
	ExamDTO findOne(int id);
	List<ExamDTO> findAll();
	int save(Exam exam);
	boolean remove(int id);
	List<ExamDTO> getCurrentExams(int studyProgrammeId);
	List<ExamDTO> getExamsByExamPeriod(int id, String period);
}
