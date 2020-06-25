package com.eObrazovanje.studentServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.entity.StudyProgramme;
import com.eObrazovanje.studentServices.repository.StudyProgrammeRepository;

@Service
public class StudyProgrammeService implements StudyProgrammeServiceInterface{
	
	@Autowired
	StudyProgrammeRepository studyProgrammeRepository;

	@Override
	public StudyProgramme findOne(int id) {
		// TODO Auto-generated method stub
		return studyProgrammeRepository.findById(id).orElse(null);
	}

	@Override
	public List<StudyProgramme> findAll() {
		// TODO Auto-generated method stub
		return studyProgrammeRepository.findAll();
	}

	@Override
	public int save(StudyProgramme studyProgramme) {
		// TODO Auto-generated method stub
		return studyProgrammeRepository.save(studyProgramme).getId();
	}

}
