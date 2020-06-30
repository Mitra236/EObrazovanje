package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.entity.Enrollment;
import com.eObrazovanje.studentServices.service.EnrollmentServiceInterface;

@RestController
@RequestMapping(value = "api/enrollment")
@CrossOrigin(value = "*")
public class EnrollmentController {
	
	@Autowired
	EnrollmentServiceInterface enrollmentServiceInterface;


}
