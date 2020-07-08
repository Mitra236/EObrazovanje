package com.eObrazovanje.studentServices.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.ExamAdminDTO;
import com.eObrazovanje.studentServices.DTO.ExamDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.EExamPeriodName;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.entity.ExamPeriod;
import com.eObrazovanje.studentServices.entity.StudyProgramme;
import com.eObrazovanje.studentServices.repository.CourseRepository;
import com.eObrazovanje.studentServices.repository.ExamPeriodRepository;
import com.eObrazovanje.studentServices.repository.ExamRepository;
import com.eObrazovanje.studentServices.repository.ProfessorRepository;
import com.eObrazovanje.studentServices.repository.StudyProgrammeRepository;

@Service
public class ExamService implements ExamServiceInterface{
	
	@Autowired
	ExamRepository examRepo;
	
	@Autowired
	ProfessorRepository professorRepo;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	StudyProgrammeRepository studyRepo;
	
	@Autowired
	ExamPeriodRepository examPeriodRepo;

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
	public int save(ExamAdminDTO examDTO) {
		Exam exam = new Exam();
		exam.setExam_date(examDTO.date);
		exam.setClassRoom(examDTO.classroom);
		for(ExamPeriod e: examPeriodRepo.findAll()) {
			if(e.getExamName().toString().equals(examDTO.period)) {
				exam.setPeriod(examPeriodRepo.findById(e.getId()).orElse(null));
			}
		}
		exam.setCourse(courseRepo.findById(examDTO.course.id).orElse(null));
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

	@Override
	public List<ExamAdminDTO> getExamsJanuary(int id, String period) {
		List<ExamAdminDTO> exams = new ArrayList<>();
		StudyProgramme studyProgramme = studyRepo.findById(id).orElse(null);
		for (Course c: studyProgramme.getCourses()) {
			for(Exam e: c.getExams()) {
				if(e.getExamPeriod().getExamName().toString().equalsIgnoreCase(period)) {
					exams.add(new ExamAdminDTO(e));
				}
			}
		}
		
		return exams;
	}

	@Override
	public void update(ExamAdminDTO examDTO) {
		Exam exam = examRepo.findById(examDTO.id).orElse(null);
		exam.setExam_date(examDTO.date);
		exam.setClassRoom(examDTO.classroom);
		examRepo.save(exam).getId();
	}

	@Override
	public ExamAdminDTO findOneAdmin(int id) {
		return new ExamAdminDTO(examRepo.findById(id).orElse(null));
	}
}
