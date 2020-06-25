package com.eObrazovanje.studentServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.entity.Professor;
import com.eObrazovanje.studentServices.repository.ProfessorRepository;

@Service
public class ProfessorService implements ProfessorServiceInterface {

	@Autowired
	ProfessorRepository professorRepository;

	@Override
	public Professor findOne(int id) {
		// TODO Auto-generated method stub
		return professorRepository.findById(id).orElse(null);
	}

	@Override
	public List<Professor> findAll() {
		// TODO Auto-generated method stub
		return professorRepository.findAll();
	}

	@Override
	public int save(Professor valuta) {
		// TODO Auto-generated method stub
		return professorRepository.save(valuta).getId();
	}

}
