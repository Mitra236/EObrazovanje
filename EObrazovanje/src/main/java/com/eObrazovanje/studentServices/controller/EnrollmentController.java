package com.eObrazovanje.studentServices.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.EnrollmentDTO;
import com.eObrazovanje.studentServices.DTO.EnrollmentToAddDTO;
import com.eObrazovanje.studentServices.DTO.StudentBasicInfoDTO;
import com.eObrazovanje.studentServices.DTO.StudentDetailsDTO;
import com.eObrazovanje.studentServices.service.EnrollmentServiceInterface;

@RestController
@RequestMapping(value = "api/enrollment")
@CrossOrigin(value = "*")
public class EnrollmentController {
	
	@Autowired
	EnrollmentServiceInterface enrollmentServiceInterface;
	
	@GetMapping(value = "enrollment")
	private ResponseEntity<EnrollmentDTO> getEnrollment(@RequestParam int id) {
		EnrollmentDTO enrollmentDTO = enrollmentServiceInterface.findOne(id);
		if(enrollmentDTO == null) return new ResponseEntity<EnrollmentDTO>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<EnrollmentDTO>(enrollmentDTO, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
		EnrollmentDTO enrollment = enrollmentServiceInterface.findOne(id);
		if(enrollment == null) {
			return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
		}
		enrollmentServiceInterface.remove(id);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}
	
	@PostMapping(consumes = "application/json")
	private ResponseEntity<Integer> addEnrollment(@RequestBody EnrollmentToAddDTO enrollmentDTO) {
		if (enrollmentDTO == null) return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		
		enrollmentServiceInterface.save(enrollmentDTO);
		
		return new ResponseEntity<Integer>(enrollmentDTO.id, HttpStatus.CREATED);
	}

}
