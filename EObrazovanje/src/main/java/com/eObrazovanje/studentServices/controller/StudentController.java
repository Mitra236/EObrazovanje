package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.service.StudentServiceInterface;

@RestController
@RequestMapping("api/students")
public class StudentController {

	@Autowired
	StudentServiceInterface studentServiceInterface;
	
	@GetMapping
	private List<Student> getAdmins() {
		return studentServiceInterface.findAll();
	}
}
