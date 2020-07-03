package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;
import java.util.List;

public class StudyProgrammeCourseDetailsDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public int id;
	public String name;
	public String courseCode;
	public String professorName;
	
	

	public StudyProgrammeCourseDetailsDTO() {
		super();
	}



	public StudyProgrammeCourseDetailsDTO(int id, String name, String courseCode, 
			String professorName) {
		super();
		this.id = id;
		this.name = name;
		this.courseCode = courseCode;
		this.professorName = professorName;
	}



}
