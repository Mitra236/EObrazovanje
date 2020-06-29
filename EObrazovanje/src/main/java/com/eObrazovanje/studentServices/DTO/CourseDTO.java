package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.eObrazovanje.studentServices.entity.Course;

public class CourseDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public int id;
	public String name;
	public String courseCode;
	public int ECTS;
	public int lectures;
	public int practicalClasses;
	public StudyProgrammeDTO studyProgramme;
	public List<EnrollmentDTO> enrollmentDTOs;
	
	public CourseDTO() {
		super();
	}

	public CourseDTO(Course course) {
		this.name = course.getName();
		this.courseCode = course.getCourseCode();
		this.ECTS = course.getECTS();
		this.lectures = course.getLectures();
		this.practicalClasses = course.getPracticalCLasses();
		this.studyProgramme = new StudyProgrammeDTO(course.getStudyProgramme());
		this.enrollmentDTOs = new ArrayList<EnrollmentDTO>();
	}
}
