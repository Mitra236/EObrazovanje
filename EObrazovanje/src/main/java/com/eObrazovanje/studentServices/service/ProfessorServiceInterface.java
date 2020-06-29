package com.eObrazovanje.studentServices.service;

import java.util.List;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.entity.Admin;
import com.eObrazovanje.studentServices.entity.Professor;

public interface ProfessorServiceInterface {

	Professor findOne(int id);
	List<Professor> findAll();
	int save(Professor valuta);
	List<CourseDTO> findProfessorCourses(int id);
}
