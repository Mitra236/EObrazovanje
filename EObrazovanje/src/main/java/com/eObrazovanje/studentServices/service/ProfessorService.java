package com.eObrazovanje.studentServices.service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.DTO.ProfessorDTO;
import com.eObrazovanje.studentServices.DTO.ProfessorDataEditDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.Professor;
import com.eObrazovanje.studentServices.repository.ProfessorRepository;

@Service
public class ProfessorService implements ProfessorServiceInterface {

	@Autowired
	ProfessorRepository professorRepository;

	@Override
	public ProfessorDataEditDTO findOneProfessor(int id) {
		return new ProfessorDataEditDTO(professorRepository.findById(id).orElse(null));
	}
	
	@Override
	public ProfessorDTO findOne(int id) {
		return new ProfessorDTO(professorRepository.findById(id).orElse(null));
	}

	@Override
	public List<ProfessorDTO> findAll() {
		List<ProfessorDTO> professorDTOs = new ArrayList<ProfessorDTO>();
		for(Professor p: professorRepository.findAll()) {
			professorDTOs.add(new ProfessorDTO(p));
			for (ProfessorDTO pd: professorDTOs) {
				for (Course c: p.getCourses() ) {
					pd.courseDTOs.add(new CourseDTO(c));
				}
				
			}
		}
		return professorDTOs;
	}

	@Override
	public int save(ProfessorDTO professorDTO) {
		Professor professor = new Professor();
		professor.setFirstName(professorDTO.firstName);
		professor.setLastName(professorDTO.lastName);
		professor.setUsername(professorDTO.username);
		professor.setBiography(professorDTO.biography);
		professor.setAcademicTitle(professorDTO.academicTitle);
		professor.setEmail(professorDTO.email);
		professor.setPassword(professorDTO.password);
		professor.setEmployeeFunction(professorDTO.emplyeeFunction);
		professor.setEmployeeFunctionFrom(professorDTO.employeeFunctionFrom);
		professor.setPhoneNumber(professorDTO.phoneNumber);
		professor.setPosition(professorDTO.position);
		professor.setPositionFrom(professorDTO.positionFrom);
		return professorRepository.save(professor).getId();
	}

	@Override
	public void update(ProfessorDataEditDTO professorDataEditDTO) {
		Professor professor = professorRepository.findById(professorDataEditDTO.id).orElse(null);
		professor.setFirstName(professorDataEditDTO.firstName);
		professor.setLastName(professorDataEditDTO.lastName);
		professor.setEmail(professorDataEditDTO.email);
		professor.setUsername(professorDataEditDTO.username);
		professor.setPhoneNumber(professorDataEditDTO.phoneNumber);
		professor.setJMBG(professorDataEditDTO.JMBG);
		professor.setBiography(professorDataEditDTO.biography);
		professorRepository.save(professor);
	}

	@Override
	public List<ProfessorDTO> findProfessorsForAdmin() {
		List<Professor> profs = professorRepository.findProfessorsForAdmin();
		List<ProfessorDTO> DTO = new ArrayList<>();
		for(Professor p : profs) {
			DTO.add(new ProfessorDTO(p));
		}
		return DTO;
	}

	@Override
	public void updateAllData(ProfessorDTO professorDTO) {
		Professor professor = professorRepository.findById(professorDTO.id).orElse(null);
		professor.setAcademicTitle(professorDTO.academicTitle);
		professor.setEmployeeFunction(professorDTO.emplyeeFunction);
		professor.setEmployeeFunctionFrom(professorDTO.employeeFunctionFrom);
		professor.setPosition(professorDTO.position);
		professor.setPositionFrom(professorDTO.positionFrom);
		professorRepository.save(professor);		
	}

	@Override
	public boolean remove(int id) {
		Professor professor = professorRepository.findById(id).orElse(null);
		if(professor == null) return false;
		
		professorRepository.deleteById(id);
		return false;
	}

	@Override
	public List<Professor> findAllProfessors() {
		return professorRepository.findAll();
	}
}
