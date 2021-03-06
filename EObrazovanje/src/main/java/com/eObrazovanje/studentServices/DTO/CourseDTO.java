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
	public List<ProfessorDTO> professors;
	public List<ExamDTO> exams;
	public String professorName;
	
	public CourseDTO() {
		super();
	}

	public CourseDTO(Course course) {
		this.id = course.getId();
		this.name = course.getName();
		this.courseCode = course.getCourseCode();
		this.ECTS = course.getECTS();
		this.lectures = course.getLectures();
		this.practicalClasses = course.getPracticalCLasses();
		this.studyProgramme = new StudyProgrammeDTO(course.getStudyProgramme());
		this.enrollmentDTOs = new ArrayList<EnrollmentDTO>();
		this.professors = new ArrayList<ProfessorDTO>();
		this.exams = new ArrayList<ExamDTO>();
		if(course.getProfessors().size() > 0) {
			this.professorName = course.getProfessors().get(0).getFirstName() + course.getProfessors().get(0).getLastName();
		}
		
	}
}
