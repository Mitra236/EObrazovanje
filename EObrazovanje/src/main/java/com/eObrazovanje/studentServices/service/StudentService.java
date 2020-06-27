package com.eObrazovanje.studentServices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eObrazovanje.studentServices.DTO.StudentDTO;
import com.eObrazovanje.studentServices.entity.EExamStatus;
import com.eObrazovanje.studentServices.entity.Exam;
import com.eObrazovanje.studentServices.entity.Student;
import com.eObrazovanje.studentServices.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceInterface {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public StudentDTO findOne(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepository.findById(id).orElse(null);
		
		return new StudentDTO(student);
	}

	@Override
	public List<StudentDTO> findAll() {
		// TODO Auto-generated method stub
		List<Student> students = studentRepository.findAll();
		
		List<StudentDTO> studentsDTOs = new ArrayList<>();
		for(Student stud : students) {
			studentsDTOs.add(new StudentDTO(stud));
		}
		
		return studentsDTOs;
	}

	@Override
	public int save(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student).getId();
	}

//	@Override
//	public List<Exam> findPassedExams(int id) {
//		// TODO Auto-generated method stub
//		Student student = studentRepository.findById(id).orElse(null);
//		List<Exam> passedExams = new ArrayList<Exam>();
//		
//		if(student != null && student.getExamsTaken() != null && student.getExamsTaken().size() > 0 ) {
//			passedExams = filterExams(EExamStatus.Passed,student.getExamsTaken() );
//		}
//		
//		return passedExams;
//	}
//
//	@Override
//	public List<Exam> findFailedExams(int id) {
//		// TODO Auto-generated method stub
//		Student student = studentRepository.findById(id).orElse(null);
//		List<Exam> failedExams = new ArrayList<Exam>();
//		
//		if(student != null && student.getExamsTaken() != null && student.getExamsTaken().size() > 0 ) {
//			failedExams = filterExams(EExamStatus.Failed,student.getExamsTaken() );
//		}
//		
//		return failedExams;
//	}
//	
//	public List<Exam> filterExams(EExamStatus status, List<Exam> exams){
//		List<Exam> filteredExams = new ArrayList<Exam>();
//		
//		for(Exam e : exams) {
//			if(e.getStatus() == status) {
//				filteredExams.add(e);
//			}
//		}
//		
//		return filteredExams;
//	}
//
//	@Override
//	public List<Exam> findTakenExams(int id) {
//		// TODO Auto-generated method stub
//		Student student = studentRepository.findById(id).orElse(null);
//		
//		List<Exam> exams = new ArrayList<>();
//		
//		if(student != null) {
//			exams = student.getExamsTaken();
//		}
//		return exams;
//	}

}
