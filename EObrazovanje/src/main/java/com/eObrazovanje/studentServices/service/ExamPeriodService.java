package com.eObrazovanje.studentServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.entity.ExamPeriod;
import com.eObrazovanje.studentServices.repository.ExamPeriodRepository;

@Service
public class ExamPeriodService implements ExamPeriodServiceInterface {
	
	@Autowired
	ExamPeriodRepository examPeriodRepo;

	@Override
	public ExamPeriod findOne(int id) {
		return examPeriodRepo.findById(id).orElse(null);
	}

	@Override
	public List<ExamPeriod> findAll() {
		return examPeriodRepo.findAll();
	}

	@Override
	public int save(ExamPeriod examPeriod) {
		return examPeriodRepo.save(examPeriod).getId();
	}

	@Override
	public boolean remove(int id) {
		examPeriodRepo.deleteById(id);
		return true;
	}

}
