package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.entity.Course;

public interface CourseServiceInterface {

	Course findOne(int id);
	List<CourseDTO> findAll();
	int save(Course course);
	boolean remove(int id);
	void update(Course course);
	int saveCourseStudents(CourseDTO course);
	List<CourseDTO> findProfessorCourses(int id);
}
