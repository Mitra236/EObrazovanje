package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.entity.StudentDocs;
import com.eObrazovanje.studentServices.service.StudentDocsServiceInterface;

@RestController
@RequestMapping(value = "api/studentDocs")
public class StudentDocsController {
	
	@Autowired
	StudentDocsServiceInterface studentDocsServiceInterface;
	
	@GetMapping
	private List<StudentDocs> getAll() {	
		return studentDocsServiceInterface.findAll();
	}

}
