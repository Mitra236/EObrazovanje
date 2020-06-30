package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.eObrazovanje.studentServices.entity.Course;

public class ProfessorCourseDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public int id;
	public String name;
	public List<EnrollmentDTO> enrollmentDTOs;
	
	public ProfessorCourseDetailsDTO() {
		super();
	}
	
	public ProfessorCourseDetailsDTO(Course course) {
		this.id = course.getId();
		this.name = course.getName();
		this.enrollmentDTOs = new ArrayList<EnrollmentDTO>();
	}
}
