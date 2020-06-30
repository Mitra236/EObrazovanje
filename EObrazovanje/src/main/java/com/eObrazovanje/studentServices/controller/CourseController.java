package com.eObrazovanje.studentServices.controller;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.DTO.EnrollmentDTO;
import com.eObrazovanje.studentServices.DTO.ProfessorCourseDetailsDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.service.CourseServiceInterface;
import com.eObrazovanje.studentServices.service.EnrollmentServiceInterface;
import com.eObrazovanje.studentServices.service.StudyProgrammeServiceInterface;

@RestController
@RequestMapping(value = "api/courses")
@CrossOrigin(value = "*")
public class CourseController {
	
	@Autowired
	CourseServiceInterface courseServiceInterface;
	
	@Autowired
	EnrollmentServiceInterface enrollmentServiceInterface;
	
	@Autowired
	StudyProgrammeServiceInterface studyProgrammeServiceInterface;
	
	@GetMapping
	private ResponseEntity<List<CourseDTO>> getAll() {	
		List<CourseDTO> courses = new ArrayList<>();
		for(CourseDTO c: courseServiceInterface.findAll()) {
			courses.add(c);
		}
		return new ResponseEntity<List<CourseDTO>>(courses, HttpStatus.OK);
	}
	
	@GetMapping(value="/course")
	private ResponseEntity<CourseDTO> getCourse(@RequestParam("id") int id) {
		Course course = courseServiceInterface.findOne(id);
		if (course == null) return new ResponseEntity<CourseDTO>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<CourseDTO>(new CourseDTO(course), HttpStatus.OK);
	}
	
	@GetMapping(value="/studentCourse")
	private ResponseEntity<List<EnrollmentDTO>> getStudentCourse(@RequestParam ("id") int id) {
		Course course = courseServiceInterface.findOne(id);
		if (course == null) return new ResponseEntity<List<EnrollmentDTO>>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<EnrollmentDTO>>(enrollmentServiceInterface.getEnrolledStudents(id), HttpStatus.OK);
	}
	
	@GetMapping(value="/professorCourses")
	private ResponseEntity<List<CourseDTO>> getProfessorCourses(@RequestParam("id") int id) {
		List<CourseDTO> coursesDTO = courseServiceInterface.findProfessorCourses(id);
		if (coursesDTO.size() <= 0) {
			return new ResponseEntity<List<CourseDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CourseDTO>>(coursesDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/courseStudent")
	private ResponseEntity<ProfessorCourseDetailsDTO> findCourseStudents(@RequestParam("id") int id) {
		ProfessorCourseDetailsDTO courseDTO = courseServiceInterface.findCourseStudents(id);
		if(courseDTO == null) {
			return new ResponseEntity<ProfessorCourseDetailsDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProfessorCourseDetailsDTO>(courseDTO, HttpStatus.OK);
	}
	
	@PutMapping(consumes = "application/json")
	private ResponseEntity<Void> editCourse(@RequestBody CourseDTO editedCourse) {
		Course course = courseServiceInterface.findOne(editedCourse.id);
		if (course == null) return new ResponseEntity<Void>(HttpStatus.NOT_FOUND); 
		
		course.setName(editedCourse.name);
		course.setCourseCode(editedCourse.courseCode);
		course.setLectures(editedCourse.lectures);
		course.setECTS(editedCourse.ECTS);
		course.setPracticalCLasses(editedCourse.practicalClasses);
		course.setStudyProgramme(studyProgrammeServiceInterface.findOne(editedCourse.studyProgramme.id));
		courseServiceInterface.update(course);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PostMapping(consumes = "application/json")
	private ResponseEntity<Integer> addCourse(@RequestBody CourseDTO course) {
		if (course == null) return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND); 
		
		Course newCourse = new Course();
		newCourse.setName(course.name);
		newCourse.setECTS(course.ECTS);
		newCourse.setCourseCode(course.courseCode);
		newCourse.setLectures(course.lectures);
		newCourse.setPracticalCLasses(course.practicalClasses);
		newCourse.setStudyProgramme(studyProgrammeServiceInterface.findOne(course.studyProgramme.id));	
		courseServiceInterface.save(newCourse);
		
		return new ResponseEntity<Integer>(newCourse.getId(), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/courseStudent", consumes = "application/json")
	private ResponseEntity<Integer> addCourseStudent(@RequestBody CourseDTO course) {
		if (course == null) return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND); 
		
		courseServiceInterface.saveCourseStudents(course);
		
		return new ResponseEntity<Integer>(course.id, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	private ResponseEntity<Boolean> deleteCourse(@PathVariable("id") int id) {
		Course course = courseServiceInterface.findOne(id);
		if (course == null) return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND); 
		
		courseServiceInterface.remove(id);	
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
}
