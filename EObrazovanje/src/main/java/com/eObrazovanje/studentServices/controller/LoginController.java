package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.LoggedInUserDTO;
import com.eObrazovanje.studentServices.entity.Admin;
import com.eObrazovanje.studentServices.entity.Professor;
import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.service.AdminServiceInterface;
import com.eObrazovanje.studentServices.service.ProfessorServiceInterface;
import com.eObrazovanje.studentServices.service.StudentServiceInterface;

@RestController
@RequestMapping(value = "api/login")
@CrossOrigin(value = "*")
public class LoginController {
	
	@Autowired
	AdminServiceInterface adminServiceInterface;
	
	@Autowired
	StudentServiceInterface studentServiceInterface;
	
	@Autowired
	ProfessorServiceInterface professorServiceInterface;
	
	@PostMapping(consumes = "application/json")
	private ResponseEntity<LoggedInUserDTO> login(@RequestBody LoggedInUserDTO loggedInUserDTO) {
		if(loggedInUserDTO == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		for(Admin a: adminServiceInterface.findAll()) {
			if(a.getUsername().equals(loggedInUserDTO.username) && a.getPassword().equals(loggedInUserDTO.password)) {
				loggedInUserDTO.id = a.getId();
				loggedInUserDTO.role = "admin";
			} 
		}
		
		for(Professor p: professorServiceInterface.findAllProfessors()) {
			if(p.getUsername().equals(loggedInUserDTO.username) && p.getPassword().equals(loggedInUserDTO.password)) { 
				System.out.println("is it");
				loggedInUserDTO.id = p.getId();
				loggedInUserDTO.role = "professor";
			}
		}
		
		for(Student s: studentServiceInterface.findAllStudents()) {
			if(s.getUsername().equals(loggedInUserDTO.username) && s.getPassword().equals(loggedInUserDTO.password)) { 
				loggedInUserDTO.id = s.getId();
				loggedInUserDTO.role = "student";
			} 
		}
		
		return new ResponseEntity<LoggedInUserDTO>(loggedInUserDTO, HttpStatus.OK);
	}

}
