package com.eObrazovanje.studentServices.service;

import java.util.List;
import com.eObrazovanje.studentServices.DTO.ExamPointsDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationCheckDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationDTO;

public interface ExamRegistrationSServiceInterface {
	
	ExamRegistrationDTO findOne(int id);
	ExamRegistrationCheckDTO findOneChecked(int id);
	List<ExamRegistrationDTO> findAll();
	int save(ExamRegistrationDTO examRegistration);
	boolean remove(int id);
	void addFinalPoints(ExamPointsDTO examRegistration);
	List<ExamRegistrationDTO> getActiveProfessorExams(int id);
	List<ExamRegistrationCheckDTO> getNotCheckedExamsInActivePeriod(int id);
	void checkRegistration(int id);
}
