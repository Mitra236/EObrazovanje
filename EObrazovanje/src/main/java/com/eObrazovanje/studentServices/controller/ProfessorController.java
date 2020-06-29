package com.eObrazovanje.studentServices.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.entity.Professor;
import com.eObrazovanje.studentServices.service.ProfessorServiceInterface;

@RestController
@RequestMapping("api/professors")
public class ProfessorController {

	@Autowired
	ProfessorServiceInterface professorServiceInterface;
	
	@GetMapping
	private List<Professor> getAdmins() {
		return professorServiceInterface.findAll();
	}
	
	@GetMapping(value = "/professorCourses")
	private ResponseEntity<List<CourseDTO>> findProfessors(@RequestParam("id") int id) {
		List<CourseDTO> courses = professorServiceInterface.findProfessorCourses(id);
		return new ResponseEntity<List<CourseDTO>>(courses, HttpStatus.OK);
	}
}
