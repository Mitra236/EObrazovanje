package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.service.CourseServiceInterface;

@RestController
@RequestMapping(value = "api/courses")
public class CourseController {
	
	@Autowired
	CourseServiceInterface courseServiceInterface;
	
	@GetMapping
	private ResponseEntity<List<Course>> getAll() {	
		return new ResponseEntity<List<Course>>(courseServiceInterface.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/course")
	private ResponseEntity<Course> getCourse(@RequestParam("id") int id) {
		Course course = courseServiceInterface.findOne(id);
		if (course == null) { return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);}
		
		return new ResponseEntity<Course>(course, HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", consumes = "application/json")
	private ResponseEntity<Course> editCourse(@RequestBody Course editedCourse, @PathVariable("id") int id) {
		Course course = courseServiceInterface.findOne(id);
		if (course == null) { return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);}
		course.setName(editedCourse.getName());
		course.setCourseCode(editedCourse.getCourseCode());
		course.setLectures(editedCourse.getLectures());
		course.setPracticalCLasses(editedCourse.getPracticalCLasses());
		
		return new ResponseEntity<Course>(course, HttpStatus.CREATED);
	}
	
	@PostMapping(consumes = "application/json")
	private ResponseEntity<Course> addCourse(@RequestBody Course course) {
		Course newCourse = new Course();
		newCourse.setName(course.getName());
		newCourse.setECTS(course.getECTS());
		newCourse.setCourseCode(course.getCourseCode());
		newCourse.setLectures(course.getLectures());
		newCourse.setPracticalCLasses(course.getPracticalCLasses());
		
		courseServiceInterface.save(newCourse);
		
		return new ResponseEntity<Course>(newCourse, HttpStatus.CREATED);
	}

}
