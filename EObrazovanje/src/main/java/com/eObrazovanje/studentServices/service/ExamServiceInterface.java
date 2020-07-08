package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.DTO.ExamAdminDTO;
import com.eObrazovanje.studentServices.DTO.ExamDTO;

public interface ExamServiceInterface {
	
	ExamDTO findOne(int id);
	ExamAdminDTO findOneAdmin(int id);
	List<ExamDTO> findAll();
	int save(ExamAdminDTO exam);
	boolean remove(int id);
	void update(ExamAdminDTO exam);
	List<ExamDTO> getCurrentExams(int studyProgrammeId);
	List<ExamDTO> getExamsByExamPeriod(int id, String period);
	List<ExamAdminDTO> getExamsJanuary(int id, String period);
}
