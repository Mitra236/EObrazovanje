package com.eObrazovanje.studentServices.DTO;

import java.io.Serializable;
import java.util.ArrayList;

import com.eObrazovanje.studentServices.entity.Course;

public class CourseToAddDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public int id;
	public String name;
	public String courseCode;
	public int ECTS;
	public int lectures;
	public int practicalClasses;

	
	
	public CourseToAddDTO() {
		super();
	}


	public CourseToAddDTO(Course course) {
		this.id = course.getId();
		this.name = course.getName();
		this.courseCode = course.getCourseCode();
		this.ECTS = course.getECTS();
		this.lectures = course.getLectures();
		this.practicalClasses = course.getPracticalCLasses();
		
	}
	
	

}
