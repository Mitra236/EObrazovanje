package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eObrazovanje.studentServices.DTO.ProfessorDTO;
import com.eObrazovanje.studentServices.service.ProfessorServiceInterface;

@RestController
@RequestMapping("api/professors")
public class ProfessorController {

	@Autowired
	ProfessorServiceInterface professorServiceInterface;
	
	@GetMapping
	private List<ProfessorDTO> getAdmins() {
		
		return professorServiceInterface.findAll();
	}
	
}
