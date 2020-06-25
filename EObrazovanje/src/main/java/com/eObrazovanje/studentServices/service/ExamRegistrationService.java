package com.eObrazovanje.studentServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.entity.ExamRegistration;
import com.eObrazovanje.studentServices.repository.ExamRegistrationRepository;

@Service
public class ExamRegistrationService implements ExamRegistrationSServiceInterface{
	
	@Autowired
	ExamRegistrationRepository examRegRepo;

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

}
