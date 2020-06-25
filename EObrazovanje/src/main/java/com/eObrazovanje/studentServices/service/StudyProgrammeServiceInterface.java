package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.entity.StudyProgramme;

public interface StudyProgrammeServiceInterface {
	
	StudyProgramme findOne(int id);
	List<StudyProgramme> findAll();
	int save(StudyProgramme studyProgramme);

}
