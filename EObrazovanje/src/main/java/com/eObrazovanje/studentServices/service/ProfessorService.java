package com.eObrazovanje.studentServices.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.DTO.ProfessorDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.Professor;
import com.eObrazovanje.studentServices.repository.ProfessorRepository;

@Service
public class ProfessorService implements ProfessorServiceInterface {

	@Autowired
	ProfessorRepository professorRepository;

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
		professor.setCourseRole(professorDTO.eCourseRole);
		professor.setEmail(professorDTO.email);
		professor.setPassword(professorDTO.password);
		professor.setEmployeeFunction(professorDTO.emplyeeFunction);
		professor.setEmployeeFunctionFrom(professorDTO.employeeFunctionFrom);
		professor.setPhoneNumber(professorDTO.phoneNumber);
		professor.setPosition(professorDTO.position);
		professor.setPositionFrom(professorDTO.positionFrom);
		return professorRepository.save(professor).getId();
	}

}
