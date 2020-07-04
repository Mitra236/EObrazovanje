package com.eObrazovanje.studentServices.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.ExamDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.repository.CourseRepository;
import com.eObrazovanje.studentServices.repository.ExamRepository;
import com.eObrazovanje.studentServices.repository.ProfessorRepository;

@Service
public class ExamService implements ExamServiceInterface{
	
	@Autowired
	ExamRepository examRepo;
	
	@Autowired
	ProfessorRepository professorRepo;
	
	@Autowired
	CourseRepository courseRepo;

	@Override
	public ExamDTO findOne(int id) {
		return new ExamDTO(examRepo.findById(id).orElse(null));
	}

	@Override
	public List<ExamDTO> findAll() {
		List<Exam> allExams = examRepo.findAll();
		List<ExamDTO> examsDTO = new ArrayList<>();
		
		if(allExams.size() > 0) {
			for(Exam e : allExams) {
				examsDTO.add(new ExamDTO(e));
			}
		}
		
		return examsDTO;
	}

	@Override
	public int save(Exam exam) {
		return examRepo.save(exam).getId();
	}

	@Override
	public boolean remove(int id) {
		examRepo.deleteById(id);
		return true;
	}
	
	@Override
	public List<ExamDTO> getCurrentExams(int studyProgrammeId) {
		List<Exam> allExams = examRepo.findAll();
		List<ExamDTO> currentExams = new ArrayList<>();
		
		Date currentDate = new Date(new java.util.Date().getTime());
		
		for (Exam e : allExams) {
			if(e.getExamPeriod().getEndDate().after(currentDate) && 
					e.getExamPeriod().getStartDate().before(currentDate) && 
					e.getCourse().getStudyProgramme().getId() == studyProgrammeId) {
				currentExams.add(new ExamDTO(e));
			}
		}
		
		return currentExams;
	}

	@Override
	public List<ExamDTO> getExamsByExamPeriod(int id, String period) {
		List<ExamDTO> examDTOs = new ArrayList<>();
		for (Course c: courseRepo.findProfessorCourses(id)) {
			for (Exam e: c.getExams()) {
				if(e.getExamPeriod().getExamName().toString().equalsIgnoreCase(period)) {
					examDTOs.add(new ExamDTO(e));
				}
			}	
		}
		return examDTOs;
	}

}
