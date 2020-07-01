package com.eObrazovanje.studentServices.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.DTO.StudentDetailsDTO;
import com.eObrazovanje.studentServices.DTO.StudyProgrammeDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.StudyProgramme;
import com.eObrazovanje.studentServices.service.CourseServiceInterface;
import com.eObrazovanje.studentServices.service.StudyProgrammeServiceInterface;

@RestController
@RequestMapping(value = "api/studyProgramme")
@CrossOrigin(value = "*")
public class StudyProgrammeController {
	
	@Autowired
	StudyProgrammeServiceInterface studyProgrammeServiceInterface;
	
	@Autowired
	CourseServiceInterface courseServiceInterface;
	
	@GetMapping
	private List<StudyProgrammeDTO> getAll() {
		return studyProgrammeServiceInterface.findAll();
	}
	
	@GetMapping(value="/{studyProgrammeId}")
	private StudyProgrammeDTO getStudyProgramme(@PathVariable("studyProgrammeId") int id) {
		return studyProgrammeServiceInterface.findOne(id);
	}
	
	@PostMapping(consumes = "application/json")
	private ResponseEntity<Integer> addStudyProgramme(@RequestBody StudyProgrammeDTO prog){
		if(prog == null)
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		
		StudyProgramme newProg = new StudyProgramme();
		newProg.setName(prog.name);
		studyProgrammeServiceInterface.save(newProg);
		
		return new ResponseEntity<>(newProg.getId(), HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/programmeCourse", consumes = "application/json")
	private ResponseEntity<Integer> addCourseToProgramme(@RequestBody CourseDTO course){
		if(course == null)
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND); 
		
		StudyProgrammeDTO prog = studyProgrammeServiceInterface.findOne(course.studyProgramme.id);
		if(prog == null)
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		
		int progId = studyProgrammeServiceInterface.saveCourseToProgramme(prog, course);
		if(progId < 1)
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Integer>(prog.id, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/programmeCourse/delete/{courseId}/{studyProgrammeId}")
	private ResponseEntity<Integer> deleteCourseFromProgramme(@PathVariable("courseId") int courseId,
			@PathVariable("studyProgrammeId") int programmeId) {
		boolean response = studyProgrammeServiceInterface.removeCourseFromProgramme(courseId, programmeId);
		if(response == false)
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/programmeStudents", consumes = "application/json")
	private ResponseEntity<Integer> addStudentToProgramme(@RequestBody StudentDTO student){
		if(student == null)
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND); 
		
		StudyProgrammeDTO prog = studyProgrammeServiceInterface.findOne(student.studyProgramme.id);
		if(prog == null)
			return new ResponseEntity<Integer>(HttpStatus.BAD_REQUEST);
		
		int progId = studyProgrammeServiceInterface.saveStudentToProgramme(prog, student);
		if(progId < 1)
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Integer>(prog.id, HttpStatus.CREATED);
	}

	@DeleteMapping(value="/programmeCourse/delete/{studentId}/{studyProgrammeId}")
	private ResponseEntity<Integer> deleteStudentFromProgramme(@PathVariable("studentId") int studentId,
			@PathVariable("studyProgrammeId") int programmeId) {
		boolean response = studyProgrammeServiceInterface.removeStudentFromProgramme(studentId, programmeId);
		if(response == false)
			return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Integer>(HttpStatus.OK);
	}
	
	 
}
