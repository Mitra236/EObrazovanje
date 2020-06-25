package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.service.CourseServiceInterface;

@RestController
@RequestMapping(value = "api/courses")
public class CourseController {
	
	@Autowired
	CourseServiceInterface courseServiceInterface;
	
	@GetMapping
	private List<Course> getAll() {	
		return courseServiceInterface.findAll();
	}

}
