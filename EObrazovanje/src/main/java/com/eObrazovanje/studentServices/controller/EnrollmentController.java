package com.eObrazovanje.studentServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.EnrollmentDTO;
import com.eObrazovanje.studentServices.service.EnrollmentServiceInterface;

@RestController
@RequestMapping(value = "api/enrollment")
@CrossOrigin(value = "*")
public class EnrollmentController {
	
	@Autowired
	EnrollmentServiceInterface enrollmentServiceInterface;

	@DeleteMapping("/{id}")
	private ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		EnrollmentDTO enrollment = enrollmentServiceInterface.findOne(id);
		if(enrollment == null) {
			return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}

}
