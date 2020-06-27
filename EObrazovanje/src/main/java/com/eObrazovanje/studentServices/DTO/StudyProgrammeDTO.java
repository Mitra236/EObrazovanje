package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;

import com.eObrazovanje.studentServices.entity.StudyProgramme;

public class StudyProgrammeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public int id;
	public String name;
	
	public StudyProgrammeDTO() {
		super();
	}

	public StudyProgrammeDTO(StudyProgramme studyProgramme) {
		this.id = studyProgramme.getId();
		this.name = studyProgramme.getName();
	}
}
