package com.eObrazovanje.studentServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.repository.ExamRepository;

@Service
public class ExamService implements ExamServiceInterface{
	
	@Autowired
	ExamRepository examRepo;

	@Override
	public Exam findOne(int id) {
		return examRepo.findById(id).orElse(null);
	}

	@Override
	public List<Exam> findAll() {
		return examRepo.findAll();
	}

	@Override
	public int save(Exam exam) {
		return examRepo.save(exam).getId();
	}

	@Override
	public boolean remove(int id) {
		examRepo.deleteById(id);
		return true;
	}

}
