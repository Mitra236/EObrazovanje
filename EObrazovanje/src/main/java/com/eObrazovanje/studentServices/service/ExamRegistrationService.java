package com.eObrazovanje.studentServices.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.CourseDTO;
import com.eObrazovanje.studentServices.DTO.ExamPointsDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationCheckDTO;
import com.eObrazovanje.studentServices.DTO.ExamRegistrationDTO;
import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.entity.Course;
import com.eObrazovanje.studentServices.entity.EExamStatus;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.entity.ExamRegistration;
import com.eObrazovanje.studentServices.repository.CourseRepository;
import com.eObrazovanje.studentServices.repository.ExamRegistrationRepository;
import com.eObrazovanje.studentServices.repository.ExamRepository;
import com.eObrazovanje.studentServices.repository.StudentRepository;

@Service
public class ExamRegistrationService implements ExamRegistrationSServiceInterface{
	
	@Autowired
	ExamRegistrationRepository examRegRepo;
	
	@Autowired
	ExamRepository examRepo;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	StudentRepository studentRepo;

	@Override
	public ExamRegistrationDTO findOne(int id) {
		return new ExamRegistrationDTO(examRegRepo.findById(id).orElse(null));
	}

	@Override
	public List<ExamRegistrationDTO> findAll() {
		List<ExamRegistrationDTO> examRegDTOs = new ArrayList<ExamRegistrationDTO>();
		for (ExamRegistration e: examRegRepo.findAll()) {
			examRegDTOs.add(new ExamRegistrationDTO(e));
		}
		return examRegDTOs;
	}

	@Override
	public int save(ExamRegistrationDTO examRegistrationDTO) {
		
		ExamRegistration examRegistration = new ExamRegistration();
		return examRegRepo.save(examRegistration).getId();
	}

	@Override
	public boolean remove(int id) {
		examRegRepo.deleteById(id);
		return true;
	}

	@Override
	public void addFinalPoints(ExamPointsDTO examRegistration) {

		ExamRegistration examReg = examRegRepo.findById(examRegistration.id).orElse(null);
		Exam exam = examReg.getExam();

		int finalPoints;
		exam.setExamPoints(examRegistration.examPoints);
		exam.setLabPoints(examRegistration.labPoints);
		finalPoints = examReg.getExam().getExamPoints() + examReg.getExam().getLabPoints();	
		
		if (finalPoints >= 51 && finalPoints < 61) {
			examReg.setFinalGrade(6);
			examReg.setStatus(EExamStatus.Passed);
		} else if (finalPoints >= 61 && finalPoints < 71) {
			examReg.setFinalGrade(7);
			examReg.setStatus(EExamStatus.Passed);
		} else if (finalPoints >= 71 && finalPoints < 81) {
			examReg.setFinalGrade(8);
			examReg.setStatus(EExamStatus.Passed);
		} else if (finalPoints >= 81 && finalPoints < 91) {
			examReg.setFinalGrade(9);
			examReg.setStatus(EExamStatus.Passed);
		} else if (finalPoints >= 91 && finalPoints <= 100) {
			examReg.setFinalGrade(10);
			examReg.setStatus(EExamStatus.Passed);
		} else if (finalPoints < 51){
			examReg.setFinalGrade(5);
			examReg.setStatus(EExamStatus.Failed);
		} else {
			examReg.setStatus(EExamStatus.ND);
		}
		
		examRepo.save(exam);
		examRegRepo.save(examReg);
	}
	
	@Override
	public void checkRegistration(int id) {
		ExamRegistration examRegistration = examRegRepo.findById(id).orElse(null);
		examRegistration.setChecked(true);
		examRegRepo.save(examRegistration);	
	}
	
	@Override
	public List<ExamRegistrationDTO> getActiveProfessorExams(int id) {
		List<ExamRegistrationDTO> examRegistrationDTOs = new ArrayList<>();

		java.util.Date date = new java.util.Date();
		Calendar calCurrent = Calendar.getInstance();
		Calendar calExam = Calendar.getInstance();
		calCurrent.setTime(date);
		int month = calCurrent.get(Calendar.MONTH);
		int examMonth;
		
		for (Course c: courseRepo.findProfessorCourses(id)) {
			for(Exam e: c.getExams()) {			
				for (ExamRegistration er: e.getExamRegistrations()) {
					calExam.setTime(er.getExam().getPeriod().getStartDate());
					examMonth = calExam.get(Calendar.MONTH);
					if(month == examMonth && er.isChecked() == false && er.getExam().getCourse().getId() == c.getId()) {
						ExamRegistrationDTO examRegistrationDTO = new ExamRegistrationDTO();
						examRegistrationDTO.id = er.getId();
						examRegistrationDTO.examPoints = er.getExam().getExamPoints();
						examRegistrationDTO.labPoints = er.getExam().getLabPoints();
						examRegistrationDTO.finalGrade = er.getFinalGrade();
						examRegistrationDTO.courseName = er.getExam().getCourse().getName();
						examRegistrationDTO.status = er.getStatus();
						examRegistrationDTO.ECTS = er.getExam().getCourse().getECTS();
						examRegistrationDTO.studentId = er.getStudent().getId();
						examRegistrationDTO.date = er.getExam().getExam_date();
						examRegistrationDTOs.add(examRegistrationDTO);
					}
				
				}
			}		
		}
		return examRegistrationDTOs;
	}

	@Override
	public List<ExamRegistrationCheckDTO> getNotCheckedExamsInActivePeriod(int id) {
		List<ExamRegistrationCheckDTO> examRegistrationDTOs = new ArrayList<>();

		java.util.Date date = new java.util.Date();
		Calendar calCurrent = Calendar.getInstance();
		Calendar calExam = Calendar.getInstance();
		calCurrent.setTime(date);
		int month = calCurrent.get(Calendar.MONTH);
		int examMonth;
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		Course course = courseRepo.findById(id).orElse(null);
		List<Exam> exams = course.getExams();
		for(Exam e: exams) {
			for (ExamRegistration er: e.getExamRegistrations()) {
				calExam.setTime(e.getPeriod().getStartDate());
				examMonth = calExam.get(Calendar.MONTH);
				if(month == examMonth && er.isChecked() == false && timestamp.after(er.getExam().getExam_date())) {
					ExamRegistrationCheckDTO examRegistrationDTO = new ExamRegistrationCheckDTO();
					examRegistrationDTO.id = er.getId();
					examRegistrationDTO.finalGrade = er.getFinalGrade();
					examRegistrationDTO.courseName = er.getExam().getCourse().getName();
					examRegistrationDTO.status = er.getStatus();
					examRegistrationDTO.student = new StudentDTO(er.getStudent());
					examRegistrationDTO.date = er.getExam().getExam_date();
					examRegistrationDTOs.add(examRegistrationDTO);
				}
			}		
		}	
		
		return examRegistrationDTOs;
	}

	@Override
	public ExamRegistrationCheckDTO findOneChecked(int id) {
		return new ExamRegistrationCheckDTO(examRegRepo.findById(id).orElse(null));
	}

	@Override
	public CourseDTO findCourseForExam(int id) {
		ExamRegistration examReg = examRegRepo.findById(id).orElse(null);
		Exam exam = examReg.getExam();
		CourseDTO courseDTO = new CourseDTO(exam.getCourse());
		return courseDTO;
	}
	
}
