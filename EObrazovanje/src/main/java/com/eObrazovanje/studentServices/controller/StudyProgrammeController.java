package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.entity.StudyProgramme;
import com.eObrazovanje.studentServices.service.StudyProgrammeServiceInterface;

@RestController
@RequestMapping(value = "api/studyProgramme")
@CrossOrigin(value = "*")
public class StudyProgrammeController {
	
	@Autowired
	StudyProgrammeServiceInterface studyProgrammeServiceInterface;
	
	@GetMapping
	private List<StudyProgramme> getAll() {	
		return studyProgrammeServiceInterface.findAll();
	}

}
