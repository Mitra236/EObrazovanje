package com.eObrazovanje.studentServices.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.Professor;
import com.eObrazovanje.studentServices.repository.CourseRepository;
import com.eObrazovanje.studentServices.repository.ProfessorRepository;

@Service
public class ProfessorService implements ProfessorServiceInterface {

	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	CourseRepository courseRepo;

	@Override
	public Professor findOne(int id) {
		// TODO Auto-generated method stub
		return professorRepository.findById(id).orElse(null);
	}

	@Override
	public List<Professor> findAll() {
		
		return professorRepository.findAll();
	}

	@Override
	public int save(Professor valuta) {
		// TODO Auto-generated method stub
		return professorRepository.save(valuta).getId();
	}

	@Override
	public List<CourseDTO> findProfessorCourses(int id) {
		List<CourseDTO> coursesDTO = new ArrayList<CourseDTO>();
		List<Course> courseDTOs = courseRepo.findAll();
		
		Professor professor = professorRepository.findById(id).orElse(null);
		Course course1 = courseRepo.findById(1).orElse(null);
		Course course2 = courseRepo.findById(2).orElse(null);
		Course course3 = courseRepo.findById(3).orElse(null);
		
		professor.getCourses().add(course1);
		professor.getCourses().add(course2);
		professor.getCourses().add(course3);
		
		for(Course c: courseDTOs) {
			c.getProfessors().add(professor);
			for (Professor p: c.getProfessors()) {
				if (p.getId() == professor.getId()) {
					coursesDTO.add(new CourseDTO(c));
				}
			}
		}

		return coursesDTO;
	}

}
