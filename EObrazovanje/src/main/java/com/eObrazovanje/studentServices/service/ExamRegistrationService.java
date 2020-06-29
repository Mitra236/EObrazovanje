package com.eObrazovanje.studentServices.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.ExamPointsDTO;
import com.eObrazovanje.studentServices.entity.EExamStatus;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.entity.ExamRegistration;
import com.eObrazovanje.studentServices.repository.ExamRegistrationRepository;
import com.eObrazovanje.studentServices.repository.ExamRepository;
import com.eObrazovanje.studentServices.repository.StudentRepository;

@Service
public class ExamRegistrationService implements ExamRegistrationSServiceInterface{
	
	@Autowired
	ExamRegistrationRepository examRegRepo;
	
	@Autowired
	StudentRepository registeredStudentRepo;
	
	@Autowired
	ExamRepository examRepo;

	@Override
	public ExamRegistration findOne(int id) {
		return examRegRepo.findById(id).orElse(null);
	}

	@Override
	public List<ExamRegistration> findAll() {
		return examRegRepo.findAll();
	}

	@Override
	public int save(ExamRegistration examRegistration) {
		return examRegRepo.save(examRegistration).getId();
	}

	@Override
	public boolean remove(int id) {
		examRegRepo.deleteById(id);
		return true;
	}

	@Override
	public void addFinalPoints(ExamPointsDTO examRegistration) {

		ExamRegistration examReg = examRegRepo.findById(examRegistration.id).orElse(null);
		Exam exam = examReg.getExam();

		int finalPoints;
		exam.setExamPoints(examRegistration.exam.examPoints);
		exam.setLabPoints(examRegistration.exam.labPoints);
		finalPoints = examReg.getExam().getExamPoints() + examReg.getExam().getLabPoints();	
		
		if (finalPoints >= 51 && finalPoints < 61) {
			examReg.setFinalGrade(6);
			examReg.setStatus(EExamStatus.Passed);
		} else if (finalPoints >= 61 && finalPoints < 71) {
			examReg.setFinalGrade(7);
			examReg.setStatus(EExamStatus.Passed);
		} else if (finalPoints >= 71 && finalPoints < 81) {
			examReg.setFinalGrade(8);
			examReg.setStatus(EExamStatus.Passed);
		} else if (finalPoints >= 81 && finalPoints < 91) {
			examReg.setFinalGrade(9);
			examReg.setStatus(EExamStatus.Passed);
		} else if (finalPoints >= 91 && finalPoints <= 100) {
			examReg.setFinalGrade(10);
			examReg.setStatus(EExamStatus.Passed);
		} else if (finalPoints < 51){
			examReg.setFinalGrade(5);
			examReg.setStatus(EExamStatus.Failed);
		} else {
			examReg.setStatus(EExamStatus.ND);
		}
		
		examRepo.save(exam);
		examRegRepo.save(examReg);
	}

}
