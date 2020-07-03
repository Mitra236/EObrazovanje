package com.eObrazovanje.studentServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eObrazovanje.studentServices.DTO.ProfessorDTO;
import com.eObrazovanje.studentServices.DTO.ProfessorDataEditDTO;
import com.eObrazovanje.studentServices.service.ProfessorServiceInterface;

@RestController
@RequestMapping("api/professors")
@CrossOrigin(value = "*")
public class ProfessorController {

	@Autowired
	ProfessorServiceInterface professorServiceInterface;
	
	@GetMapping
	private List<ProfessorDTO> getAdmins() {	
		return professorServiceInterface.findAll();
	}
	
	@GetMapping(value = "/professorsForAdmin")
	private List<ProfessorDTO> getProfessorsForAdmin() {	
		return professorServiceInterface.findProfessorsForAdmin();
	}
	
	@GetMapping(value = "/professor")
	private ResponseEntity<ProfessorDTO> getProfessor(@RequestParam("id") int id) {
		ProfessorDTO professorDTO = professorServiceInterface.findOne(id);
		if(professorDTO == null) {
			return new ResponseEntity<ProfessorDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProfessorDTO>(professorDTO, HttpStatus.OK);
	}
	
	@GetMapping(value = "/professorEdit")
	private ResponseEntity<ProfessorDataEditDTO> getProfessorEdit(@RequestParam("id") int id) {
		ProfessorDataEditDTO professorDTO = professorServiceInterface.findOneProfessor(id);
		if(professorDTO == null) {
			return new ResponseEntity<ProfessorDataEditDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ProfessorDataEditDTO>(professorDTO, HttpStatus.OK);
	}
	
	@PutMapping(consumes = "application/json")
	private ResponseEntity<Void> updateProfessorData(@RequestBody ProfessorDataEditDTO professorDataEditDTO) {
		if (professorDataEditDTO == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		professorServiceInterface.update(professorDataEditDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
