package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;

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
	public String professorName;
	
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
		if(course.getProfessors().size() > 0) {
			this.professorName = course.getProfessors().get(0).getFirstName() + course.getProfessors().get(0).getLastName();
		}
	}
}
