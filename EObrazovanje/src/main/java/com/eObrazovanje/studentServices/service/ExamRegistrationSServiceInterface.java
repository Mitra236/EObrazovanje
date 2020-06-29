package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.DTO.ExamPointsDTO;
import com.eObrazovanje.studentServices.entity.ExamRegistration;

public interface ExamRegistrationSServiceInterface {
	
	ExamRegistration findOne(int id);
	List<ExamRegistration> findAll();
	int save(ExamRegistration examRegistration);
	boolean remove(int id);
	void addFinalPoints(ExamPointsDTO examRegistration);

}
