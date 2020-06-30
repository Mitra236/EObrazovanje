package com.eObrazovanje.studentServices.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.ExamPeriodDTO;
import com.eObrazovanje.studentServices.entity.ExamPeriod;
import com.eObrazovanje.studentServices.repository.ExamPeriodRepository;

@Service
public class ExamPeriodService implements ExamPeriodServiceInterface {
	
	@Autowired
	ExamPeriodRepository examPeriodRepo;

	@Override
	public ExamPeriodDTO findOne(int id) {
		return new ExamPeriodDTO(examPeriodRepo.findById(id).orElse(null));
	}

	@Override
	public List<ExamPeriodDTO> findAll() {
		List<ExamPeriodDTO> examPeriodDTOs = new ArrayList<ExamPeriodDTO>();
		for (ExamPeriod e: examPeriodRepo.findAll()) {
			examPeriodDTOs.add(new ExamPeriodDTO(e));
		}
		return examPeriodDTOs;
	}

	@Override
	public int save(ExamPeriodDTO examPeriodDTO) {
		ExamPeriod examPeriod = new ExamPeriod();
		examPeriod.setExamName(examPeriodDTO.examPeriodName);
		examPeriod.setStartDate(examPeriodDTO.startDate);
		examPeriod.setEndDate(examPeriodDTO.endDate);
		examPeriod.setPaymentAmount(200);
		return examPeriodRepo.save(examPeriod).getId();
	}

	@Override
	public boolean remove(int id) {
		ExamPeriod examPeriod = examPeriodRepo.findById(id).orElse(null);
		if(examPeriod == null) {
			return false;
		}
		examPeriodRepo.deleteById(id);
		return true;
	}

	@Override
	public void update(ExamPeriodDTO examPeriodDTO) {
		ExamPeriod examPeriod = examPeriodRepo.findById(examPeriodDTO.id).orElse(null);
		examPeriod.setExamName(examPeriodDTO.examPeriodName);
		examPeriod.setStartDate(examPeriodDTO.startDate);
		examPeriod.setEndDate(examPeriodDTO.endDate);
		examPeriodRepo.save(examPeriod);
	}

}
