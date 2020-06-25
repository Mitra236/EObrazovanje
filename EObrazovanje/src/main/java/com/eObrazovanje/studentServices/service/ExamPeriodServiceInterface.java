package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.entity.ExamPeriod;

public interface ExamPeriodServiceInterface {
	
	ExamPeriod findOne(int id);
	List<ExamPeriod> findAll();
	int save(ExamPeriod examPeriod);
	boolean remove(int id);

}
