package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.DTO.ExamPeriodDTO;

public interface ExamPeriodServiceInterface {
	
	ExamPeriodDTO findOne(int id);
	List<ExamPeriodDTO> findAll();
	int save(ExamPeriodDTO examPeriod);
	boolean remove(int id);
	void update(ExamPeriodDTO examPeriod);

}
