package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.entity.Exam;

public interface ExamServiceInterface {
	
	Exam findOne(int id);
	List<Exam> findAll();
	int save(Exam exam);
	boolean remove(int id);

}
